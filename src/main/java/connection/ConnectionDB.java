package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//singleton
public class ConnectionDB {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_inventory?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "root@322-ABC";

	//unica instancia
	private static ConnectionDB instancia;
	private Connection conexion;

	//constructor privado
	private ConnectionDB() {
		try {
			conexion = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		} catch (SQLException e) {
			System.err.println("Error al establecer conexión: " + e.getMessage());
		}
	}

	//metodo estatico para obtner la instancia
	public static synchronized ConnectionDB getInstancia() {
		if (instancia == null) {
			instancia = new ConnectionDB();
		}
		return instancia;
	}

	//devuielve la conexion
	public Connection getConexion() {
		try {
			return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		} catch (SQLException e) {
			System.err.println("Error al obtener conexión: " + e.getMessage());
			return null;
		}
	}

	//cierra la conexion
	public void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
				conexion = null;
			} catch (SQLException e) {
				System.err.println("Error al cerrar la conexión: " + e.getMessage());
			}
		}
	}

}
