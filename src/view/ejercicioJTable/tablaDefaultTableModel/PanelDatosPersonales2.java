package view.ejercicioJTable.tablaDefaultTableModel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import controller.ControladorEstudiante;
import controller.ControladorSexo;
import model.Estudiante;
import model.Tipologiasexo;
import utils.Apariencia;

import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.awt.event.ActionEvent;

public class PanelDatosPersonales2 extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellido;
	private JTextField jtfSegundoApellido;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JComboBox<Tipologiasexo> jcbSexo;
	private List<Tipologiasexo> sexos;
	private byte[] imagenEnArrayDeBytes;
	JColorChooser jColorChooser;
	JPanel jpPanelParaColorear = new JPanel();
	private JTextField jtfColor;
	private JLabel lblNewLabel_9;
	private JButton saveButton;
	private JButton firstButton;

	/**
	 * Create the panel.
	 */

	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	public PanelDatosPersonales2(DefaultTableModel dtm, JTable t) {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.rowHeights = new int[] { 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//		gridBagLayout.columnWidths = new int[] { 0, 0, 345, 296 };
//		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
//		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("id");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 2;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 2;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellido");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfApellido = new JTextField();
		GridBagConstraints gbc_jtfApellido = new GridBagConstraints();
		gbc_jtfApellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido.gridx = 2;
		gbc_jtfApellido.gridy = 3;
		add(jtfApellido, gbc_jtfApellido);
		jtfApellido.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Segundo apellido");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfSegundoApellido = new JTextField();
		GridBagConstraints gbc_jtfSegundoApellido = new GridBagConstraints();
		gbc_jtfSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSegundoApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSegundoApellido.gridx = 2;
		gbc_jtfSegundoApellido.gridy = 4;
		add(jtfSegundoApellido, gbc_jtfSegundoApellido);
		jtfSegundoApellido.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Sexo");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jcbSexo = new JComboBox<Tipologiasexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 2;
		gbc_jcbSexo.gridy = 5;
		add(jcbSexo, gbc_jcbSexo);

		JLabel lblNewLabel_5 = new JLabel("DNI");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 2;
		gbc_jtfDni.gridy = 6;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Dirección");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 2;
		gbc_jtfDireccion.gridy = 7;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 2;
		gbc_jtfEmail.gridy = 8;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Teléfono");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 9;
		add(lblNewLabel_8, gbc_lblNewLabel_8);

		JButton nextButton = new JButton("Siguiente");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguienteColumna(t);

				ponerValoresPanel(dtm, t);

			}

		});

		firstButton = new JButton("Primero");
		firstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setRowSelectionInterval(0, 0);

				ponerValoresPanel(dtm, t);

			}
		});

		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 2;
		gbc_jtfTelefono.gridy = 9;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		GridBagConstraints firstButtonConstraints = new GridBagConstraints();
		firstButtonConstraints.insets = new Insets(0, 0, 5, 5);
		firstButtonConstraints.gridx = 0;
		firstButtonConstraints.gridy = 10;
		add(firstButton, firstButtonConstraints);

		JButton previousButton = new JButton("Anterior");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				columnaAnterior(t);

				ponerValoresPanel(dtm, t);
			}

		});
		GridBagConstraints previousButtonConstraints = new GridBagConstraints();
		previousButtonConstraints.insets = new Insets(0, 0, 5, 5);
		previousButtonConstraints.gridx = 1;
		previousButtonConstraints.gridy = 10;
		add(previousButton, previousButtonConstraints);
		GridBagConstraints nextButtonConstraints = new GridBagConstraints();
		nextButtonConstraints.insets = new Insets(0, 0, 5, 5);
		nextButtonConstraints.gridx = 2;
		nextButtonConstraints.gridy = 10;
		add(nextButton, nextButtonConstraints);
		nextButtonConstraints.insets = new Insets(0, 0, 0, 5);
		nextButtonConstraints.gridx = 5;
		nextButtonConstraints.gridy = 10;

		JButton lastButton = new JButton("Último");
		lastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index1 = t.getRowCount() - 1;
				int index2 = t.getRowCount() - 1;
				t.setRowSelectionInterval(index1, index2);
				ponerValoresPanel(dtm, t);
			}

		});
		GridBagConstraints gbcLastButton = new GridBagConstraints();
		gbcLastButton.insets = new Insets(0, 0, 5, 5);
		gbcLastButton.gridx = 3;
		gbcLastButton.gridy = 10;
		add(lastButton, gbcLastButton);

		saveButton = new JButton("Guardar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 10;
		add(saveButton, gbc_btnNewButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante estu = obtenerDatos();

				if (estu.getId() != 0) {
					ControladorEstudiante.modificar(estu);
					ponerValores(dtm, t);

				} else {
					ControladorEstudiante.insertar(estu);
					ponerValoresObjetoInsertado(dtm, t, estu);
					setId(estu.getId());
				}

			}
		});

		JButton deleteButton = new JButton("Eliminar");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Estudiante estu = obtenerDatos();
				ControladorEstudiante.eliminar(estu);
				try {
					dtm.removeRow(t.getSelectedColumn());
				} catch (IndexOutOfBoundsException ex) {
					JOptionPane.showConfirmDialog(null, "Usted tiene que seleccionar una columna");
				}

			}
		});
		GridBagConstraints deleteGbc = new GridBagConstraints();
		deleteGbc.insets = new Insets(0, 0, 0, 5);
		deleteGbc.gridx = 1;
		deleteGbc.gridy = 11;
		add(deleteButton, deleteGbc);
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 11;

		JButton nuevaColumnaButton = new JButton("Nueva columna");
		nuevaColumnaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.addRow(new Object[] { "" });
				limpiarCampos();
			}
		});
		GridBagConstraints gbcNuevaColumna = new GridBagConstraints();
		gbcNuevaColumna.insets = new Insets(0, 0, 0, 5);
		gbcNuevaColumna.gridx = 2;
		gbcNuevaColumna.gridy = 11;
		add(nuevaColumnaButton, gbcNuevaColumna);

		sexos = new ArrayList<Tipologiasexo>();
		sexos = ControladorSexo.findAll();
		for (int i = 0; i < sexos.size(); i++) {
			jcbSexo.addItem(sexos.get(i));
		}

	}

	public String getId() {
		return jtfId.getText();

	}

	public String getNombre() {
		return jtfNombre.getText();

	}

	public String getApellido() {
		return jtfApellido.getText();

	}

	public String getSegundoApellido() {
		return jtfSegundoApellido.getText();

	}

	public Tipologiasexo getSexo() {
		return (Tipologiasexo) jcbSexo.getSelectedItem();

	}

	public String getDni() {
		return jtfDni.getText();

	}

	public String getDireccion() {
		return jtfDireccion.getText();

	}

	public String getEmail() {
		return jtfEmail.getText();

	}

	public String getTelefono() {
		return jtfTelefono.getText();

	}

	public byte[] getImagen() {
		return this.imagenEnArrayDeBytes;

	}

	public void setId(int id) {
		jtfId.setText("" + id);

	}

	public void setNombre(String nombre) {
		jtfNombre.setText(nombre);
	}

	public void setApellido(String apellido) {
		jtfApellido.setText(apellido);
	}

	public void setSegundoApellido(String apellido) {

		jtfSegundoApellido.setText(apellido);

	}

	public void setDni(String dni) {

		jtfDni.setText(dni);

	}

	public void setDireccion(String direccion) {

		jtfDireccion.setText(direccion);

	}

	public void setEmail(String email) {

		jtfEmail.setText(email);

	}

	public void setTelefono(String telefono) {

		jtfTelefono.setText(telefono);

	}

	public void setSexo(int sexo) {

		for (int i = 0; i < sexos.size(); i++) {
			if (sexo == sexos.get(i).getId()) {
				Tipologiasexo sexoASeleccionar = sexos.get(i);
				jcbSexo.setSelectedItem(sexoASeleccionar);
				break;
			}

		}
	}

	public void setSexo(String sexo) {

		for (int i = 0; i < sexos.size(); i++) {
			if (sexo == sexos.get(i).getDescripcion()) {
				Tipologiasexo sexoASeleccionar = sexos.get(i);
				jcbSexo.setSelectedItem(sexoASeleccionar);
				break;
			}

		}
	}

	public void limpiarCampos() {
		jtfNombre.setText("");
		jtfId.setText("");
		jtfEmail.setText("");
		jtfDni.setText("");
		jtfDireccion.setText("");
		jtfTelefono.setText("");
		jtfApellido.setText("");
		jtfSegundoApellido.setText("");

	}

	public Estudiante obtenerDatos() {

		Estudiante es = new Estudiante();
		if (getId().isBlank() == false) {
			es.setId(Integer.parseInt(getId()));
		} else {

		}

		es.setNombre(getNombre());
		es.setApellido1(getApellido());
		es.setApellido2(getSegundoApellido());
		es.setDni(getDni());
		es.setDireccion(getDireccion());
		es.setEmail(getEmail());
		es.setTelefono(getTelefono());
		es.setTipologiasexo(getSexo());
		es.setImagen(getImagen());

		return es;
	}

	private void ponerValores(DefaultTableModel dtm, JTable t) {
		int indiceFilaSel = t.getSelectedRow();
		dtm.setValueAt(getNombre(), indiceFilaSel, 1);
		dtm.setValueAt(getApellido(), indiceFilaSel, 2);
		dtm.setValueAt(getSegundoApellido(), indiceFilaSel, 3);
		dtm.setValueAt(getDireccion(), indiceFilaSel, 4);
		dtm.setValueAt(getDni(), indiceFilaSel, 5);
		dtm.setValueAt(getEmail(), indiceFilaSel, 6);
		dtm.setValueAt(getTelefono(), indiceFilaSel, 7);
		dtm.setValueAt(jcbSexo.getSelectedItem().toString(), indiceFilaSel, 8);
	}

	private void ponerValoresObjetoInsertado(DefaultTableModel dtm, JTable t, Estudiante estu) {
		int indiceFilaSel = t.getRowCount() - 1;
		dtm.setValueAt(estu.getId(), indiceFilaSel, 0);
		dtm.setValueAt(estu.getNombre(), indiceFilaSel, 1);
		dtm.setValueAt(estu.getApellido1(), indiceFilaSel, 2);
		dtm.setValueAt(estu.getApellido2(), indiceFilaSel, 3);
		dtm.setValueAt(estu.getDireccion(), indiceFilaSel, 4);
		dtm.setValueAt(estu.getDni(), indiceFilaSel, 5);
		dtm.setValueAt(estu.getEmail(), indiceFilaSel, 6);
		dtm.setValueAt(estu.getTelefono(), indiceFilaSel, 7);
		dtm.setValueAt(estu.getTipologiasexo().toString(), indiceFilaSel, 8);
	}

	private void ponerValoresPanel(DefaultTableModel dtm, JTable t) {
		int indiceFilaSel = t.getSelectedRow();
		setId((int) dtm.getValueAt(indiceFilaSel, 0));
		setNombre((String) dtm.getValueAt(indiceFilaSel, 1));
		setApellido((String) dtm.getValueAt(indiceFilaSel, 2));
		setSegundoApellido((String) dtm.getValueAt(indiceFilaSel, 3));
		setDireccion((String) dtm.getValueAt(indiceFilaSel, 4));
		setDni((String) dtm.getValueAt(indiceFilaSel, 5));
		setEmail((String) dtm.getValueAt(indiceFilaSel, 6));
		setTelefono((String) dtm.getValueAt(indiceFilaSel, 7));
		setSexo((((Tipologiasexo) dtm.getValueAt(indiceFilaSel, 8)).getId()));
	}

	private void siguienteColumna(JTable t) {
		int index1 = t.getSelectedRow();
		int index2 = t.getSelectedRow();

		if (index1 == 0 || index2 == 0) {
			t.setRowSelectionInterval(1, 1);
		} else {
			try {
				t.setRowSelectionInterval(index1 + 1, index2 + 1);
			} catch (IllegalArgumentException ex) {
				t.setRowSelectionInterval(0, 0);

			}
		}
	}

	private void columnaAnterior(JTable t) {
		int index1 = t.getSelectedRow();
		int index2 = t.getSelectedRow();

		if (index1 == 0 || index2 == 0) {
			t.setRowSelectionInterval(0, 0);
		} else {
			try {
				t.setRowSelectionInterval(index1 - 1, index2 - 1);
			} catch (IllegalArgumentException ex) {
				t.setRowSelectionInterval(0, 0);

			}
		}
	}

}
