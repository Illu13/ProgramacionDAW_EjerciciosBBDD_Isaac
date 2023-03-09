package com.jds.centroEducativo.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class VentanaPrincipal extends JFrame {

	/**
	 * Create the panel.
	 */
	public VentanaPrincipal () {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 578, 375);


		
		JTabbedPane tabedPane = new JTabbedPane();
		
		tabedPane.add("Cursos", new VistaCurso());
		
		tabedPane.add("Profesor", new VistaProfesor());
		
		tabedPane.add("Estudiante", new VistaEstudiante());
		
		tabedPane.add("Materias", new VistaMateria());
		
		tabedPane.add("Valoración", new VistaValoracion());
		
		this.setContentPane(tabedPane);
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}
}
