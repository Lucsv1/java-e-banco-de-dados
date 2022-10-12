package DAO;

import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import Models.Contato;

public class ContatoDao {
	
	private Connection conexao;
	
	public void inserir(Contato contato) {
		
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;
		try {
			comandoSQL = conexao.prepareStatement("INSERT INTO contato (id_contato, nome_contato, celular_contato, email_contato, tipo) values(?,?,?,?,?)");
			comandoSQL.setInt(1, contato.getId());
			comandoSQL.setString(2, contato.getNome());
			comandoSQL.setString(3, contato.getCelular());
			comandoSQL.setString(4, contato.getEmail());
			comandoSQL.setString(5, contato.getTipo());
			
			comandoSQL.executeUpdate();
			conexao.close();
			comandoSQL.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void remover(Contato contato) {
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;
		try {
			
			comandoSQL = conexao.prepareStatement("DELETE FROM contato where id_contato = ?");
			comandoSQL.setInt(1, contato.getId());
			
			comandoSQL.execute();
			conexao.close();
			comandoSQL.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void buscarId(int id) {
		Contato c = new Contato();
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;
		
		try {
			
			comandoSQL = conexao.prepareStatement("SELECT * FROM contato WHERE id_contato = ?");
			comandoSQL.setInt(1, id);
			ResultSet rs = comandoSQL.executeQuery();
			if(rs.next()) {
				c.setId(rs.getInt(1));
				c.setNome(rs.getString(2));
				c.setCelular(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTipo(rs.getString(5));
			}
			
			comandoSQL.execute();
			conexao.close();
			comandoSQL.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<Contato> buscarPorTipo(int id) {
		ArrayList<Contato> listaTipo = new ArrayList<Contato>();
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;
		try {
			
			comandoSQL = conexao.prepareStatement("SELECT * FROM contato where id_contato = ?");
			comandoSQL.setInt(1, id);
			ResultSet rs = comandoSQL.executeQuery();
			if (rs.next()) {
				Contato c = new Contato();
				c.setId(rs.getInt(1));
				c.setNome(rs.getString(2));
				c.setCelular(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTipo(rs.getString(5));
			    listaTipo.add(c);
			}
			conexao.close();
			comandoSQL.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaTipo ;
		
		
	}
	
	public ArrayList<Contato> busacarTodosContatos(){
		
		ArrayList<Contato> listaContatos = new ArrayList<Contato>();
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;
		
		try {
			
			comandoSQL = conexao.prepareStatement("SELECT * FROM contato order by nome_contato");
			ResultSet rs = comandoSQL.executeQuery();
			while(rs.next()) {
				Contato c = new Contato();
				c.setId(rs.getInt(1));
			    c.setNome(rs.getString(2));
			    c.setEmail(rs.getString(3));
			    c.setCelular(rs.getString(4));
			    c.setTipo(rs.getString(5));
			    listaContatos.add(c);
			}
			
			conexao.close();
			comandoSQL.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaContatos;
		
	}
	public void alterar(Contato contato) {
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexao.prepareStatement("UPDATE contato SET  nome_contato = ?, celular_contato = ?, email_contato = ?, tipo = ? WHERE id_contato = ?");
			comandoSQL.setString(1, contato.getNome());
			comandoSQL.setString(2, contato.getCelular());
			comandoSQL.setString(3, contato.getEmail());
			comandoSQL.setString(4, contato.getTipo());
			comandoSQL.setInt(5, contato.getId());
			
			comandoSQL.executeUpdate();
			conexao.close();
			comandoSQL.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
