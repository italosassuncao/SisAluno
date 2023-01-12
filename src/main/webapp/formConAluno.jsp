<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta Aluno</title>
</head>
<body>
	<h2 aling="center">Consulta Aluno</h2>
	<jsp:useBean id="aluno" scope="session"
		class="br.edu.unicid.bean.Aluno" />
	<%
	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	%>

	<form action="ServletAluno?cmd=atualizar" method="post">
		<center>
			<table>
				<tr>
					<td>CA:</td>
					<td><input type="text" name="txtCa" size="60" maxlength="60"
						value="<%=aluno.getCaAluno()%>" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="txtNome" size="60" maxlength="60"
						value="<%=aluno.getNomeAluno()%>" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><input type="text" name="txtEmail" size="60"
						maxlength="60" value="<%=aluno.getEmailAluno()%>"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>Data de Nascimento:</td>
					<td><input type="text" name="txtData" size="60" maxlength="60"
						value="<%=data.format(aluno.getDtaNasc())%>" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Endereço:</td>
					<td><input type="text" name="txtEndereco" size="60"
						maxlength="60" value="<%=aluno.getEndAluno()%>"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Idade:</td>
					<td><input type="text" name="txtIdade" size="60"
						maxlength="60" value="<%=aluno.getIdadeAluno()%>"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><a href="index.jsp">Página
							Principal</a></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>