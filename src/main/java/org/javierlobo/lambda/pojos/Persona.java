package org.javierlobo.lambda.pojos;

import java.util.Objects;

public class Persona {
		
	private String nombre;
	private Integer edad;
	private String fechaNacimiento;
	private Integer salario;
	private String estudios;
	private Integer estadoCivil; // 0 = Soltero | 1 = Casado
	
	
	public Persona() {
		this.nombre = "";
		this.fechaNacimiento = null;
		this.edad = 0;
		this.salario = 0;
		this.estudios = "";
		this.estadoCivil = 0;
	}
	
	public Persona(String nombre, Integer edad, String fechaNacimiento, Integer salario, String estudios,
			Integer estadoCivil) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad != null ? edad : 3;
		this.salario = salario;
		this.estudios = estudios;
		this.estadoCivil = estadoCivil;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Integer getSalario() {
		return salario;
	}

	public String getEstudios() {
		return estudios;
	}

	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String toJson() {
		return "{'nombre': '" + this.nombre + "','edad': " + this.getEdad() + "," +
				"'fechaNacimiento': '" + this.getFechaNacimiento() + "','" +
				"'salario': " + this.getSalario() + "," +
				"'estudios': '" + this.getEstudios() + "'," +
				"'estadoCivil': '" + this.getEstadoCivil() + "'}";
	}

	public String toFile() {
		return this.getNombre() + ":" + this.getEdad() + ":" + this.getFechaNacimiento()  + ":"
				+ this.getSalario() + ":" + this.getEstudios()  + ":" + this.getEstadoCivil() ;
	}
	@Override
	public String toString() {
		return nombre + " (" + edad + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, estadoCivil, estudios, fechaNacimiento, nombre, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Persona other = (Persona) obj;
		return Objects.equals(edad, other.edad) && Objects.equals(estadoCivil, other.estadoCivil)
				&& Objects.equals(estudios, other.estudios) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(salario, other.salario);
	}

}