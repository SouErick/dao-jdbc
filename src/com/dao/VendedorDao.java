package com.dao;

import java.util.List;

import com.entities.Departamento;
import com.entities.Vendedor;

public interface VendedorDao {
	void inserir(Vendedor vendedor);
	void atualizar(Vendedor vendedor);
	void deletarPorId(Integer id);
	Vendedor acharPorId(Integer id);
	List<Vendedor> acharTodos();
	List<Vendedor> acharPorDepartamento(Departamento departamento);
}
