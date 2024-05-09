package com.dao;

import com.dao.impl.DepartamentoDaoJDBC;
import com.dao.impl.VendedorDaoJDBC;

import db.DB;

public class FeitoriaDao {
	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());
	}
	public static DepartamentoDao criarDepartamentoDao() {
		return new DepartamentoDaoJDBC(DB.getConnection());
	}
}
