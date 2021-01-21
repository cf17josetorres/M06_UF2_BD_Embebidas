package PracticaNeodatis;

import java.util.Scanner;

public class Practica {

	public static void main(String[] args) throws Exception  {			
		Scanner reader = new Scanner(System.in);
		BaseDatos db = new BaseDatos();
		boolean fin=false;
		//CRUD--Create, Read, Update, Delete
		while (!fin) {
			System.out.println("1. Visualizar la lista de jugadores");
			System.out.println("2. Insertar un nuevo jugador");
			System.out.println("3. Borrar jugador");
			System.out.println("4. Modificar jugador");
			System.out.println("5. Consulta de jugadores por ciudad");
			System.out.println("6. Salir");
			System.out.print("Introduce que opcion quieres?");
			int opcion = reader.nextInt();
			switch(opcion) {
			case 1:
				db.listar();
				break;
			case 2:
				System.out.print("Introducir el nombre: ");
				String nombre = reader.next();
				System.out.print("Introducir el deporte: ");
				String deporte = reader.next();
				System.out.print("Introducir la ciudad: ");
				String ciudad = reader.next();
				System.out.print("Introducir la edad: ");
				int edad = reader.nextInt();
				db.insertar(new Jugador(nombre, deporte, ciudad, edad));
				break;
			case 3:	
				System.out.print("Introducir el nombre: ");
				String nombree = reader.next();
				db.borrar(nombree);
				break;
			case 4:
				System.out.print("Introducir el jugador que quieres actualizar: ");
				String jugador = reader.next();
				db.actualizar(jugador);
				break;
			case 5:
				db.listar();
				db.consulta();
				db.listar();
				break;
			case 6:
				db.cerrarBaseDatos();
				fin=true;
				break;
			}
		}
	}	
}
