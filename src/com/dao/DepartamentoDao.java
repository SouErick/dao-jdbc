package com.dao;

import java.util.List;

import com.entities.Departamento;

public interface DepartamentoDao {
	void inserir(Departamento obj);

	void atualizar(Departamento obj);

	void deletarPorId(Integer id);

	Departamento acharPorId(Integer id);

	List<Departamento> acharTodos();
}
