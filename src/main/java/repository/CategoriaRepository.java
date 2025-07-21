package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDB;
import model.Categoria;

public class CategoriaRepository implements GenericRepository<Categoria>{
	
	private static final String SQL_SELECT = "SELECT * FROM categorias";
	private static final String SQL_FIND_BY_ID = "SELECT * FROM categorias WHERE id_categoria = ?";
	private static final String SQL_INSERT = "INSERT INTO categorias(descripcion) VALUES (?)";
	private static final String SQL_UPDATE = "UPDATE categorias SET descripcion = ? WHERE id_categoria = ?";

	@Override
	public List<Categoria> findAll() {
		List<Categoria> categorias = new ArrayList<>();
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("id_categoria"), rs.getString("descripcion"));
				categorias.add(categoria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}

	@Override
	public Categoria findById(int id) {
		Categoria categoria = null;
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_FIND_BY_ID)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				categoria = new Categoria(rs.getInt("id_categoria"), rs.getString("descripcion"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria;
	}

	@Override
	public int save(Categoria t) {
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
			stmt.setString(1, t.getDescripcion());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Categoria t) {
		try (Connection conn = ConnectionDB.getInstancia().getConexion();
				PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {
			stmt.setString(1, t.getDescripcion());
			stmt.setInt(2, t.getId());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
