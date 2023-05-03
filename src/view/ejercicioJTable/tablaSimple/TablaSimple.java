package view.ejercicioJTable.tablaSimple;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import model.Tipologiasexo;
import utils.Apariencia;
import view.ejercicioJTable.DatosDeTabla;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

public class TablaSimple extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */

	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	public TablaSimple() {

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		add(splitPane);

		table = new JTable(DatosDeTabla.getDatosDeTabla(), DatosDeTabla.getTitulosColumnas());
		splitPane.setTopComponent(table);
	

		PanelDatosPersonales pan = new PanelDatosPersonales();
		splitPane.setBottomComponent(pan);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				super.mouseClicked(e);
				int indiceFilaSel = table.getSelectedRow();
				pan.setId((int) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][0]);
				pan.setNombre((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][1]);
				pan.setApellido((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][2]);
				pan.setSegundoApellido((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][3]);
				pan.setDireccion((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][4]);
				pan.setDni((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][5]);
				pan.setEmail((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][6]);
				pan.setTelefono((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][7]);
				pan.setSexo(((Tipologiasexo) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][8]).getId());

			}
		});

	}

}
