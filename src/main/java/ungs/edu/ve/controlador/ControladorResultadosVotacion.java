package ungs.edu.ve.controlador;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ungs.edu.ve.modelo.Lista;
import ungs.edu.ve.modelo.ResultadoVotacion;

public class ControladorResultadosVotacion {

	private ResultadoVotacion resultadoVotacion;
	
	
	public ControladorResultadosVotacion(){
			resultadoVotacion=new ResultadoVotacion() ;
			Lista lista1=new Lista();
			Lista lista2=new Lista();
			
			lista1.setId(1);
			lista1.setNombre("PO");
			lista1.setDescripcion("PARTIDO OBRERO");
			lista2.setId(2);
			lista2.setNombre("PA");
			lista2.setDescripcion("Pan y Rosas");
			Map<Lista, Double> map= new HashMap<Lista, Double>();
			map.put(lista1, 60.0);
			map.put(lista2, 40.0);
			resultadoVotacion.setResultados(map);
	}
	
	
	@SuppressWarnings("rawtypes")
	public String getResultados(){
		String resultado="*************************************\n";
		resultado+=		 "LISTA\t\t\tPORCENTAJE\n";
		Iterator iterator= (Iterator) this.resultadoVotacion.getResultados().keySet().iterator();
		while(iterator.hasNext()){
			Lista lista=(Lista) iterator.next();
			resultado+=lista.getNombre()+"\t\t\t\t"+this.resultadoVotacion.getResultados().get(lista)+"\n";
					
		}
		 resultado+="*************************************";
		return resultado;
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public Lista getGanador(){
		Iterator iterator= (Iterator) this.resultadoVotacion.getResultados().keySet().iterator();
		Double porcentajeMayor=0.0;
		Lista listaGanadora=null;
		while(iterator.hasNext()){
			Lista lista=(Lista) iterator.next();
			Double porcentaje= this.resultadoVotacion.getResultados().get(lista);
			if (porcentajeMayor<porcentaje){
				listaGanadora=lista;
				porcentajeMayor=porcentaje;
			}
		}
		return listaGanadora;
		
	}


	public ResultadoVotacion getResultadoVotacion() {
		return resultadoVotacion;
	}


	public void setResultadoVotacion(ResultadoVotacion resultadoVotacion) {
		this.resultadoVotacion = resultadoVotacion;
	}
	
	
	
}
