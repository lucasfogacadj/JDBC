import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;

import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class Pessoa {
	private int id;
	private String nome;
	private int idade;
	
	public Pessoa(){
		this.ler();
	}
	
	
	Scanner tc = new Scanner(System.in);

	
	public void ler(){
		System.out.println("Informe o nome: ");
		this.setNome(tc.next());
		System.out.println("Informe a Idade: ");
		this.setIdade(tc.nextInt());
	}
	
	public void addBanco(){
		
		String url = "jdbc:mysql://127.0.0.1/AulaAP3";
		String usuario = "root";
		String senha = "";
		
		try {
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectato");
			String sql = "INSERT INTO AulaAP3. pessoas (nome , idade) VALUES ('"+this.getNome()+"',"+this.getIdade()+");";
			PreparedStatement comandoSQL = (PreparedStatement) conexao.prepareStatement(sql);
			comandoSQL.execute();
			comandoSQL.close();
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void removerNome(){
		
		String url = "jdbc:mysql://127.0.0.1/AulaAP3";
		String usuario = "root";
		String senha = "";
		
		@SuppressWarnings("resource")
		Scanner tc = new Scanner(System.in);
		
		try {
			System.out.println("Digite o nome a ser excluido: ");
			String nome=tc.next();
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectato");
			String sql = "DELETE FROM pessoas where nome="+nome+");";
			PreparedStatement comandoSQL = (PreparedStatement) conexao.prepareStatement(sql);
			comandoSQL.execute();
			comandoSQL.close();
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
public static void removerId(){
		
		String url = "jdbc:mysql://127.0.0.1/AulaAP3";
		String usuario = "root";
		String senha = "";
		
		@SuppressWarnings("resource")
		Scanner tc = new Scanner(System.in);
		
		try {
			System.out.println("Digite a id ser excluido: ");
			int id=tc.nextInt();
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectato");
			String sql = "DELETE FROM pessoas where nome=+id";
			PreparedStatement comandoSQL = (PreparedStatement) conexao.prepareStatement(sql);
			comandoSQL.execute();
			comandoSQL.close();
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
}
		
		public static void Consulta(){
			
			String url = "jdbc:mysql://127.0.0.1/AulaAP3";
			String usuario = "root";
			String senha = "";
			
			@SuppressWarnings("resource")
			Scanner tc = new Scanner(System.in);
			
			try {
				Connection conexao = DriverManager.getConnection(url, usuario, senha);
				System.out.println("Conectato");
				String sql = "SELECT * FROM pessoas;";
				PreparedStatement comandoSQL = (PreparedStatement) conexao.prepareStatement(sql);
				ResultSet resultado = comandoSQL.executeQuery();
				while(resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				int idade = resultado.getInt("idade");
				System.out.println(nome);
				System.out.println(idade);
				System.out.println(id);
				
				}
				
				comandoSQL.execute();
				comandoSQL.close();
				

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		
		
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	

}
