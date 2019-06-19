
package br.com.teste.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import br.com.teste.model.Log;

public class LogRepository {
	
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
	
	public void inserirLog(List<Log> logs) {
		try {			
			TableUtils.createTableIfNotExists(this.conexao, Log.class);			
			Dao<Log,String> logDao = DaoManager.createDao(conexao, Log.class);
			for (Log log : logs) {
				logDao.createOrUpdate(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Log> consultaQuery(PreparedQuery query){
		List<Log> retorno = new ArrayList<>();
		try {
			TableUtils.createTableIfNotExists(this.conexao, Log.class);			
			Dao<Log,String> logDao = DaoManager.createDao(conexao, Log.class);
			logDao.query(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
}