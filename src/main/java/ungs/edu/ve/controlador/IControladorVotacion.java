package ungs.edu.ve.controlador;

import java.util.Set;

import ungs.edu.ve.modelo.Lista;
import ungs.edu.ve.modelo.ResultadoVotacion;

public interface IControladorVotacion {

	public void habilitarVotante(String id) throws Exception;
	
	public long	votarListas(Set<Lista> listas);
	
	public ResultadoVotacion getResultados();

	public void inicializar();
	
}
