package com.application;

import java.util.List;

import com.dao.FeitoriaDao;
import com.dao.VendedorDao;
import com.entities.Departamento;
import com.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		VendedorDao vendedorDao = FeitoriaDao.criarVendedorDao();
		System.out.println("=== TESTE 1: ACHAR POR ID ===");
		Vendedor vendedor = vendedorDao.acharPorId(3);
		System.out.println(vendedor);
		System.out.println("\n=== TESTE 2: ACHAR POR DEPARTAMENTO ID ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> lista = vendedorDao.acharPorDepartamento(departamento);
		for(Vendedor obj : lista) {
			System.out.println(obj);
		}
		System.out.println("\n=== TESTE 3: ACHAR TODOS ===");
		lista = vendedorDao.acharTodos();
		for(Vendedor obj : lista) {
			System.out.println(obj);
		}
	}

}
