package ungs.edu.ve.modelo;

import java.util.Map;


public class ResultadoVotacion {

	private Map<Lista, Double> resultados;

	
	public Map<Lista, Double> getResultados() {
		return resultados;
	}

	public void setResultados(Map<Lista, Double> resultados) {
		this.resultados = resultados;
	}

	@Override
	public String toString() {
		return "ResultadoVotacion [resultados=" + resultados + "]";
	}
	
	
	
}
