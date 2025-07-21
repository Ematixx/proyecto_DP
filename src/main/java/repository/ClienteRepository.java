package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDB;
import model.Cliente;

public class ClienteRepository implements GenericRepository<Cliente> {

	private static final String SQL_SELECT = "SELECT * FROM clientes";
	private static final String SQL_FIND_BY_ID = "SELECT * FROM clientes WHERE id_cliente = ?";
	private static final String SQL_INSERT = "INSERT INTO clientes(nombre, email) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE clientes SET nombre = ?, email = ? WHERE id_cliente = ?";

	@Override
	public List<Cliente> findAll() {
		List<Cliente> clientes = new ArrayList<>();
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("email"));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientes;
	}

	@Override
	public Cliente findById(int id) {
		Cliente cliente = null;
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_FIND_BY_ID)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public int save(Cliente t) {
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
			stmt.setString(1, t.getNombre());
			stmt.setString(2, t.getEmail());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Cliente t) {
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {

			stmt.setString(1, t.getNombre());
			stmt.setString(2, t.getEmail());
			stmt.setInt(3, t.getId());
			return stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
