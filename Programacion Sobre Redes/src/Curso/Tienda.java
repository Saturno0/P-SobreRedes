package Curso;

import Utilidades.utilidades;

public class Tienda {
	
	private String[][] cursosDisponibles = {// Nombre del curso - Categoría - Profesor - Calificación - Cant Calif - Precio
			{"Master en Python 3.x.","Programación","Alvaro Chirou", "4.5f", "10", "0"},
			{"Scrum Master", "Negocios", "Fabian Schwartz", "4", "6", "12"},
			{"Guia de importación", "Negocios","Roderick Stroethoff","4.4f","12","13"},
			{"Master diseño digital", "Diseño","Mariano Rivas","4.2f","20","15"},
			{"Angular de cero a experto","Programación","Juan Pablo De la Torre","4.7f","28","20"},
			{"Flutter, la guía completa","Programación","Fernando Herrera","3.7f","40","9"},
			{"Facebook Ads", "Marketing","Jose Mark","4.2f","30","11"},
			{"Instagram Marketing","Marketing","Diego Davila","4","4","5"},
			{"Esculpido orgánico con ZBrush","Diseño","Odin Fernandez","4.6f","21","8"},
			{"Análisis y visualización de datos","Negocios","Sergio Llobet","3.4f","16","18"},
			{"Autorías internas de ISO 9001","Negocios","Ruben Clemente","4.6f","76","27"},
			{"Blender 2.9 experto","Diseño","Mariano Rivas","4.1","30","25"},
			{"Retargeting en Facebook","Marketing","Jose Mark","4.8f","44","17"},
			{"Master en CSS","Programación","Victor Robles","4.2f","56","6"},
			{"React JS + Redux", "Programación","Emiliano Ocariz","4.5f","40","22"},
			{"Curso de AutoCAD","Diseño","Felipe Nicholls","4","11","13"},
			{"Google Ads para principiantes","Marketing","Diego Davila","3.9f","77","11"},
			{"Neuromarketing","Marketing","Diego Ramos","4.0f","29","15"},
			{"Optimización de almacenes","Negocios","Marco Canciani","4.4f","54","12"},
			{"Como tener buena voz","Negocios","Mauro Martinez","2.5f","53","49"},
			{"Aprende a vender en Amazon","Negocios","Alberto Caleb","4.2f","22","19"},
			{"Comercio internacional y logística","Negocios","Maicol Gutierrez","4.3f","62","13"},
			{"Master en MAYA","Diseño","Rodrigo Reyes","4.4f","8","30"},
			{"Analítica WEB","Marketing","Raul Liñan","4.3f","67","14"},
			{"Desarrollo de juegos con Unreal","Programación","Juan Comila","4.7f","36","45"},
			{"Aprende C++","Programación","Alejandro Taobada","4.8f","40","19"},
			{"After Effects", "Masterclass","Diseño","4.2f","71","5"},
			{"UX/UI Design","Diseño","Andres Brachetta","3.9f","19","29"},
			{"Gana seguidores en IG","Marketing","Biel Tenias","3","23","14"},
			{"Chatbot","Marketing","Ivan Rojas","4.7f","36","17"},
			{"Adobe XD","Diseño","Marlon Ceballos","4.5f","45","21"},
			{"Java y BlueJ","Programación","Juan Villavazo","4.6f","29","13"},
			{"PHP 7","Programación","Juan Urrego","4.4f","29","17"},
			{"Archicad BIM","Diseño","Iván Serna","4.6f","43","20"},
			{"VRAY Sketchup","Diseño","Alvaro García","4.3f","49","13"}}; 
	
	private Curso[] cursos = new Curso[cursosDisponibles.length];
	private int cursosComprados = 0;
	private String[][] carrito;
	private String[][] carritoSecundario = new String[cursosDisponibles.length][cursosDisponibles[1].length];
	
	public Tienda() {
		comprar();
	}
	
	private void comprar() {
		int opcion = 0;
		crearCursos();
		while (opcion != 7) {
			opcion = menu();
			switch (opcion) {
			case 1:
				mostrarCursos();
				break;
			case 2:
				mostrarCursoMayorCalificacion();
				break;
			case 3:
				mostrarCursoMenorPrecio();
				break;
			case 4:
				calificarCurso();
				break;
			case 5:
				agregarCarrito();
				break;
			case 6:
				finalizarCompra();
				break;
				
			}
		}
		System.exit(0);
		

	}
	
	
	
	private void finalizarCompra() {
		this.carrito = new String[cursosComprados][cursosDisponibles[0].length];
		
		for (int i = 0; i < cursosComprados; i++) {
			if(yaEstaComprado(i)) {
				carrito[i] = carritoSecundario[i];				
			}
		}
		
		int precioTotal = 0;
		System.out.println("Estos son los productos que va a comprar:");
		for (int i = 0; i < cursosComprados; i++) {
			System.out.println("----------------------------------------------------");
			System.out.println("Nombre: " + carrito[i][0] + " - Precio: $" + carrito[i][5]);
			precioTotal += Integer.valueOf(carrito[i][5]);
		}
		System.out.println("------------------------------------");
		System.out.println("Costo total: $" + precioTotal);
	}

