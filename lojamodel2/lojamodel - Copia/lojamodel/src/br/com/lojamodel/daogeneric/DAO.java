package br.com.lojamodel.daogeneric;

import java.util.List;

public interface DAO<T>{
	void inserir(T t);
	void remover(T t);
	void atualizar(T t);
	List<T> buscar(Integer id);
	List<T> buscarTodos(Integer id);
	
}
