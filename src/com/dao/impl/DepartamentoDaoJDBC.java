package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dao.DepartamentoDao;
import com.entities.Departamento;

import db.DB;
import db.DbException;

public class DepartamentoDaoJDBC implements DepartamentoDao{
	private Connection conn;
	public DepartamentoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void inserir(Departamento obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNome());
			int linhasAfetadas = st.executeUpdate();
			if(linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}else {
				throw new DbException("Nenhuma linha afetada");
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
		
	}

	@Override
	public void atualizar(Departamento obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Departamento acharPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> acharTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
