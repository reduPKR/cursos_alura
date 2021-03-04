package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import br.com.alura.gerenciador.banco.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/nova-empresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		String nome = request.getParameter("name");
//		
//		Empresa empresa = new Empresa(nome);
//		Banco banco = new Banco();
//		banco.adicionar(empresa);
//				
//		
//		RequestDispatcher rd = request.getRequestDispatcher("/EmpresaCadastrada.jsp");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
//	}
//	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAbertura=null;
		
		try {
			dataAbertura = sdf.parse(dataEmpresa);
		} 
		catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adicionar(empresa); 
		
		//Client Side
		response.sendRedirect("lista-empresas");
		
	}

}
