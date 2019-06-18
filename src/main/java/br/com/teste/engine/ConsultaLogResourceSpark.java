package br.com.teste.engine;

import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;

import java.sql.SQLException;

import com.google.gson.Gson;

import br.com.teste.service.InserirLogService;
import br.com.teste.service.MetricasLogService;
import br.com.teste.utils.RequestPostLog;


public class ConsultaLogResourceSpark {
	
	public static MetricasLogService metricas = new MetricasLogService();	
	public static InserirLogService logs = new InserirLogService();
	public static RequestPostLog postLog = new RequestPostLog();
	
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
		
		post("/log/ingest", "application/json", (request, response)  -> {
			return logs.inserirLog(postLog.trataRequisicao(request.body(),"logs"));
		});
		
		after( (request, response)->{
			
		});
		
	}

}
