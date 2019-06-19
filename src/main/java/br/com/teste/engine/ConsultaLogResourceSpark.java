package br.com.teste.engine;

import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.sql.SQLException;

import br.com.teste.service.InserirLogService;
import br.com.teste.service.MetricasLogService;
import br.com.teste.utils.JsonTransformer;
import br.com.teste.utils.ParseJsonPost;
import spark.Redirect;


public class ConsultaLogResourceSpark {
	
	public static final MetricasLogService metricas = new MetricasLogService();	
	public static final InserirLogService logs = new InserirLogService();
	public static final ParseJsonPost postLog = new ParseJsonPost();
	
	public void init() {
		get("/log/metrics/top-3-around-world", (request, response) -> {
			return metricas.topTresMundo();
		},new JsonTransformer());
		
		get("/log/metrics/top-3-per-region/:codRegiao", (request, response) -> {
			return metricas.topTresRegiao(request.params("codRegiao"));
		},new JsonTransformer());
		
		get("/log/metrics/less-access-around-world", (request, response) -> {
			return metricas.menorAcessoMundial();
		},new JsonTransformer());
		
		get("/log/metrics/top-3-access-per-day/:data", (request, response) -> {
			return metricas.topTresPorDia(request.params("data"));
		},new JsonTransformer());
		
		get("/log/metrics/the-minute-with-more-acces", (request, response) -> {
			return metricas.minutoComMaiorAcessos();
		},new JsonTransformer());
		
		get("/log/health", ( request, response) -> {
			response.status(200);
	        return "Saudável";                
		});
		
		post("/log/ingest", "application/json", (request, response)  -> {
			logs.inserirLog(postLog.trataRequisicao(request.body(),"logs"));
			response.status(200);
			return "Inserido com sucesso";
		});

	}
//	public static void main(String[] args) throws SQLException {	
//		
//		
//	}

}
