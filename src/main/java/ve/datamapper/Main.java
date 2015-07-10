package ve.datamapper;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		DB<Persona> db=new DB<Persona>();
		String query=db.createSelectQuery(Persona.class);
		System.out.println(query);
		List<Persona> result=db.executeQuery(query);
		for (Persona persona : result) {
			System.out.println(persona);
		}
	}
	
	
}
