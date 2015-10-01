package br.com.planosaude.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.planosaude.business.IPessoaBusinessLocal;

@WebServlet(urlPatterns="/consultaPessoas")
public class ConsultaPessoasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private IPessoaBusinessLocal pessoaBusiness;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listPessoas", pessoaBusiness.buscarTodasPessoas());
		request.getRequestDispatcher("pages/consultaPessoas.jsp").forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
