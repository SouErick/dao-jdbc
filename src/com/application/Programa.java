package com.application;

import com.dao.FeitoriaDao;
import com.dao.VendedorDao;
import com.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		VendedorDao vendedorDao = FeitoriaDao.criarVendedorDao();
		System.out.println("=== TESTE 1: ACHAR POR ID ===");
		Vendedor vendedor = vendedorDao.acharPorId(3);
		System.out.println(vendedor);
	}

}
