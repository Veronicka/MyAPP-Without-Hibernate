package br.com.aula.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.aula.util.ConnectionDB;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String nome;
	private String idade;
	private String profissao;
	private String salario;

	public Usuario() {
	}

	public Usuario(String nome, String idade, String profissao, String salario) {
		this.nome = nome;
		this.idade = idade;
		this.profissao = profissao;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", idade=" + idade + ", profissao=" + profissao + ", salario="
				+ salario + "]";
	}

	public static Usuario findById(long id) {

		ConnectionDB db = new ConnectionDB();
		Connection con = db.getCon();
		Statement stmt;
		Usuario result = null;
		
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from usuario where usuario_id = '" + id + "'");
			while(rs.next()) {
				result = new Usuario();
				result.setId(Integer.parseInt(rs.getString("usuario_id")));
				result.setIdade(rs.getString("idade"));
				result.setNome(rs.getString("nome"));
				result.setProfissao(rs.getString("profissao"));
				result.setSalario(rs.getString("salario"));
			}
			
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	public static Usuario findByName(String name) {

		ConnectionDB db = new ConnectionDB();
		Connection con = db.getCon();
		Statement stmt;
		Usuario result = null;
		
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from usuario where name = '" + name + "'");
			while(rs.next()) {
				result = new Usuario();
				result.setId(Integer.parseInt(rs.getString("usuario_id")));
				result.setIdade(rs.getString("idade"));
				result.setNome(rs.getString("nome"));
				result.setProfissao(rs.getString("profissao"));
				result.setSalario(rs.getString("salario"));
			}
			
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	public static List<Usuario> findAll() {

		ConnectionDB db = new ConnectionDB();
		Connection con = db.getCon();
		Statement stmt;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from usuario");
			
			Usuario result;
			while(rs.next()) {
				result = new Usuario();
				result.setId(Integer.parseInt(rs.getString("usuario_id")));
				result.setIdade(rs.getString("idade"));
				result.setNome(rs.getString("nome"));
				result.setProfissao(rs.getString("profissao"));
				result.setSalario(rs.getString("salario"));
				
				usuarios.add(result);
			}
			
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return usuarios;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}
}
