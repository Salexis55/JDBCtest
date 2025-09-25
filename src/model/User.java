package model;

public class User {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	String name;
	String email;
	String password;
	int edad;
	float estatura;
	int telefono;
	int ID;

//Los atributos de...

	private long id;

	public User(long id, String name) {

	}

	public User() {
	}

	public User(long id, String name, String email, String password, float estatura) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.estatura = estatura;
		this.email = email;
 
	}	

}