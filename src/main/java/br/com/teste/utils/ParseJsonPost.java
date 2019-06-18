package br.com.teste.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.teste.model.Log;

/**
 * CLASSE ABSTRATA NO PADRÃO STRATEGY
 * PARA QUE A REQUISIÇÃO POST SEJA 
 * TRATADA PARA O TIPO DE REQUISIÇÃO 
 * QUE VIER DE ACORDO COM A CLASSE 
 * QUE FOR INSERIDA
 *  
 * @author pedrodonascimento
 * @param <T>
 *
 */
public abstract class ParseJsonPost {
		
		protected static Gson gson = new Gson();
		protected ExitrairJsonStrategy strategyJson;
				
		public <T> List<T> trataRequisicao(String body, String atributo){
			
			List<T> retorno = new ArrayList<>();
			JsonParser parser = new JsonParser();
			
			JsonArray arrayOfJson = converteEntrada(body, atributo, parser);
			
			retorno = strategyJson.extrairJson(arrayOfJson);
			
			return retorno;
			
		}

		private JsonArray converteEntrada(String body, String atributo, JsonParser parser) {
			JsonObject responseData = (JsonObject) parser.parse(body);
			JsonArray arrayOfJson = (JsonArray) responseData.get(atributo);
			return arrayOfJson;
		}
		
	

}
