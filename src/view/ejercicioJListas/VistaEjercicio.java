package view.ejercicioJListas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorMateria;
import controller.ControladorProfesor;
import model.Materia;
import model.Profesor;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaEjercicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<Materia> jcbMateria;
	JComboBox<Profesor> jcbProfesor;
	private List<Materia> materias;
	private List<Profesor> profesores;

	private JPanel contentPane;
	private JButton btnNewButton_1;
	private JComboBox<Float> jcbNotas;
	private JLabel lblNewLabel_2;
	private PanelListas p;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEjercicio frame = new VistaEjercicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaEjercicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.gridwidth = 11;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 3;
		gbc_jcbMateria.gridy = 0;
		contentPane.add(jcbMateria, gbc_jcbMateria);

		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.weightx = 1.0;
		gbc_jcbProfesor.gridwidth = 11;
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 3;
		gbc_jcbProfesor.gridy = 1;
		contentPane.add(jcbProfesor, gbc_jcbProfesor);

	
		
		btnNewButton_1 = new JButton("Actualizar notas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Materia mat = (Materia) jcbMateria.getSelectedItem();
				Profesor prof = (Profesor) jcbProfesor.getSelectedItem();
				Float nota = (Float) jcbNotas.getSelectedItem();
				p.actualizarEstudiantes(mat, prof, nota);

			}
		});
		
				JButton btnNewButton = new JButton("Botón refrescar alumnado");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});
				
				lblNewLabel_2 = new JLabel("Nota:");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 2;
				contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
				
				jcbNotas = new JComboBox<Float>();
				GridBagConstraints gbc_jcbNotas = new GridBagConstraints();
				gbc_jcbNotas.gridwidth = 11;
				gbc_jcbNotas.insets = new Insets(0, 0, 5, 5);
				gbc_jcbNotas.fill = GridBagConstraints.HORIZONTAL;
				gbc_jcbNotas.gridx = 3;
				gbc_jcbNotas.gridy = 2;
				contentPane.add(jcbNotas, gbc_jcbNotas);
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton.gridx = 16;
				gbc_btnNewButton.gridy = 2;
				contentPane.add(btnNewButton, gbc_btnNewButton);
		
		p = new PanelListas();
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 7;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(p, gbc_lblNewLabel_3);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 16;
		gbc_btnNewButton_1.gridy = 7;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

		materias = new ArrayList<Materia>();
		materias = ControladorMateria.findAll();
		for (int i = 0; i < materias.size(); i++) {
			jcbMateria.addItem(materias.get(i));
		}

		profesores = new ArrayList<Profesor>();
		profesores = ControladorProfesor.findAll();
		for (int i = 0; i < profesores.size(); i++) {
			jcbProfesor.addItem(profesores.get(i));
		}
		
		for (float i = 0; i < 11; i++) {
			jcbNotas.addItem(i);
		}

	}
	


}
