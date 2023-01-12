<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="br.edu.unicid.bean.Aluno" %>

<%@page contentType="text/html" %>
<%@page pageEncoding="ISO-8859-1" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Alunos</title>
</head>
<body>
	<center>
		<table width="100%" border="1" cellpadding="2" cellspacing="0">
			<tr>
				<th colspan="6"><h3>Lista de Alunos</h3></th>
			<tr>
			<tr>
				<th>Ca</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Nascimento</th>
				<th>Idade</th>
				<th>Endereço</th>
			<tr>
			<%
				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				List<Aluno> listar = new ArrayList<Aluno>();
				listar = (ArrayList) request.getAttribute("alunosList");
				for(Aluno a: listar){%>
					<tr>
						<td><%a.getCaAluno();%></td>
						<td><%a.getNomeAluno();%></td>
						<td><%a.getEmailAluno();%></td>
						<td><%data.format(a.getDtaNasc());%></td>
						<td><%a.getEndAluno();%></td>
						<td><%a.getIdadeAluno();%></td>
					</tr>
					<%
				}			
			%>
			<tr>
				<td colspan="6" align="center"><a href="index.jsp">Página Principal</a></td>
			<tr>
		</table>
	</center>
</body>
</html>