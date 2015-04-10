package ungs.edu.ve.util;

public interface CONSTANTE {

	String ESTADO_INICIAL = "inicial";
	String ESTADO_PROCESO = "proceso";
	String ESTADO_FINALIZADO = "finalizado";
	String MENSAJE_CONFIRMACION_VOTO = "Desea Confirmar su voto?";
	String ERROR_DNI_INGRESADO_INVALIDO = "El dato ingresado no es valido, verifique de ingresar solo numeros";

	String ERROR_DNI_INEXISTENTE="El numero de DNI ingresado no existe en el padron";
	String ERROR_PERSONA_YA_VOTO="El numero de DNI ingresado ya realizo su voto";
	
	Long CODIGO_INICIAL = 1L;
	Long CODIGO_PROCESO = 2L;
	Long CODIGO_FINALIZADO = 3L;

}
