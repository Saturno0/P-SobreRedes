package cine;
import java.util.Scanner;


public class pelicula {

	private String[] formatosCorrectos = {"2D", "3D"};
	
	private String titulo;
	private String genero;
	private String formato;
//	private Scanner s = new Scanner(System.in);
	
	public pelicula(String titulo, String genero, String formato) {
		this.titulo = titulo;
		this.genero = genero;
		this.formato = formato;
	}

	
	public String[] getFormato() {
		return formatosCorrectos;
	}

	

}
