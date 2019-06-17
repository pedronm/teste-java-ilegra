package br.com.teste.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.teste.model.Log;
import spark.Request;
import spark.Response;

public class TrataComunicacao {
	
	public List<Log> trataRequisicao(Request request, Response response){
		
		Gson gson = new Gson();
		Type tipoLista = new TypeToken<ArrayList<Log>>(){}.getType();
//		return gson.fromJson(request.attribute("logs"), tipoLista);				
		return gson.fromJson(request.queryParams("logs"), tipoLista);				
		
	}
}
