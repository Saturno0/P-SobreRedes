package Curso;

import Utilidades.utilidades;

public class Curso {
	private String nombre;
	private String categoria;
	private String profesor;
	private float calificacion;
	private int cantCalificaciones;
	private int precio;
	
	public Curso(String nombre, String categoria, String profesor, float calificacion, int cantCalificaciones, int precio) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.profesor = profesor;
		this.calificacion = calificacion;
		this.cantCalificaciones = cantCalificaciones;
		this.precio = precio;
	}
	
	public void calificar() {
		System.out.println("Cual seria la calificacion que le da al curso: ");
		float calificacion = utilidades.ingresarFloat(1, 5);
		this.cantCalificaciones++;
		
		this.calificacion = promediarCalificaciones(calificacion);
	}
	
	private float promediarCalificaciones(float calificacion) {
		float n = this.calificacion + calificacion;
		n /= 2;
		return n;
	}
	
	public float getCalificacion() {
		return this.calificacion;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getProfesor() {
		return this.profesor;
	}
	
	public int getPrecio() {
		return this.precio;
	}

	public int getCanCalificaciones() {
		return this.cantCalificaciones;
	}
}
