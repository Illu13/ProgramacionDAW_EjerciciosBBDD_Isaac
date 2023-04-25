package view.ejercicioJListas;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import controller.ControladorEstudiante;
import controller.ControladorValoracionMateria;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelListas extends JPanel {
	JList listAlumnosSi;
	JList listAlumnosNo;
	private DefaultListModel<Estudiante> listModelEstudiantes = null;
	private DefaultListModel<Estudiante> listModelEstudiantesSel = null;

	private List<Estudiante> estudiantes = ControladorEstudiante.findAll();
	/**
	 * Create the panel.
	 */
	public PanelListas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Alumnado no seleccionado");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Alumnado seleccionado");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		listAlumnosNo = new JList(this.getDefaultListModel());
		listAlumnosNo.setBackground(Color.LIGHT_GRAY);
		this.listAlumnosNo.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto
		GridBagConstraints gbc_listAlumnosNo = new GridBagConstraints();
		gbc_listAlumnosNo.weightx = 1.0;
		gbc_listAlumnosNo.insets = new Insets(0, 0, 5, 5);
		gbc_listAlumnosNo.fill = GridBagConstraints.BOTH;
		gbc_listAlumnosNo.gridx = 0;
		gbc_listAlumnosNo.gridy = 1;
		add(listAlumnosNo, gbc_listAlumnosNo);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 2.0;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverTodosEstudiantesSi();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverEstudiantesSi();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_2 = new JButton(">");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverEstudiantes();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 3;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);

		JButton btnNewButton_3 = new JButton(">>");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverTodosEstudiantes();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 4;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);

		listAlumnosSi = new JList(this.getDefaultListModelEstuSi());
		listAlumnosSi.setBackground(Color.LIGHT_GRAY);
		this.listAlumnosSi.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto
		GridBagConstraints gbc_listAlumnosSi = new GridBagConstraints();
		gbc_listAlumnosSi.insets = new Insets(0, 0, 5, 0);
		gbc_listAlumnosSi.weightx = 1.0;
		gbc_listAlumnosSi.fill = GridBagConstraints.BOTH;
		gbc_listAlumnosSi.gridx = 3;
		gbc_listAlumnosSi.gridy = 1;
		add(listAlumnosSi, gbc_listAlumnosSi);

		for (Estudiante estu : estudiantes) {
			this.listModelEstudiantes.addElement(estu);
		}

	}

	private DefaultListModel getDefaultListModel() {
		this.listModelEstudiantes = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantes;
	}

	private DefaultListModel getDefaultListModelEstuSi() {
		this.listModelEstudiantesSel = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantesSel;
	}

	private void moverEstudiantes() {
		for (int i = this.listAlumnosNo.getSelectedIndices().length - 1; i >= 0; i--) {
			Estudiante estu = (Estudiante) this.listModelEstudiantes.get(listAlumnosNo.getSelectedIndices()[i]);
			this.listModelEstudiantes.removeElementAt(this.listAlumnosNo.getSelectedIndices()[i]);
			this.listModelEstudiantesSel.addElement(estu);
		}
	}

	private void moverEstudiantesSi() {
		for (int i = this.listAlumnosSi.getSelectedIndices().length - 1; i >= 0; i--) {
			Estudiante estu = (Estudiante) this.listModelEstudiantesSel.get(listAlumnosSi.getSelectedIndices()[i]);
			this.listModelEstudiantesSel.removeElementAt(this.listAlumnosSi.getSelectedIndices()[i]);
			this.listModelEstudiantes.addElement(estu);
		}
	}

	private void moverTodosEstudiantes() {

		for (int i = this.listModelEstudiantes.getSize() - 1; i >= 0; i--) {

			Estudiante estu = (Estudiante) this.listModelEstudiantes.get(i);
			this.listModelEstudiantes.removeElementAt(i);
			this.listModelEstudiantesSel.addElement(estu);

		}

	}

	private void moverTodosEstudiantesSi() {

		for (int i = this.listModelEstudiantesSel.getSize() - 1; i >= 0; i--) {

			Estudiante estu = (Estudiante) this.listModelEstudiantesSel.get(i);
			this.listModelEstudiantesSel.removeElementAt(i);
			this.listModelEstudiantes.addElement(estu);

		}

	}

	public void actualizarEstudiantes(Materia mat, Profesor prof, float nota) {

		for (int i = 0; i < listModelEstudiantesSel.getSize(); i++) {

			Estudiante estu = listModelEstudiantesSel.get(i);
			Valoracionmateria va = ControladorValoracionMateria.findByIdsEstu(mat.getId(), prof.getId(), estu.getId());
			if (va != null) {
				va.setValoracion(nota);
				ControladorValoracionMateria.modificar(va);
			} else {
				va = new Valoracionmateria();
				va.setEstudiante(estu);
				va.setMateria(mat);
				va.setProfesor(prof);
				va.setValoracion(nota);
				ControladorValoracionMateria.insertar(va);
			}
		}
	}

}
