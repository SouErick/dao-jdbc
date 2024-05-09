package com.application;

import com.dao.DepartamentoDao;
import com.dao.FeitoriaDao;
import com.entities.Departamento;

public class ProgramaDepartamento {

	public static void main(String[] args) {
		DepartamentoDao departamentoDao = FeitoriaDao.criarDepartamentoDao();
		System.out.println("===== TESTE 1: INSERIR DEPARTAMENTO ====");
		Departamento novoDepartamento = new Departamento(null, "Animals");
		departamentoDao.inserir(novoDepartamento);
		System.out.println("Inserindo novo departamento, id: " + novoDepartamento.getId());
	}

}
