package br.com.teste.engine;

import static spark.Spark.*;

import java.sql.SQLException;

import br.com.teste.service.InserirLogService;
import br.com.teste.service.MetricasLogService;
import br.com.teste.utils.TrataComunicacao;


public class ConsultaLogResourceSpark {
	
	public static MetricasLogService metricas;	
	public static InserirLogService logs;
	public static TrataComunicacao comm;
	
	public static void main(String[] args) throws SQLException {	
		
		before((request, response) -> {
			
		});
		
		get("/log/metrics/:codMetrica", (request, response) -> {
			return metricas.decideMetrica(request.params(":codMetrica"));
		});
		
		get("/log/health", ( request, response) -> {
	            return  "User: username=:"+ 
	            	", email=test@test.net";                
		});
		
		post("/log/ingest", (request, response) -> {			
			return logs.inserirLog(comm.trataRequisicao(request,response));			
		});
		
		after( (request, response)->{
			
		});
		
	}

}
