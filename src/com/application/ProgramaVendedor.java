package com.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dao.FeitoriaDao;
import com.dao.VendedorDao;
import com.entities.Departamento;
import com.entities.Vendedor;

public class ProgramaVendedor {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
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
		System.out.println("\n=== TESTE 4: INSERIR VENDEDOR ===");
		Vendedor novoVendedor = new Vendedor(null, "Pablo", "pablo@email.com", new Date(), 4000.0, departamento);
		vendedorDao.inserir(novoVendedor);
		System.out.println("Inserido, novo id: " + novoVendedor.getId());
		System.out.println("\n=== TESTE 5: ATUALIZAR VENDEDOR ===");
		vendedor = vendedorDao.acharPorId(8);
		vendedor.setNome("Martha");
		vendedor.setEmail("martha@email.com");
		vendedorDao.atualizar(vendedor);
		System.out.println("Atualização feita.");
		System.out.println("\n=== TESTE 6: EXCLUIR VENDEDOR ===");
		System.out.print("Entre com id para DELETAR: ");
		int id = teclado.nextInt();
		vendedorDao.deletarPorId(id);
		System.out.println("Vendedor com o id " + id + " deletado.");
		teclado.close();
	}

}
