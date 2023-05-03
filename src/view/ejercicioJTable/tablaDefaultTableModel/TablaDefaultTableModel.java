package view.ejercicioJTable.tablaDefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Tipologiasexo;
import utils.Apariencia;
import view.ejercicioJTable.DatosDeTabla;

public class TablaDefaultTableModel extends JPanel {

	JTable table;
	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();

	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	/**
	 * Create the panel.
	 */
	public TablaDefaultTableModel() {

		this.dtm = getDefaultTableModelNoEditable();

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		add(splitPane);

		table = new JTable(dtm);
		splitPane.setTopComponent(table);

		PanelDatosPersonales2 pan = new PanelDatosPersonales2(dtm, table);
		splitPane.setBottomComponent(pan);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indiceFilaSel = table.getSelectedRow();
				try {
				pan.setId((int) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][0]);
				pan.setNombre((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][1]);
				pan.setApellido((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][2]);
				pan.setSegundoApellido((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][3]);
				pan.setDireccion((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][4]);
				pan.setDni((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][5]);
				pan.setEmail((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][6]);
				pan.setTelefono((String) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][7]);
				pan.setSexo(((Tipologiasexo) DatosDeTabla.getDatosDeTabla()[indiceFilaSel][8]).getId());
				} catch (ArrayIndexOutOfBoundsException ex) {
					
				}
			}
		});

	}

	private DefaultTableModel getDefaultTableModelNoEditable() {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			/**
			 * La sobreescritura de este m�todo nos permite controlar qu� celdas queremos
			 * que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 1) {
					return false;
				}
				return true;
			}
		};
		return dtm;
	}

}
