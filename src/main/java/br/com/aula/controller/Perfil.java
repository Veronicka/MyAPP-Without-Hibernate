package br.com.aula.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.aula.model.DAO;
import br.com.aula.model.Usuario;

@WebServlet(urlPatterns = {"/perfil"})
public class Perfil extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public Perfil() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		DAO.update(new Usuario("Jose", "78", "Caminhoneiro", "5000"), 3);
		
		List<Usuario> u = Usuario.findAll();
				
		out.println(gson.toJson(u));		
	}
}