	private void agregarCarrito() {
		System.out.println("Elija que curso desea agregar al carrito :)");
		mostrarCursos();
		System.out.println("Salir");
		int index = utilidades.ingresarEntero(1, (cursos.length+1));
		
		if(index == (cursos.length + 1) || yaEstaComprado(index)) {
			return;
		}
		cursosComprados++;
		
		int i = 0;
		index -= 1;
		while (i<cursosComprados) {
			String nombre = cursos[index].getNombre();
			String categoria = cursos[index].getCategoria();
			String profesor = cursos[index].getProfesor();
			String calificacion = String.valueOf(cursos[index].getCalificacion()); 
			String cantCalificaciones = String.valueOf(cursos[index].getCanCalificaciones());
			String precio = String.valueOf(cursos[index].getPrecio());
			
			carritoSecundario[i][0] = nombre;
			carritoSecundario[i][1] = categoria;
			carritoSecundario[i][2] = profesor;
			carritoSecundario[i][3] = calificacion;
			carritoSecundario[i][4] = cantCalificaciones;
			carritoSecundario[i][5] = precio;
			
			i++;
		}
		
	}


	private boolean yaEstaComprado(int index) {
		int i = 0;
		boolean encontrado = false;
		
		while(i < cursosComprados && !encontrado) {
			if(carritoSecundario[index][0].equals(cursos[i].getNombre())) {
				encontrado = true;
			}
			i++;
		}
		
		return encontrado;
	}


	private void calificarCurso() {
		int i = 0;
		while(i < cursosComprados) {
			System.out.println("Que curso quiere calificar");
			for (int j = 0; j < cursosComprados; j++) {
				mostrarCurso(i);
			}
			System.out.println((cursosComprados + 1) + ") Salir");
			int index = utilidades.ingresarEntero(1, (cursosComprados+1));
			
				
			if(index == (cursosComprados + 1)) {
				return;
			}
			
			cursos[index-1].calificar();
			i++;
		}
		
		if(cursosComprados == 0) {
			System.out.println("Usted no ah comprado ningun curso asi que no puede calificar ninguno");
		}
	}
	

	private void mostrarCursoMenorPrecio() {
		int index = 0;
		int testigo = 0;
		do {
			testigo +=1;
		} while (cursos[testigo].getPrecio() <= 0);
		
		int min = cursos[testigo].getPrecio();
		for (int i = testigo; i < cursos.length; i++) {
			if(cursos[i].getPrecio() != 0 && cursos[i].getPrecio() < min) {
				min = cursos[i].getPrecio();
				index = i;
			}
		}
		
		mostrarCurso(index);
		System.out.println("--------------------------------");
	}

	private void mostrarCursoMayorCalificacion() {
		
		float max = cursos[0].getCalificacion();
		int index = 0;
		for (int i = 1; i < cursosDisponibles.length; i++) {
			if(cursos[i].getCalificacion() > max) {
				max = cursos[i].getCalificacion();
				index = i;
			}
		}
		
		mostrarCurso(index);
		
	}

	private void crearCursos() {
		for (int i = 0; i < cursosDisponibles.length; i++) {
			String nombre = cursosDisponibles[i][0];
			String categoria = cursosDisponibles[i][1];
			String profesor = cursosDisponibles[i][2];
			float calificacion = Float.valueOf(cursosDisponibles[i][3]);
			int cantCalificaciones = Integer.valueOf(cursosDisponibles[i][4]);
			int precio = Integer.valueOf(cursosDisponibles[i][5]);
			
			cursos[i] = new Curso(nombre,categoria,profesor,calificacion,cantCalificaciones,precio);
		}
	}

	private int menu() {
		int opcion = 0;
		mostrarMenu();
		opcion = utilidades.ingresarEntero(1, 7);
		return opcion;
	}

	private void mostrarMenu() {
		System.out.println("1) Mostrar cursos");
		System.out.println("2) Mostrar el curso con mayor calificacion");
		System.out.println("3) Mostrar el curso con menor precio");
		System.out.println("4) Calificar curso");
		System.out.println("5) Agregar curso al carrito");
		System.out.println("6) Finalizar combra");
		System.out.println("7) Salir");
	}
	
	private void mostrarCursos() {
		for (int i = 0; i < cursosDisponibles.length; i++) {
			System.out.println("---------------------------------------------------------------------------------------------------------");
			mostrarCurso(i);
		}
	}

	private void mostrarCurso(int i) {
		System.out.println((i+1) + ") Nombre: " + cursos[i].getNombre() + " - Categoria: " + cursos[i].getCategoria() + " - Profesor: " + cursos[i].getProfesor() + " - Calificacion: " + cursos[i].getCalificacion() + " - Cantidad de calificaciones: " + cursosDisponibles[i][4] + " - Precio: " + cursos[i].getPrecio());
	}
}
