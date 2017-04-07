package br.com.lojamodel.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.lojamodel.ConnectionFactory;
import br.com.lojamodel.Contato;
import br.com.lojamodel.dao.DAO;

public class ContatoDAO implements DAO {

	@Override
	public void adicionar(Object object) throws SQLException {
		
		Connection con = ConnectionFactory.getConnectionJDBC(); 
		
		Contato contato = (Contato) object; //castinning/ quéstinin
		
        // conectando
        Connection conn = null;
        try {
            con = new ConnectionFactory().getConnection();
            // cria um preparedStatement
            String sql = "insert into contatos" +
                    " (nome,email,endereco,dataNascimento)" +
                    " values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            // preenche os valores
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            //stmt.setDate(4, contato.getDataNascimento().getTime());
            stmt.setDate(4, new java.sql.Date(
                    Calendar.getInstance().getTimeInMillis()));

            // executa
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");            
        }catch(SQLException e) {
        	System.out.println(e);
		} finally {
			con.close();
		}
	}

	@Override
	public List<Object> buscarTodosID() throws SQLException  {
		
		List<Object> listaDeContatos = null;
		
		Connection con = new ConnectionFactory().getConnection();
		Scanner id = new Scanner (System.in);
		int i = id.nextInt();
		PreparedStatement stmt = con.prepareStatement("select * from contatos where id is "+ i);

		// executa um select
		ResultSet rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
		  if(listaDeContatos == null){
			  listaDeContatos = new ArrayList<Object>();
		  }
		
		  Contato novoContato = new Contato();
		  
		  novoContato.setNome(rs.getString("nome"));
		  novoContato.setEmail(rs.getString("email"));
		  novoContato.setId(rs.getLong("id"));
		  
		   // montando a data através do Calendar
		  Calendar data = Calendar.getInstance();
		  data.setTime(rs.getDate("dataNascimento"));
		  novoContato.setDataNascimento(data);
		  novoContato.setEndereco(rs.getString("endereco"));
		  
		  listaDeContatos.add(novoContato);
		}

		stmt.close();
		con.close();
		
		return listaDeContatos;
	}
	
	
	@Override
	public List<Object> buscarTodos1() throws SQLException  {
		
		List<Object> listaDeContatos = null;
		
		Connection con = new ConnectionFactory().getConnection();
		Scanner id = new Scanner (System.in);
		int i = id.nextInt();
		PreparedStatement stmt = con.prepareStatement("select * from contatos");

		// executa um select
		ResultSet rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
		  if(listaDeContatos == null){
			  listaDeContatos = new ArrayList<Object>();
		  }
		
		  Contato novoContato = new Contato();
		  
		  novoContato.setNome(rs.getString("nome"));
		  novoContato.setEmail(rs.getString("email"));
		  novoContato.setId(rs.getLong("id"));
		  
		   // montando a data através do Calendar
		  Calendar data = Calendar.getInstance();
		  data.setTime(rs.getDate("dataNascimento"));
		  novoContato.setDataNascimento(data);
		  novoContato.setEndereco(rs.getString("endereco"));
		  
		  listaDeContatos.add(novoContato);
		}

		stmt.close();
		con.close();
		
		return listaDeContatos;
	}
	
	@Override
	public List<Object> buscarNome() throws SQLException  {
		
		List<Object> listaDeContatos = null;
		
		Connection con = new ConnectionFactory().getConnection();
		Scanner n = new Scanner (System.in);
		String i = n.nextLine();
		PreparedStatement stmt = con.prepareStatement("select * from contatos where nome like '" +i+"%';");

		// executa um select
		ResultSet rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
		  if(listaDeContatos == null){
			  listaDeContatos = new ArrayList<Object>();
		  }
		
		  Contato novoContato = new Contato();
		  
		  novoContato.setNome(rs.getString("nome"));
		  novoContato.setEmail(rs.getString("email"));
		  novoContato.setId(rs.getLong("id"));
		  
		   // montando a data através do Calendar
		  Calendar data = Calendar.getInstance();
		  data.setTime(rs.getDate("dataNascimento"));
		  novoContato.setDataNascimento(data);
		  novoContato.setEndereco(rs.getString("endereco"));
		  
		  listaDeContatos.add(novoContato);
		}

		stmt.close();
		con.close();
		
		return listaDeContatos;
	}
	
	@Override
	public List<Object> buscar() throws SQLException  {
		
		List<Object> listaDeContatos = null;
		
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from contatos");

		// executa um select
		ResultSet rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
		  if(listaDeContatos == null){
			  listaDeContatos = new ArrayList<Object>();
		  }
		
		  Contato novoContato = new Contato();
		  
		  novoContato.setNome(rs.getString("nome"));
		  novoContato.setEmail(rs.getString("email"));
		  novoContato.setId(rs.getLong("id"));
		  
		   // montando a data através do Calendar
		  Calendar data = Calendar.getInstance();
		  data.setTime(rs.getDate("dataNascimento"));
		  novoContato.setDataNascimento(data);
		  novoContato.setEndereco(rs.getString("endereco"));
		  
		  listaDeContatos.add(novoContato);
		}

		stmt.close();
		con.close();
		
		return listaDeContatos;
	}

	

	@Override
	public void remover(Object object) throws SQLException  {
		// TODO Auto-generated method stub
		Connection con = new ConnectionFactory().getConnection();
		System.out.println ("\n\nQual ID deseja deletar?\nR : ");
		Scanner id = new Scanner (System.in);
		int i = id.nextInt();
		PreparedStatement stmt = con.prepareStatement("delete from contatos where id is "+ i);
		stmt.execute();
		stmt.close();
		con.close();

	}
	
	
	public void update(Object object) throws SQLException  {
		// TODO Auto-generated method stub
		Connection con = new ConnectionFactory().getConnection();
		System.out.println ("\n\nQual ID deseja atualizar?\nR : ");
		Scanner id = new Scanner (System.in);
		int i = id.nextInt();
		Scanner n = new Scanner (System.in);
		System.out.println ("Digite o novo nome : "); String nome = n.nextLine();
		Scanner data = new Scanner (System.in);
		Scanner email = new Scanner (System.in);
		Scanner endereco = new Scanner (System.in);
		System.out.println ("Digite o novo email : ");
		String e = email.nextLine();
		System.out.println ("Digite o endereço novo : ");
		String end = endereco.nextLine();
		PreparedStatement stmt = con.prepareStatement("update contatos " +
				"SET nome = '"+nome+"', email = '"+e+"', endereco = '"+end+"'" +
						"where id = "+i);
		stmt.execute();
		stmt.close();
		con.close();

	}

	public Object buscarPorId(Object object) throws SQLException  {
		Scanner id = new Scanner (System.in);
		int i = id.nextInt();
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from contatos where id is"+ i);

		// executa um select
		ResultSet rs = stmt.executeQuery();
		return object;
	}

	@Override
	public List<Object> buscarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
