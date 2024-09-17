package Principal;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {
    
    
    
	private Connection conexao;
	private final String urlBD;
	private final String User;
	private final String Password;
        
        
        
	
	public Conexao()
	{
		urlBD    = "jdbc:mysql://localhost:3306/prova1";
		User     = "root";
		Password = "root";
	}
	
	private void iniciarConexao()
	{
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexao = DriverManager.getConnection(urlBD, User, Password);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao acessar o Banco de Dados!");
			}
	}
	
	private void encerrarConexao() throws SQLException
	{
		if (conexao != null);
			conexao.close();
	}
	
	public void inserirDados(Cadastro objCadastro) throws SQLException
	{
		iniciarConexao(); // Solicita conexao com o BD
		
		if(conexao != null)
		{
			try {
				// inserir os parâmetros na tabela Cadastro
				PreparedStatement psInsert = conexao.prepareStatement("INSERT INTO cadastro(Nome, Endereco, Telefone1, CPF, TipoSanguineo, Curso, ContatodeEmergencia, Telefone2) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
				psInsert.setString(1, objCadastro.getNome());
				psInsert.setString(2, objCadastro.getEndereco());
				psInsert.setString(3, objCadastro.getTelefone());
				psInsert.setString(4, objCadastro.getCPF());
				psInsert.setString(5, objCadastro.getTipoSanguineo());
				psInsert.setString(6, objCadastro.getCurso());
				psInsert.setString(7, objCadastro.getContatoEmergencia());
				psInsert.setString(8, objCadastro.getTelefoneEmergencia());
				psInsert.execute();
				
				encerrarConexao(); // Encerra conexão com o BD
				
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				
			} catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "Erro ao realizar o cadastro. Tente novamente!");
			}
		}
	}
	
	public void alterarDados(Cadastro objCadastro, int ID) throws SQLException
	{
		iniciarConexao(); // Solicita conexao com o BD
		
		if(conexao != null)
		{
			try {
				// inserir os parâmetros na tabela Cadastro
				PreparedStatement comandoupdate = conexao.prepareStatement("UPDATE Cadastro SET Nome = ?, Endereco = ?, Telefone1 = ?, CPF = ?, TipoSanguineo = ?, Curso = ?, ContatodeEmergencia = ?, Telefone2 = ? WHERE idCadastro = ?");
				comandoupdate.setString(1, objCadastro.getNome());
				comandoupdate.setString(2, objCadastro.getEndereco());
				comandoupdate.setString(3, objCadastro.getTelefone());
				comandoupdate.setString(4, objCadastro.getCPF());
				comandoupdate.setString(5, objCadastro.getTipoSanguineo());
				comandoupdate.setString(6, objCadastro.getCurso());
				comandoupdate.setString(7, objCadastro.getContatoEmergencia());
				comandoupdate.setString(8, objCadastro.getTelefoneEmergencia());
				comandoupdate.setInt(9, ID);
				comandoupdate.execute();
				
				encerrarConexao(); // Encerra conexão com o BD
				
				JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
				
			} catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "Erro! Alteração não realizada!");
			}
		}
	}
	
	public void removerDados(int ID) throws SQLException
	{
		iniciarConexao(); // Solicita conexao com o BD
		
		if(conexao != null)
		{
			try {
				// inserir os parâmetros na tabela Cadastro
				PreparedStatement comandoupdate = conexao.prepareStatement("DELETE FROM Cadastro WHERE idCadastro = ?");
				comandoupdate.setInt(1, ID);
				comandoupdate.execute();
				
				encerrarConexao(); // Encerra conexão com o BD
				
				JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
				
			} catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "Erro! Remoção não realizada!");
			}
		}
	}
	
	public ArrayList<String> Relatorio() throws SQLException
	{
		iniciarConexao(); // Solicita conexao com o BD
		
		ArrayList<String> relatorioBD = new ArrayList<String>();
		
		if(conexao != null)
		{
			Statement comandoConsulta = conexao.createStatement();
			ResultSet resultadoConsulta = comandoConsulta.executeQuery("SELECT * FROM Cadastro");
			String resultado;
			String id;
			String nome;
			String endereco;
			String telefone;
			String cpf;
			String tiposanguineo;
			String curso;
			String contatoemergencia;
			String telefoneemergencia;
			while(resultadoConsulta.next())
			{
				id = resultadoConsulta.getString("idCadastro");
				nome = resultadoConsulta.getString("Nome");
				endereco = resultadoConsulta.getString("Endereco");
				telefone = resultadoConsulta.getString("Telefone1");
				cpf = resultadoConsulta.getString("CPF");
				tiposanguineo = resultadoConsulta.getString("TipoSanguineo");
				curso = resultadoConsulta.getString("Curso");
				contatoemergencia = resultadoConsulta.getString("ContatodeEmergencia");
				telefoneemergencia = resultadoConsulta.getString("Telefone2");
				
				resultado = "# ID: " + id + "\nNome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone + "\nCPF: " + cpf + "\nTipoSanguineo: " + tiposanguineo + "\nCurso: " + curso + "\nContato de Emergência: " + contatoemergencia + "\nTelefone de Emergência: " + telefoneemergencia + "\n\n-------------------------------------------------";
				relatorioBD.add(resultado);
			}
			
			encerrarConexao();
			return relatorioBD;
		}
		return null;
	}
}