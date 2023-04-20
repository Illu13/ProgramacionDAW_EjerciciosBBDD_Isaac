package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import controller.ControladorEstudiante;
import controller.ControladorMateria;
import controller.ControladorProfesor;
import controller.ControladorValoracionMateria;
import model.Estudiante;
import model.Profesor;
import model.Valoracionmateria;

import java.awt.Insets;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class PanelCargarUsuarios extends JPanel {
	private JTextField textField;
	private List<Valoracionmateria> valos;
	private List<Estudiante> estudiantes;
	private List<JTextField> campos;

	/**
	 * Create the panel.
	 */
	public PanelCargarUsuarios() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 0.0 };
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

	}

	public void actualizarAlumno2(int idM, int idP) {

		campos = new ArrayList<JTextField>();
		if (campos != null) {
			campos.clear();
		}

		int contadorY = 1;

		estudiantes = ControladorEstudiante.findAll();

		for (Estudiante vm : estudiantes) {

			Estudiante estu = (Estudiante) vm;
			Valoracionmateria valm = ControladorValoracionMateria.findByIdsEstu(idM, idP, estu.getId());
			valos = ControladorValoracionMateria.findByIds(idM, idP);

			JLabel lblNewLabel = new JLabel(estu.getNombre() + " " + estu.getApellido1() + " " + estu.getApellido2());
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.weightx = 0.0;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = contadorY;
			add(lblNewLabel, gbc_lblNewLabel);

			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.gridwidth = 5;
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = contadorY;
			add(textField, gbc_textField);
			textField.setColumns(10);
			campos.add(textField);

			if (valm == null) {

			}

			else {
				textField.setText("" + valm.getValoracion());
			}

			contadorY++;

		}

	}

//	public void actualizarAlumnos(int idM, int idP) {
//		
//		campos = new ArrayList<JTextField>();
//		if (campos != null) {
//			campos.clear();
//		}
//		
//		int contadorY = 1;
//
//		valos = ControladorValoracionMateria.findByIds(idM, idP);
//
//		for (Valoracionmateria vm : valos) {
//
//			Estudiante estu = (Estudiante) vm.getEstudiante();
//			
//			JLabel lblNewLabel = new JLabel(estu.getNombre() + " " + estu.getApellido1() + " " + estu.getApellido2());
//			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
//			gbc_lblNewLabel.weightx = 0.0;
//			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
//			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
//			gbc_lblNewLabel.gridx = 0;
//			gbc_lblNewLabel.gridy = contadorY;
//			add(lblNewLabel, gbc_lblNewLabel);
//
//			textField = new JTextField();
//			GridBagConstraints gbc_textField = new GridBagConstraints();
//			gbc_textField.gridwidth = 5;
//			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
//			gbc_textField.gridx = 1;
//			gbc_textField.gridy = contadorY;
//			add(textField, gbc_textField);
//			textField.setColumns(10);
//			campos.add(textField);
//			
//			textField.setText("" + vm.getValoracion());
//			
//
//			contadorY++;
//
//		}
//
//	}

	public Valoracionmateria actualizarValoracion(int idP, int idM) {
		float nota;
		int valoracionElegida = 0;
		int estudiante = 0;

		for (JTextField jtf : campos) {
			if (jtf.getText().isBlank() == true || jtf.getText().isEmpty() == true) {

			} else {
				nota = Float.parseFloat(jtf.getText());
				try {
					Valoracionmateria vmCambio = valos.get(valoracionElegida);
					if (nota != vmCambio.getValoracion()) {
						vmCambio.setValoracion(nota);
						ControladorValoracionMateria.modificar(vmCambio);

					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					Valoracionmateria nueva = new Valoracionmateria();
					nueva.setId(ControladorValoracionMateria.findMaxId());
					nueva.setMateria(ControladorMateria.findById(idM));
					nueva.setProfesor(ControladorProfesor.findById(idP));
					nueva.setValoracion(nota);
					Estudiante estuMeter = estudiantes.get(estudiante);
					nueva.setEstudiante(estuMeter);
					ControladorValoracionMateria.insertar(nueva);

				}

			}
			valoracionElegida++;
			estudiante++;
		}

		return null;
	}

}
