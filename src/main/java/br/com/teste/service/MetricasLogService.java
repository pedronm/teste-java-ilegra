package br.com.teste.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import br.com.teste.model.Log;
import br.com.teste.repository.LogRepository;

public class MetricasLogService {

	private LogRepository rep = new LogRepository("jdbc:mysql://35.238.66.132:3306/testeilegra", "root", "");

	public List<Log> topTresMundo() {
		String consulta = "SELECT l.*, COUNT(regionCode) AS totalCountry " + "	FROM LOGS l"
				+ "	group BY url,regionCode" + " ORDER BY totalCountry desc" + " limit 3;";
		return rep.consultaQuery(consulta);

	}

	public Object topTresRegiao(String regiao) {
		String consulta = "SELECT l.*, COUNT(regionCode) AS totalCountry " + "	FROM LOGS l" + "	WHERE regionCode = "
				+ regiao + "	group BY url,regionCode" + "	ORDER BY totalCountry desc" + " limit 3";
		//
		return rep.consultaQuery(consulta);
	}

	public Object menorAcessoMundial() {
		String consulta = "SELECT l.*, COUNT(regionCode) AS totalCountry " + "	FROM LOGS l	"
				+ "	group BY url,regionCode" + "	ORDER BY totalCountry asc	" + "	limit 3";

		return rep.consultaQuery(consulta);
	}

	public Object topTresPorDia(String dia) {
		String dataIni = converteData(dia);
		String dataFim = converteData((LocalDate.parse(dia).plusDays(1).toString()));

		String consulta = "SELECT l.*, COUNT(url) AS totalAccess" + "	FROM LOGS l	" + "	WHERE TIMESTAMP BETWEEN"
				+ dataIni + "AND" + dataFim + "	group BY url,regionCode" + "	ORDER BY totalAccess desc	"
				+ "	limit 3";

		return rep.consultaQuery(consulta);
	}

	public Object minutoComMaiorAcessos() {
		String consulta = "SELECT l.*, COUNT(url) AS totalAccess" + "			 , ((l.timestamp/1000)/60)  AS minuto"
				+ "	FROM LOGS l		" + "	group BY minuto" + "	ORDER BY totalAccess desc	" + "	limit 3";

		return rep.consultaQuery(consulta);
	}

	public String converteData(String data) {
		LocalDate date = LocalDate.parse(data);
		Timestamp timestamp = Timestamp.valueOf(date.atStartOfDay());
		return String.valueOf(timestamp);
	}

}
