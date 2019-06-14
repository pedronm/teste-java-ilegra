package br.com.teste.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.teste.model.Log;
import spark.Request;
import spark.Response;

public class TrataComunicacao {
	
	public List<Log> trataRequisicao(Request request, Response response){
		
		String url = request.queryParams("url");
		String tempo = request.queryParams("timestamp");
		String uuid = request.queryParams("uuid");
		String codRegiao = request.queryParams("codRegiao");
		
		return new ArrayList<>();
	}
}
