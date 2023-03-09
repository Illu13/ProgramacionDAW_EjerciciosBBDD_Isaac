package com.jds.centroEducativo.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jds.centroEducativo.controller.ControladorProfesor;
import com.jds.centroEducativo.model.Profesor;

public class VistaProfesor extends JPanel {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfA1;
	private JTextField jtfA2;
	private JTextField jtfDni;
	private JTextField jtfDir;
	private JTextField jtfEmail;
	private JTextField jtfTelf;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VistaProfesor() {
		setBounds(100, 100, 578, 375);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		this.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Gestión de profesores");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		this.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		this.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido 1");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfA1 = new JTextField();
		GridBagConstraints gbc_jtfA1 = new GridBagConstraints();
		gbc_jtfA1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfA1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfA1.gridx = 1;
		gbc_jtfA1.gridy = 3;
		add(jtfA1, gbc_jtfA1);
		jtfA1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido 2");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfA2 = new JTextField();
		GridBagConstraints gbc_jtfA2 = new GridBagConstraints();
		gbc_jtfA2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfA2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfA2.gridx = 1;
		gbc_jtfA2.gridy = 4;
		add(jtfA2, gbc_jtfA2);
		jtfA2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("DNI");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Direccion");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfDir = new JTextField();
		GridBagConstraints gbc_jtfDir = new GridBagConstraints();
		gbc_jtfDir.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDir.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDir.gridx = 1;
		gbc_jtfDir.gridy = 6;
		add(jtfDir, gbc_jtfDir);
		jtfDir.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Teléfono");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfTelf = new JTextField();
		GridBagConstraints gbc_jtfTelf = new GridBagConstraints();
		gbc_jtfTelf.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelf.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelf.gridx = 1;
		gbc_jtfTelf.gridy = 8;
		add(jtfTelf, gbc_jtfTelf);
		jtfTelf.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
		this.add(panel, gbc_panel);

		JButton btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarPrimerRegistro();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Profesor p = new Profesor();
				if (jtfId.getText().isEmpty()) {
					try {
						cargarPrimerRegistro();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					p.setId(Integer.parseInt(jtfId.getText()));
					try {
						cargarAnteriorRegistro(p);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(">");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Profesor p = new Profesor();
				if (jtfId.getText().isEmpty()) {
					try {
						cargarPrimerRegistro();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					p.setId(Integer.parseInt(jtfId.getText()));
					try {
						cargarSiguienteRegistro(p);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton(">>");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					cargarUltimoRegistro();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Guardar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Profesor p = new Profesor();

				p.setNombre(jtfNombre.getText());
				p.setApellido1(jtfA1.getText());
				p.setApellido2(jtfA2.getText());
				p.setDni(jtfDni.getText());
				p.setDireccion(jtfDir.getText());
				p.setEmail(jtfEmail.getText());
				p.setTelefono(jtfTelf.getText());

				if (jtfId.getText().isEmpty() == false) {
					try {
						p.setId(Integer.parseInt(jtfId.getText()));
						actualizarRegistro(p);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					p.setId(0);
					try {
						insertarRegistro(p);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Nuevo");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limpiarCampos();
			}
		});
		panel.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Eliminar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Profesor p = new Profesor();
				p.setId(Integer.parseInt(jtfId.getText()));
				try {
					confirmarDelete(p);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		panel.add(btnNewButton_6);
	}

	/**
	 * 
	 * @throws SQLException
	 */
	public void cargarPrimerRegistro() throws SQLException {

		Profesor p = ControladorProfesor.firstRegister();

		jtfId.setText("" + p.getId());
		jtfNombre.setText(p.getNombre());
		jtfA1.setText(p.getApellido1());
		jtfA2.setText(p.getApellido2());
		jtfDni.setText(p.getDni());
		jtfDir.setText(p.getDireccion());
		jtfEmail.setText(p.getEmail());
		jtfTelf.setText(p.getTelefono());
		
	}

	/**
	 * 
	 * @throws SQLException
	 */

	public void cargarUltimoRegistro() throws SQLException {

		Profesor p = ControladorProfesor.lastRegister();


		jtfId.setText("" + p.getId());
		jtfNombre.setText(p.getNombre());
		jtfA1.setText(p.getApellido1());
		jtfA2.setText(p.getApellido2());
		jtfDni.setText(p.getDni());
		jtfDir.setText(p.getDireccion());
		jtfEmail.setText(p.getEmail());
		jtfTelf.setText(p.getTelefono());
	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void cargarSiguienteRegistro(Profesor p) throws SQLException {

		Profesor prof = ControladorProfesor.nextRegister(p);


		jtfId.setText("" + prof.getId());
		jtfNombre.setText(prof.getNombre());
		jtfA1.setText(prof.getApellido1());
		jtfA2.setText(prof.getApellido2());
		jtfDni.setText(prof.getDni());
		jtfDir.setText(prof.getDireccion());
		jtfEmail.setText(prof.getEmail());
		jtfTelf.setText(prof.getTelefono());
	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void cargarAnteriorRegistro(Profesor p) throws SQLException {

		Profesor prof = ControladorProfesor.previousRegister(p);

		jtfId.setText("" + prof.getId());
		jtfNombre.setText(prof.getNombre());
		jtfA1.setText(prof.getApellido1());
		jtfA2.setText(prof.getApellido2());
		jtfDni.setText(prof.getDni());
		jtfDir.setText(prof.getDireccion());
		jtfEmail.setText(prof.getEmail());
		jtfTelf.setText(prof.getTelefono());
	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void actualizarRegistro(Profesor p) throws SQLException {

		if (ControladorProfesor.updateRegister(p) != 1) {
			JOptionPane.showConfirmDialog(null, "Algo ha salido mal.");
		} else {
			JOptionPane.showConfirmDialog(null, "Guardado correctamente.");

		}

	}
	
	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void insertarRegistro(Profesor p) throws SQLException {

		if (ControladorProfesor.insertRegister(p) != 1) {
			JOptionPane.showConfirmDialog(null, "Algo ha salido mal.");
		} else {
			JOptionPane.showConfirmDialog(null, "Guardado correctamente.");

		}

	}
	
	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void realizarDelete(Profesor p) throws SQLException {
		
		if (ControladorProfesor.deleteRegister(p) != 1) {
			JOptionPane.showConfirmDialog(null, "Algo ha salido mal.");
		} else {
			JOptionPane.showConfirmDialog(null, "Eliminado correctamente.");

		}
	}
	
	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */
	
	private void confirmarDelete(Profesor p) throws SQLException {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(null,"¿Desea borrar el registro?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			realizarDelete(p);
			limpiarCampos();
		}
	}
	
	/**
	 * 
	 */

	private void limpiarCampos() {
		jtfNombre.setText("");
		jtfId.setText("");
		jtfEmail.setText("");
		jtfDni.setText("");
		jtfDir.setText("");
		jtfTelf.setText("");
		jtfA1.setText("");
		jtfA2.setText("");




	}

}