package com.jds.centroEducativo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jds.centroEducativo.utils.CacheImagenes;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class PruebaClase extends JFrame {

	private JPanel contentPane;
	private JTextField jtfNumero;
	private CacheImagenes cacheImagenes;
	public static BufferedImage iconoApp;

	public static String TITULO_APLICACION = "Numerín";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaClase frame = new PruebaClase();
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
	public PruebaClase() {
		
		
		cacheImagenes = new CacheImagenes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Introduce un \"numerín\".");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Numerín");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weightx = 1.0;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfNumero = new JTextField();
		jtfNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			int numerin = Integer.parseInt(jtfNumero.getText());
				
				if (numerin == 33) {
					String posiblesRespuestas[] = { "SÍ HOMBRE", "NOOOOOO", "PADREADA DE MANUAL" };
					// En esta opción se utiliza un showOptionDialog en el que personalizo el icono
					// mostrado
					int opcionElegida = JOptionPane.showOptionDialog(null, null,
							"DISCULPA QUÉ NUMERÍN HAS DICHO", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
							cacheImagenes.getIcono("alonso.png"), posiblesRespuestas, posiblesRespuestas[1]);
					if (opcionElegida == 0) {
						System.exit(0);

					}
				}
				else if (numerin < 10) {
					
				}
				else {
					 JOptionPane.showConfirmDialog(null, "No me mola el formatín");
				}
			}
		});

		GridBagConstraints gbc_jtfNumero = new GridBagConstraints();
		gbc_jtfNumero.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNumero.gridx = 1;
		gbc_jtfNumero.gridy = 2;
		contentPane.add(jtfNumero, gbc_jtfNumero);
		jtfNumero.setColumns(10);
	}

}
