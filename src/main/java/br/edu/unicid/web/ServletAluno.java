package br.edu.unicid.web;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.edu.unicid.bean.Aluno;
import br.edu.unicid.dao.AlunoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletAluno extends HttpServlet {

	// método de conversão de String para Data
	private Date strToDate(String data) throws Exception {
		if (data == null) {
			return null;
		}

		Date dataF = null;

		try {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			long timestamp = dateFormat.parse(data).getTime();
			dataF = new Date(timestamp);

			return dataF;

		} catch (ParseException pe) {
			throw pe;
		}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// variável cmd indica o tipo de ação - ()
		String cmd = request.getParameter("cmd");

		// criar um objeto dao - CRUD
		AlunoDAO dao;

		// criar um objeto do tipo aluno
		Aluno aluno = new Aluno();

		if (cmd != null) {
			try {
				aluno.setCaAluno(Integer.parseInt(request.getParameter("txtCa")));
				aluno.setNomeAluno(request.getParameter("txtNome"));
				aluno.setEmailAluno(request.getParameter("txtEmail"));
				aluno.setDtaNasc(strToDate(request.getParameter("txtData")));
				aluno.setEndAluno(request.getParameter("txtEndereco"));
				aluno.setIdadeAluno(Integer.parseInt(request.getParameter("txtIdade")));

			} catch (Exception erro) {
				erro.printStackTrace();
			}
		}
		
		try {			
			dao = new AlunoDAO();
			RequestDispatcher rd = null;
			
			//incluir aluno
			if(cmd.equalsIgnoreCase("incluir")) {
				dao.salvar(aluno);
				rd = request.getRequestDispatcher("ServletAluno?cmd=listar");
			}
			
			//atualizar aluno
			else if(cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(aluno);
				rd = request.getRequestDispatcher("ServletAluno?cmd=listar");				
			}
			
			//excluir aluno
			else if(cmd.equalsIgnoreCase("excluir")) {
				dao.excluir(aluno);
				rd = request.getRequestDispatcher("ServletAluno?cmd=listar");				
			}
			
			//listar todos os alunos
			else if(cmd.equalsIgnoreCase("listar")) {
				List alunosList = dao.todosAlunos();
				request.setAttribute("alunosList", alunosList);
				rd = request.getRequestDispatcher("/mostrarAlunosCads.jsp");
			}
			
			//página inicial
			else if (cmd.equalsIgnoreCase("principal")) {
				rd = request.getRequestDispatcher("/index.jsp");
			}
			
		}catch(Exception erro) {
			erro.printStackTrace();
			throw new ServletException(erro);
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}	

}
