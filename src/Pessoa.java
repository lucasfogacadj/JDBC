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
		
		Connection conexao = ConnectionFactory.createConnection();
		
		try {
			
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
		
		Connection conexao = ConnectionFactory.createConnection();
		
		@SuppressWarnings("resource")
		Scanner tc = new Scanner(System.in);
		
		try {
			System.out.println("Digite o nome a ser excluido: ");
			String nome=tc.next();
			String sql = "DELETE FROM pessoas WHERE  nome LIKE ?;";
			PreparedStatement comandoSQL = (PreparedStatement) conexao.prepareStatement(sql);
			comandoSQL.setString(1, nome);
			comandoSQL.execute();
			comandoSQL.close();
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
public static void removerId(){
		
	Connection conexao = ConnectionFactory.createConnection();
	
		@SuppressWarnings("resource")
		Scanner tc = new Scanner(System.in);
		
		try {
			System.out.println("Digite a id ser excluido: ");
			int id=tc.nextInt();
			String sql = "DELETE FROM pessoas where id="+id+";";
			PreparedStatement comandoSQL = (PreparedStatement) conexao.prepareStatement(sql);
			comandoSQL.execute();
			comandoSQL.close();
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
}
		
		public static void Consulta(){
			
			Connection conexao = ConnectionFactory.createConnection();
			
			@SuppressWarnings("resource")
			Scanner tc = new Scanner(System.in);
			
			try {
				System.out.println("Conectato");
				String sql = "SELECT * FROM pessoas;";
				PreparedStatement comandoSQL = (PreparedStatement) conexao.prepareStatement(sql);
				ResultSet resultado = comandoSQL.executeQuery();
				while(resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				int idade = resultado.getInt("idade");
				System.out.println("Nome "+nome);
				System.out.println("Idade"+idade);
				System.out.println("ID "+id);
				
				}
				
				comandoSQL.execute();
				comandoSQL.close();
				

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		
		
	}
		

		public static void consultaPorNome(){
			
			Connection conexao = ConnectionFactory.createConnection();
			
			@SuppressWarnings("resource")
			Scanner tc = new Scanner(System.in);
			
			try {
				System.out.println("Digite o nome a ser consultado: ");
				String nome1=tc.next();
				System.out.println("Conectato");
				String sql = "SELECT * FROM pessoas WHERE nome=?;";
				PreparedStatement comandoSQL = (PreparedStatement) conexao.prepareStatement(sql);
				comandoSQL.setString(1, nome1);
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
