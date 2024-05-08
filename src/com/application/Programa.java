package com.application;

import com.dao.FeitoriaDao;
import com.dao.VendedorDao;
import com.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		VendedorDao vendedorDao = FeitoriaDao.criarVendedorDao();
		Vendedor vendedor = vendedorDao.acharPorId(3);
		System.out.println(vendedor);
	}

}
