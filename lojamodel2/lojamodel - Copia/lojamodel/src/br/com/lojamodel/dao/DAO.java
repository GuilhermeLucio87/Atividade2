package br.com.lojamodel.dao;

import java.sql.SQLException;
import java.util.List;

//CRUD
public interface DAO {

	//Create
	public void adicionar(Object object) throws SQLException ;
	
	//Read
	public List<Object> buscarTodos() throws SQLException ;
	
	//Update
	public void update(Object object) throws SQLException ;
	
	//Delete
	public void remover(Object object) throws SQLException ;
	
	//Metodo para buscar todos pelo ID
	public Object buscarPorId(Object object) throws SQLException ;

	List<Object> buscarNome() throws SQLException;

	List<Object> buscarTodosID() throws SQLException;

	List<Object> buscarTodos1() throws SQLException;

	List<Object> buscar() throws SQLException;

			
}
