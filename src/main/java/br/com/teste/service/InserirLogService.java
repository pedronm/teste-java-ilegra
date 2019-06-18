package br.com.teste.service;

import java.util.List;

import br.com.teste.model.Log;
import br.com.teste.repository.LogRepository;

public class InserirLogService {
	
	private LogRepository rep = new LogRepository("jdbc:mysql://127.0.0.1:3306/testeilegra", "root", "");
	
	public String inserirLog(List<Log> logs) {

		try {			
			rep.inserirLog(logs);
			return "Inserido com sucesso";
			
		}catch(Exception e) {
			return "Erro inserindo o Log";
		}
	}
	
}
