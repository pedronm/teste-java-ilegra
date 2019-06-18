package br.com.teste.utils;

import java.util.List;

import com.google.gson.JsonArray;

public interface ExitrairJsonStrategy {
	public <T> List<T> extrairJson(JsonArray arrayOfJson);
}
