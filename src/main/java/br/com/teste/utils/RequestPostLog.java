package br.com.teste.utils;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import br.com.teste.model.Log;


public class RequestPostLog extends ParseJsonPost implements ExitrairJsonStrategy{
		
	@Override
	public List<Log> extrairJson(JsonArray arrayOfJson) {
		List<Log> retorno = new ArrayList<>();
		for (JsonElement json : arrayOfJson) {
			retorno.add(gson.fromJson(json, Log.class));
		}
		return retorno;
	}

}
