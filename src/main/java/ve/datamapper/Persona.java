package ve.datamapper;



public class Persona {

	
    private String firstName;
    private String lastName;
    private int age;
    private Double peso;
    private boolean empleado;
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public boolean isEmpleado() {
		return empleado;
	}
	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Persona [firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", peso=" + peso + ", empleado=" + empleado
				+ "]";
	}
	

    //getters and setters for the above fields are omitted
    //Imagine they were below. Go on, it'll make life easier.

}
