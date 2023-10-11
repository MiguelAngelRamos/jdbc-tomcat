package com.kibernumacademy.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {

	private Connection conn = null;
	private DataSource ds = null;
	
	public DBConnection() {
		try {
			Context ctx = new InitialContext();
			this.ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/cursoDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo establecer conexion");
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() throws SQLException {
		this.conn = ds.getConnection();
		return this.conn;
	}
			
	
}
