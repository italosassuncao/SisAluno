<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="br.edu.unicid.bean.Aluno" %>

<%@page contextType="text/html" %>
<%@page pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Alunos</title>
</head>
<body>
<center>
	<table width="100%" border="1" cellpaddings="2" cellspacing="0">
	<tr>
		<th colspan="6"><h3>Lista de Alunos</h3></th>
	</tr>
	<tr>
		<th>Ca</th>
		<th>Nome</th>
		<th>Email</th>
		<th>Nascimento</th>
		<th>Endereco</th>
		<th>Idade</th>
	</tr>
	<% 
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		List<Aluno> lista = new ArrayList<Aluno>();
		lista = (ArrayList) request.getAttribute("alunoList");
		for(Aluno a: lista){%>
			<tr>
				<td><%a.getCaAluno();%></td>
				<td><%%>a.getNomeAluno();</td>
				<td><%a.getEmailAluno();%></td>
				<td><%data.format(a.getDtaNasc());%></td>
				<td><%a.getEndAluno();%></td>
				<td><%a.getIdadeAluno();%></td>
			</tr><%
		}
	%>
	<tr>
		<td colspan="6" align="center"><a href="index.jsp">Página Principal</a></td>
	</tr>
	</table>
</center>
</body>
</html>