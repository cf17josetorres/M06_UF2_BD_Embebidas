package PracticaNeodatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;
import java.util.Scanner;

public class BaseDatos {
	Scanner reader = new Scanner(System.in);
	public ODB odb;

	public BaseDatos() {
		odb = ODBFactory.open("neodatis.test");
	}

	public void insertar(Jugador jug) {
		odb.store(jug);
	}

	public void listar() {
		Objects<Jugador> objetos=odb.getObjects(Jugador.class);
		System.out.println(objetos.size() + " jugadores:");
		int i = 1;
		while(objetos.hasNext()) {
			Jugador jug = objetos.next();
			System.out.println((i++) + jug.toString());
		}
	}

	public void borrar(String jugador) {
		IQuery query = new CriteriaQuery(Jugador.class,
				Where.equal("nombre", jugador));
		Objects<Jugador> objects = odb.getObjects(query);
		Jugador jug=(Jugador) odb.getObjects(query).getFirst();
		odb.delete(jug);
	}

	public void actualizar(String jugador) {
		IQuery query = new CriteriaQuery(Jugador.class,
				Where.equal("nombre", jugador));
		Objects<Jugador> objects = odb.getObjects(query);
		Jugador jug=(Jugador) odb.getObjects(query).getFirst();
		System.out.print("Introducir el deporte: ");
		String deporte = reader.next();
		jug.setDeporte(deporte);
		System.out.print("Introducir la ciudad: ");
		String ciudad = reader.next();
		jug.setCiudad(ciudad);
		System.out.print("Introducir la edad: ");
		int edad = reader.nextInt();
		jug.setEdad(edad);
		odb.store(jug);
	}

	public void consulta() {}
	
	public void cerrarBaseDatos() {
		odb.close();
	}
}
