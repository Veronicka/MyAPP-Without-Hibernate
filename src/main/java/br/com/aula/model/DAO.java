package br.com.aula.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.aula.util.ConnectionDB;

public class DAO {
	
	public static Boolean save(Usuario u) {

		ConnectionDB db = new ConnectionDB();
		Connection con = db.getCon();
		Statement stmt;
		int result;
		
		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate("INSERT INTO Usuario(nome, idade, profissao, salario) values ('"+
					u.getNome()+"', '"+u.getIdade()+"', '"+u.getNome()+"', '"+u.getSalario()+"');"); 
			stmt.close();
			con.close();
			
			if(result==1) return true;
			else return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
					
		return false;
	}
	
	public static Boolean update(Usuario u, long id) {

		ConnectionDB db = new ConnectionDB();
		Connection con = db.getCon();
		Statement stmt;
		int result;
		
		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE usuario SET nome='"+u.getNome()
				+"', idade='"+u.getIdade()+"', profissao='"+u.getProfissao()+"', salario='"+u.getSalario()+"' WHERE usuario_id="+id+";"); 
			stmt.close();
			con.close();
			
			if(result==1) return true;
			else return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
					
		return false;
	}
	
	public static Boolean delete(long id) {

		ConnectionDB db = new ConnectionDB();
		Connection con = db.getCon();
		Statement stmt;
		int result;
		
		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate("DELETE FROM Usuario WHERE usuario_id = "+id+";"); 
			stmt.close();
			con.close();
			
			if(result==1) return true;
			else return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
					
		return false;
	}

}
