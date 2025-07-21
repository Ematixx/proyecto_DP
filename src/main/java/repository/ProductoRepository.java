package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDB;
import model.Categoria;
import model.ProductoSimple;

public class ProductoRepository implements GenericRepository<ProductoSimple> {

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_FIND_BY_ID = "SELECT * FROM productos WHERE id_producto = ?";
	private static final String SQL_INSERT = "INSERT INTO productos(nombre, descripcion, precio, stock, id_categoria, tipo) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, stock = ?, id_categoria = ?, tipo = ? WHERE id_producto = ?";

	@Override
	public List<ProductoSimple> findAll() {
		List<ProductoSimple> productos = new ArrayList<>();
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				// segun el tipo
				if (!rs.getString("tipo").equals("simple"))
					continue;
				ProductoSimple producto = new ProductoSimple(rs.getInt("id"), rs.getString("nombre"),
						rs.getString("descripcion"), rs.getDouble("precio"), rs.getInt("stock"),
						new Categoria(rs.getInt("categoria_id"), ""));
				productos.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}

	@Override
	public ProductoSimple findById(int id) {
		ProductoSimple producto = null;
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_FIND_BY_ID)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() && rs.getString("tipo").equals("simple")) {
				producto = new ProductoSimple(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getDouble("precio"), rs.getInt("stock"), new Categoria(rs.getInt("categoria_id"), ""));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public int save(ProductoSimple t) {
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
			stmt.setString(1, t.getNombre());
			stmt.setString(2, t.getDescripcion());
			stmt.setDouble(3, t.getPrecio());
			stmt.setInt(4, t.getStock());
			stmt.setInt(5, t.getCategoria().getId());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(ProductoSimple t) {
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {
			stmt.setString(1, t.getNombre());
			stmt.setString(2, t.getDescripcion());
			stmt.setDouble(3, t.getPrecio());
			stmt.setInt(4, t.getStock());
			stmt.setInt(5, t.getCategoria().getId());
			stmt.setInt(6, t.getId());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
