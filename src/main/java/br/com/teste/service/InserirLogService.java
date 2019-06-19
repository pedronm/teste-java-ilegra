package br.com.teste.service;

import java.sql.SQLException;
import java.util.List;

import br.com.teste.model.Log;
import br.com.teste.repository.LogRepository;

public class InserirLogService {
	
	private LogRepository rep = new LogRepository("jdbc:mysql://127.0.0.1:3306/testeilegra", "root", "");
	
	public void inserirLog(List<Log> logs) throws SQLException {

		try {			
			rep.inserirLog(logs);			
		}catch(Exception e) {
			throw new SQLException("Erro ao acessar o banco", e);
		}
	}
	
}
