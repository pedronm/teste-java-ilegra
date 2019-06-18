package br.com.teste.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import br.com.teste.model.Log;
import spark.Request;
import spark.Response;

public class TrataComunicacao {
	
	private static Gson gson;
	
	public List<Log> trataRequisicao(Request request, Response response){
		
		List<Log> retorno = new ArrayList<>();
		JsonParser parser = new JsonParser();
		JsonArray responseData = (JsonArray) parser.parse(request.body());
		if(responseData != null) {
			for (JsonElement json : responseData) {
				retorno.add(gson.fromJson(json, Log.class));
			}
		}
		return retorno;
	}
}
