package br.com.teste.service;

import java.util.List;

import com.j256.ormlite.stmt.PreparedQuery;

import br.com.teste.model.Log;
import br.com.teste.repository.LogRepository;

public class MetricasLogService {
	
	private LogRepository rep = new LogRepository("jdbc:mysql://127.0.0.1:3306/testeilegra", "root", "");
	private PreparedQuery query;
//	Metricas 
//	 us-east-1(1), us-west-2(2) and ap-south-1(3)
//	  URL				 timestamp     UUID									Region Code
//	 /pets/exotic/cats 1037825323957 5b019db5-b3d0-46d2-9963-437860af707f 1
//	Top 3 url accessed Per REgion [ ]
//	 Top 3 url accessed around the world [ ]
//	 The url with less access in all world [ ] 
//	 Top 3 access per day, week, year (you receive the Day/week/year by parameter) [ ]
//	 the minute with more access in al url [ ]


	public List<Log> topTresMundo() {
		return null;
	}


	public Object topTresRegiao() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object menorAcessoMundial() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object topTresPorDia(String params) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object minutoComMaiorAcessos(String params) {
		// TODO Auto-generated method stub
		return null;
	}

}
