package com.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.DepartamentoDao;
import com.dao.FeitoriaDao;
import com.entities.Departamento;

public class ProgramaDepartamento {

	public static void main(String[] args) {
		DepartamentoDao departamentoDao = FeitoriaDao.criarDepartamentoDao();
		int idDesejado;
		Scanner teclado = new Scanner(System.in);
		System.out.println("===== TESTE 1: INSERIR DEPARTAMENTO ====");
		Departamento novoDepartamento = new Departamento();
		departamentoDao.inserir(novoDepartamento);
		System.out.println("Inserindo novo departamento, id: " + novoDepartamento.getId());
		System.out.println("===== TESTE 2: ATUALIZAR DEPARTAMENTO ====");
		System.out.print("Digite o id desejado: ");
		idDesejado = teclado.nextInt();
		novoDepartamento = departamentoDao.acharPorId(idDesejado);
		novoDepartamento.setNome("School");
		departamentoDao.atualizar(novoDepartamento);
		System.out.println("Atualização feita.");
		System.out.println("===== TESTE 3: PROCURAR POR ID DO DEPARTAMENTO ====");
		System.out.println("Digite o id a procurar: ");
		idDesejado = teclado.nextInt();
		novoDepartamento = departamentoDao.acharPorId(idDesejado);
		System.out.println(novoDepartamento);
		System.out.println("===== TESTE 4: DELETAR POR ID DO DEPARTAMENTO ====");
		System.out.println("Digite o id a DELETAR: ");
		idDesejado = teclado.nextInt();
		departamentoDao.deletarPorId(idDesejado);
		System.out.println("Departamento com id " + idDesejado + " deletado.");
		System.out.println("===== TESTE 5: LER TODOS ====");
		List<Departamento> departamento = new ArrayList<>();
		departamento = departamentoDao.acharTodos(); 
		departamento.forEach(System.out::println);
		teclado.close();
	}

}
