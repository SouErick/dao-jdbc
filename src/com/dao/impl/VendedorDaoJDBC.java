package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.VendedorDao;
import com.entities.Departamento;
import com.entities.Vendedor;

import db.DB;
import db.DbException;

public class VendedorDaoJDBC implements VendedorDao{
	private Connection conn;
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void inserir(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor acharPorId(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Departamento dep = instanciacaoDepartamento(rs);
				Vendedor obj = instanciacaoVendedor(rs, dep);
				return obj;
			}
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	private Vendedor instanciacaoVendedor(ResultSet rs, Departamento dep) throws SQLException {
		// TODO Auto-generated method stub
		Vendedor obj = new Vendedor();
		obj.setId(rs.getInt("Id"));
		obj.setNome(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setSalarioBase(rs.getDouble("BaseSalary"));
		obj.setDataNascimento(rs.getDate("BirthDate"));
		obj.setDepartamento(dep);
		return obj;
	}
	private Departamento instanciacaoDepartamento(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setNome(rs.getString("DepName"));
		return dep;
	}
	@Override
	public List<Vendedor> acharTodos() {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name"
					);
			rs = st.executeQuery();
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			while(rs.next()) {
				Departamento dep = map.get(rs.getInt("DepartmentId"));
				if(dep == null) {
					dep = instanciacaoDepartamento(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				Vendedor obj = instanciacaoVendedor(rs, dep);
				lista.add(obj);
			}
			return lista;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	@Override
	public List<Vendedor> acharPorDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name"
			);
			st.setInt(1, departamento.getId());
			rs = st.executeQuery();
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			while(rs.next()) {
				Departamento dep = map.get(rs.getInt("DepartmentId"));
				if(dep == null) {
					dep = instanciacaoDepartamento(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				Vendedor obj = instanciacaoVendedor(rs, dep);
				lista.add(obj);
			}
			return lista;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}
	
}
