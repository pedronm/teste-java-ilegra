package br.com.teste.engine;

import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;

import java.sql.SQLException;

import com.google.gson.Gson;

import br.com.teste.service.InserirLogService;
import br.com.teste.service.MetricasLogService;
import br.com.teste.utils.TrataComunicacao;


public class ConsultaLogResourceSpark {
	
	public static MetricasLogService metricas = new MetricasLogService();	
	public static InserirLogService logs = new InserirLogService();
	public static TrataComunicacao comm = new TrataComunicacao();
	
	public static void main(String[] args) throws SQLException {	
		
		Gson gson = new Gson();

		before((request, response) -> {
			
		});
		
		get("/teste/:nome", (request,response)->{
			return "Hello mr(s)"+request.params("nome");					
		});
		
		get("/log/metrics/:codMetrica", (request, response) -> {
			return metricas.decideMetrica(request.params("codMetrica"));
		}, gson :: toJson);
		
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
