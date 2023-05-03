package view.ejercicioJTable;

import java.util.List;

import controller.ControladorEstudiante;
import model.Estudiante;


public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "1� apellido", "2� apellido", "Dirección", "DNI", "Email", "Teléfono", "Sexo"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Estudiante> personas = ControladorEstudiante.findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[personas.size()][9];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < personas.size(); i++) {
			Estudiante persona = personas.get(i);
			datos[i][0] = persona.getId();
			datos[i][1] = persona.getNombre();
			datos[i][2] = persona.getApellido1();
			datos[i][3] = persona.getApellido2();
			datos[i][4] = persona.getDireccion();
			datos[i][5] = persona.getDni();
			datos[i][6] = persona.getEmail();
			datos[i][7] = persona.getTelefono();
			datos[i][8] = persona.getTipologiasexo();
		}
		
		return datos;
	}
	
	
}
