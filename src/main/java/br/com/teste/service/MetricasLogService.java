package br.com.teste.service;

import java.util.ArrayList;
import java.util.List;

import br.com.teste.model.Log;
import br.com.teste.repository.LogRepository;

public class MetricasLogService {
	
	LogRepository rep;
	
//	Metricas 
//	 us-east-1(1), us-west-2(2) and ap-south-1(3)
//	  URL				 timestamp     UUID									Region Code
//	 /pets/exotic/cats 1037825323957 5b019db5-b3d0-46d2-9963-437860af707f 1
//	Top 3 url accessed Per REgion [ ]
//	 Top 3 url accessed around the world [ ]
//	 The url with less access in all world [ ] 
//	 Top 3 access per day, week, year (you receive the Day/week/year by parameter) [ ]
//	 the minute with more access in al url [ ]
	private int codMetrica;
	
	public List<Log> decideMetrica(String codMetrica) {
		if("1".equals(codMetrica)) {
			
		}
		
		
		
		return null;
	}
	
	
	public List<Log> topUrlPorRegiao() {
		return new ArrayList<>();
	}

}
