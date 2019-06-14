package br.com.teste.engine;

import static spark.Spark.*;
import java.sql.SQLException;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import br.com.teste.model.Log;


public class ConsultaLogResourceSpark {
	
//	Metricas 
//	 us-east-1(1), us-west-2(2) and ap-south-1(3)
//	  URL				 timestamp     UUID									Region Code
//	 /pets/exotic/cats 1037825323957 5b019db5-b3d0-46d2-9963-437860af707f 1
//	Top 3 url accessed Per REgion
//	 Top 3 url accessed around the world
//	 The url with less access in all world
//	 Top 3 access per day, week, year (you receive the Day/week/year by parameter)
//	 the minute with more access in al urls
	
	public static void main(String[] args) throws SQLException {
		
		String databaseUrl = "jdbc:mysql://localhost/spark";
		
		ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
		((JdbcConnectionSource)connectionSource).setUsername("spark");
		((JdbcConnectionSource)connectionSource).setPassword("spark");
		Dao<Log,String> logDao = DaoManager.createDao(connectionSource, Log.class);
		
		TableUtils.createTableIfNotExists(connectionSource, Log.class);

		
		get("/log/metrics/:codMetrica", (request, response) -> {
			return "Código selecionado foi: " + request.params(":codMetrica");
		});
		
		get("/log/health", ( request, response) -> {
	            return  "User: username=:"+ 
	            	", email=test@test.net";                
		});
		
		post("/log/ingest", (request, response) -> {
			
			try {
				
				String url = request.queryParams("url");
				String tempo = request.queryParams("timestamp");
				String uuid = request.queryParams("uuid");
				String codRegiao = request.queryParams("codRegiao");
				
				Log log = new Log(url,tempo,uuid,Integer.valueOf(codRegiao));
				
				logDao.create(log);
				
				response.status(201);
				
				return "Inserido com sucesso";
				
			}catch(Exception e) {
				response.status(500);
				return "Erro inserindo o Log";
			}
			
		});
		
	}

}
