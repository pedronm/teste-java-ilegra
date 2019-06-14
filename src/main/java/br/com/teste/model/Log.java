package br.com.teste.model;

import javax.servlet.annotation.WebServlet;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@WebServlet("")
@DatabaseTable(tableName = "logs")
public class Log {
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField
	private String url;
	
	@DatabaseField
	private String timestamp;
	
	@DatabaseField
	private String uuid;
	
	@DatabaseField
	private int regionCode;
	
	public Log() {
		// ORMLite precisa de um construtor vazio.
	}
	
	public Log(String url, String timestamp, String uuid, int regionCode) {
		super();
		this.url = url;
		this.timestamp = timestamp;
		this.uuid = uuid;
		this.regionCode = regionCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(int regionCode) {
		this.regionCode = regionCode;
	}
	

}

