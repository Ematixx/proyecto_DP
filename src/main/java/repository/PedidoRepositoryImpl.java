package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDB;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import patterns.composite.Producto;

public class PedidoRepositoryImpl implements PedidoRepository {

	private static final String SQL_INSERT_PEDIDO = "INSERT INTO pedido(id_cliente, estado, total, pago_tipo, envio_tipo) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_INSERT_ITEM = "INSERT INTO item_pedido(id_pedido, id_producto, cantidad) VALUES (?, ?, ?)";
	private static final String SQL_SELECT = "SELECT * FROM pedido";
	private static final String SQL_SELECT_ITEMS = "SELECT * FROM item_pedido WHERE id_pedido = ?";
	private static final String SQL_FIND_BY_ID = "SELECT * FROM pedido WHERE id_pedido = ?";

	@Override
	public List<Pedido> findAll() {
		List<Pedido> pedidos = new ArrayList<>();
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Pedido pedido = mapPedido(rs, conn);
				pedidos.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidos;
	}

	private Pedido mapPedido(ResultSet rs, Connection conn) throws SQLException {
		int pedidoId = rs.getInt("id_pedido");
		int clienteId = rs.getInt("id_cliente");
		String estado = rs.getString("estado");
		double total = rs.getDouble("total");
		String pagoTipo = rs.getString("pago_tipo");
		String envioTipo = rs.getString("envio_tipo");
		Cliente cliente = new ClienteRepository().findById(clienteId);
		List<ItemPedido> items = new ArrayList<>();
		try (PreparedStatement stmtItems = conn.prepareStatement(SQL_SELECT_ITEMS)) {
			stmtItems.setInt(1, pedidoId);
			ResultSet rsItems = stmtItems.executeQuery();
			while (rsItems.next()) {
				int productoId = rsItems.getInt("id_producto");
				int cantidad = rsItems.getInt("cantidad");
				Producto producto = new ProductoRepository().findById(productoId);
				ItemPedido item = new ItemPedido();
				item.setId(rsItems.getInt("id_item_pedido"));
				item.setProducto(producto);
				item.setCantidad(cantidad);
				items.add(item);
			}
		}
		return new Pedido(pedidoId, cliente, items, total, pagoTipo, envioTipo, estado);
	}

	@Override
	public Pedido findById(int id) {
		Pedido pedido = null;
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_FIND_BY_ID)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				pedido = mapPedido(rs, conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedido;
	}

	@Override
	public int save(Pedido pedido) {
		int pedidoId = 0;
		try (Connection conn = ConnectionDB.getInstancia().getConexion()) {
			conn.setAutoCommit(false);
			// insertar Pedido
			try (PreparedStatement stmt = conn.prepareStatement(SQL_INSERT_PEDIDO, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setInt(1, pedido.getCliente().getId());
				stmt.setString(2, pedido.getEstadoPedido().obtenerNombre());
				stmt.setDouble(3, pedido.getTotal());
				stmt.setString(4, pedido.getPagosStrategy().getNombre());
				stmt.setString(5, pedido.getEnviosStrategy().getNombre());
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					pedidoId = rs.getInt(1);
				}
			}
			// insertar cada ItemPedido
			for (ItemPedido item : pedido.getItems()) {
				try (PreparedStatement stmtItem = conn.prepareStatement(SQL_INSERT_ITEM)) {
					stmtItem.setInt(1, pedidoId);
					stmtItem.setInt(2, item.getProducto().getId());
					stmtItem.setInt(3, item.getCantidad());
					stmtItem.executeUpdate();
				}
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pedidoId;
	}

}
