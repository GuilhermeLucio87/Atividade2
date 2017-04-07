package br.com.lojamodel.controle;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.lojamodel.Contato;
import br.com.lojamodel.dao.DAO;
import br.com.lojamodel.dao.impl.ContatoDAO;

public class ContatosControle {

	
	public void processoInserirContatos(){
		Contato contato = new Contato();
		contato.setNome("Osvaldo martins");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setEmail("voado@saulo.com");
		contato.setEndereco("Rua Vergueiro, 978");
		
		DAO contatoDAO = new ContatoDAO(); //conexão com banco de dados
		
		try {
			contatoDAO.adicionar(contato);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void processoUPDATE(){
		DAO contatoDAO = new ContatoDAO();
		
		try{
			System.out.println ("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nIniciando atualização");
			contatoDAO.update(null);
		} catch (SQLException e){
			//TODO Auto-generated catch Block
			e.printStackTrace();
		}
	}
	
	
	
	public void processoBuscaContatosID() {
		DAO contatoDAO = new ContatoDAO();
		
		try {
			List<Object> todosOsContatos = contatoDAO.buscarTodosID();
				if (todosOsContatos!=null){
					for(Object contato : todosOsContatos){
						Contato cont = (Contato)contato;
						
						System.out.println(cont.toString());
					}
				}else{
					System.out.println("Não existem " + " registros no banco de dados");
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void processoBuscaContatos() {
		DAO contatoDAO = new ContatoDAO();
		
		try {
			List<Object> todosOsContatos = contatoDAO.buscarTodos();
				if (todosOsContatos!=null){
					for(Object contato : todosOsContatos){
						Contato cont = (Contato)contato;
						
						System.out.println(cont.toString());
					}
				}else{
					System.out.println("Não existem " + " registros no banco de dados");
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void processoBuscaContatosNome() {
		DAO contatoDAO = new ContatoDAO();
		
		try {
			List<Object> todosOsContatos = contatoDAO.buscarNome();
				if (todosOsContatos!=null){
					for(Object contato : todosOsContatos){
						Contato cont = (Contato)contato;
						
						System.out.println(cont.toString());
					}
				}else{
					System.out.println("Não existem " + " registros no banco de dados");
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void processoBuscaContatos1() {
		DAO contatoDAO = new ContatoDAO();
		
		try {
			List<Object> todosOsContatos = contatoDAO.buscar();
				if (todosOsContatos!=null){
					for(Object contato : todosOsContatos){
						Contato cont = (Contato)contato;
						
						System.out.println(cont.toString());
					}
				}else{
					System.out.println("Não existem " + " registros no banco de dados");
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void removeContatos(){
		DAO contatoDAO = new ContatoDAO();
		
		try{
			System.out.println ("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nIniciando remoção");
			contatoDAO.remover(null);
			System.out.println ("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nRemovido com sucesso");
		} catch (SQLException e){
			//TODO Auto-generated catch Block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("1) Inserir Contato\n2) Buscar Contato por ID\n3) Buscar Contato por nome\n4) Mostrar todos\n5) Remover Contato por ID\n6) Atualizar Contato\n\nR : ");
		Scanner sc = new Scanner(System.in);
		int i= sc.nextInt();
		ContatosControle contatoControle = new ContatosControle();
		if (i==5)
		contatoControle.removeContatos();
		if (i==2)
		contatoControle.processoBuscaContatosID();
		if (i==1)
		contatoControle.processoInserirContatos();
		if (i==3)
		contatoControle.processoBuscaContatosNome();
		if (i==4)
		contatoControle.processoBuscaContatos1();
		if (i==6)
		contatoControle.processoUPDATE();
		
	}
}
