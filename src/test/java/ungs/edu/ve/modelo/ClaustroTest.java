package ungs.edu.ve.modelo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ClaustroTest {

	private static final long ID=1000l;
	private static final String DESCRIPCION="CLAUSTRO DE PERSONAL DOCENTE";
	private static final String NOMBRE="DOCENTES";
	
	
	
	private Claustro claustro;
	 
   
    @Before
    public void preparar() {
        claustro = new Claustro();
        claustro.setId(ID);
        claustro.setNombre(NOMBRE);
        claustro.setDescripcion(DESCRIPCION);
        
      }
 
    @Test
    public void testGetterClaustro() {
       
        Assert.assertNotNull(claustro);
        Assert.assertEquals(claustro.getDescripcion(), DESCRIPCION);
        Assert.assertEquals(claustro.getNombre(), NOMBRE);
        Assert.assertTrue(claustro.getId() == ID);
 
    }
 
   
    @SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
    public void testNullPointer() {
 
        Claustro claustroNull = null;
        claustroNull.getDescripcion().equals(DESCRIPCION);
 
    }
 
}