package br.com.ilegra.resources;

@Path("/consulta-log")
public class ConsultaLogResource {
	
	@GET
	@Produces("application/xml")
	public String cosultaLog() {
		
		String teste = "funciona";
		return teste;
	}
}
