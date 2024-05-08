package com.dao;

import com.dao.impl.VendedorDaoJDBC;

import db.DB;

public class FeitoriaDao {
	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());
	}
}
