package ungs.edu.ve.modelo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import ungs.edu.ve.modelo.Estado;
import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.dao.VotanteDAO;
import ungs.edu.ve.util.CONSTANTE;


public class VotanteDAOImplMock implements VotanteDAO {

	private static final long ID = 1000l;
	private static final String NOMBRE = "ALBERTO";
	private static final String APELLIDO = "PEREZ";
	private static final Integer NRODOCUMENTO = 33282892;
	private static final String TIPO = "DOCENTE";
	private Votante votante;
	private ArrayList<Votante> votantes=new ArrayList<Votante>();
	
	private void loadVotante(){
		Estado estado=new Estado();
		estado.setCodigo(CONSTANTE.ESTADO_INICIAL);
		votante = new Votante();
		votante.setId(ID);
		votante.setNombre(NOMBRE);
		votante.setApellido(APELLIDO);
		votante.setNroDocumento(NRODOCUMENTO);
		votante.setTipo(TIPO);
		votante.setEstado(estado);
	}
	
	private void loadListaVotantes(){
		
		loadVotante();
		votantes.add(votante);
	}
	
	@Override
	public void guardar(Object entidad) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarList(List entidad) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Object entidad) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Object entidad) throws HibernateException {
		
	}

	@Override
	public Object getById(Object clase, Long id) throws HibernateException {
		loadVotante();
		return votante;
	}

	@Override
	public List getAll(Object clase) throws HibernateException {
		loadListaVotantes();
		return votantes;
	}

	
}
 