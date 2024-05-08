package com.dao;

import com.dao.impl.VendedorDaoJDBC;

public class FeitoriaDao {
	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC();
	}
}
