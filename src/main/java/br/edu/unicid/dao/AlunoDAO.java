package br.edu.unicid.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import br.edu.unicid.bean.Aluno;
import br.edu.unicid.util.ConnectionFactory;

public class AlunoDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Aluno aluno;

	public AlunoDAO() throws Exception {
		// chama a Classe ConnectionFacotry
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception(erro.getMessage());
		}
	}

	// método salvar
	public void salvar(Aluno aluno) throws Exception {
		if (aluno == null) {
			throw new Exception("Preencha as informações do aluno");
		}
		try {
			String SQL = "INSERT INTO tbAluno(caAluno, nomeAluno, emailAluno, dtaNasc, endAluno, idadeAluno) values (?, ?, ?, ? ,? ,?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, aluno.getCaAluno());
			ps.setString(2, aluno.getNomeAluno());
			ps.setString(3, aluno.getEmailAluno());
			ps.setDate(4, new java.sql.Date(aluno.getDtaNasc().getTime()));
			ps.setString(5, aluno.getEndAluno());
			ps.setInt(6, aluno.getIdadeAluno());
			ps.executeUpdate();

		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// método atualizar
	public void atualizar(Aluno aluno) throws Exception {
		if (aluno == null) {
			throw new Exception("Preencha as informações do aluno");
		}
		try {
			String SQL = "UPDATE tbAluno set nomeAluno=?, emailAluno=?, dtaNasc=?,"
					+ " endAluno=?, idadeAluno=? WHERE caAluno=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, aluno.getNomeAluno());
			ps.setString(2, aluno.getEmailAluno());
			ps.setDate(3, new java.sql.Date(aluno.getDtaNasc().getTime()));
			ps.setString(4, aluno.getEndAluno());
			ps.setInt(5, aluno.getIdadeAluno());
			ps.setInt(6, aluno.getCaAluno());
			ps.executeUpdate();

		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// método excluir
	public void excluir(Aluno aluno) throws Exception {
		if (aluno == null) {
			throw new Exception("Preencha as informações do aluno");
		}
		try {
			String SQL = "DELETE FROM tbAluno WHERE caAluno=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, aluno.getCaAluno());
			ps.executeUpdate();

		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// método listar
	public List todosAlunos() throws Exception {
		try {
			String SQL = "SELECT * FROM tbAluno";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();

			List<Aluno> list = new ArrayList<Aluno>();

			while (rs.next()) {
				int ca = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				Date nascimento = rs.getDate(4);
				String endereco = rs.getString(5);
				int idade = rs.getInt(6);

				list.add(new Aluno(ca, nome, email, nascimento, endereco, idade));
			}

			return list;

		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	// método buscar
	public Aluno procurarAluno(int caAluno) throws Exception {

		try {
			String SQL = "SELECT  * FROM tbAluno WHERE caAluno=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, caAluno);			
			rs = ps.executeQuery();
			if (rs.next()) {
				int ca = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				Date nascimento = rs.getDate(4);
				int idade = rs.getInt(5);
				String endereco = rs.getString(6);
				aluno = new Aluno(ca, nome, email, nascimento, endereco, idade);
			}
			return aluno;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
}