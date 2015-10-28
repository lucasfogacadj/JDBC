import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {


	public static Connection createConnection() {
		
		String url = "jdbc:mysql://127.0.0.1/AulaAP3";
		String usuario = "root";
		String senha = "";

		Connection conexao = null;

		try {
			conexao = DriverManager.getConnection(url, usuario, senha);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conexao;
	}

}

