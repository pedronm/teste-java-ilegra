package br.com.teste.repository;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import br.com.teste.model.Log;

public class LogRepository<T> {
	
	public ConnectionSource conexao;
	
//	public LogRepository(ConnectionSource con, Class<T> T) {
//		this.conexao = con;				
//		this.manterTabela(con, T);
//	}
	
	public LogRepository(String url, String login, String senha) {
//		String databaseUrl = "jdbc:mysql://localhost/spark";
		this.manterConexao(url,login,senha);		
	}
	
	public void manterConexao(String url, String login, String senha) {
		ConnectionSource conexao;
		try {
			conexao = new JdbcConnectionSource(url);
			((JdbcConnectionSource)conexao).setUsername(login);
			((JdbcConnectionSource)conexao).setPassword(senha);
			this.conexao = conexao;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void manterTabela(ConnectionSource con, Class<T> O) {
		try{
			TableUtils.createTableIfNotExists(con, O);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inserirLog(List<Log> logs) {
		try {
			Dao<Log,String> logDao = DaoManager.createDao(conexao, Log.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


}
