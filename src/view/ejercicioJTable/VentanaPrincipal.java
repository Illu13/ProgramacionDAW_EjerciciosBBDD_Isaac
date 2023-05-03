package view.ejercicioJTable;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import view.ejercicioJTable.tablaAbstracta.TablaAbstractTableModel;
import view.ejercicioJTable.tablaDefaultTableModel.TablaDefaultTableModel;
import view.ejercicioJTable.tablaSimple.TablaSimple;



public class VentanaPrincipal extends JFrame {


	/**
	 * 
	 */
	public VentanaPrincipal() {
		super("Ejemplos de JTable");
		this.setBounds(0, 0, 700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// Establezco el panel principal de la aplicaci�n y la barra de herramientas
		this.setLayout(new BorderLayout());
		this.add(getTabbedPane(), BorderLayout.CENTER);
	}

	/**
	 * 
	 * @return
	 */
	private JTabbedPane getTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.add("JTable1", new TablaSimple());
		tabbedPane.add("JTable con DefaultTableModel", new TablaDefaultTableModel());
		tabbedPane.add("JTable con AbstractTableModel", new TablaAbstractTableModel());

		return tabbedPane;
	}

}
