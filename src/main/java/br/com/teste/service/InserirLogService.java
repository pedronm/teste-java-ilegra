package br.com.teste.service;

import java.util.List;

import br.com.teste.model.Log;
import br.com.teste.repository.LogRepository;

public class InserirLogService {
	
	private LogRepository rep = new LogRepository("jdbc:mysql://127.0.0.1:3306", "root", "admin");
	
	public String inserirLog(Log log) {
		return "Try";
	}
	public String inserirLog(List<Log> logs) {
		
		for (Log log : logs) {
			System.out.println(log.getRegionCode());
			System.out.println(log.getTimestamp());
			System.out.println(log.getUrl());
			System.out.println(log.getUuid());
		}
		try {			
//			rep.inserirLog(logs);
			return "Inserido com sucesso";
			
		}catch(Exception e) {
			return "Erro inserindo o Log";
		}
	}
	
}
