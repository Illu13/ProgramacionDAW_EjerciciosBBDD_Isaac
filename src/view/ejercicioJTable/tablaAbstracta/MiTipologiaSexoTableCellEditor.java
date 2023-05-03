package view.ejercicioJTable.tablaAbstracta;

import java.awt.Component;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;

import controller.ControladorSexo;
import model.Tipologiasexo;


public class MiTipologiaSexoTableCellEditor extends DefaultCellEditor {

	// Utilizaremos este puntero para hacer referencia al control mostrado en la tabla
	private JComboBox<Tipologiasexo> jcbSexo = null;
	
	/**
	 * 
	 */
	public MiTipologiaSexoTableCellEditor() {
		super(new JComboBox<Tipologiasexo>());
		
		// La celda se comenzar� a editar tras 2 clics
		setClickCountToStart(2);
		// Inicializaci�n del componente
		jcbSexo = (JComboBox<Tipologiasexo>) getComponent();
	}

	/**
	 * En este m�todo construimos el componente que el usuario ver� cuando haga clic sobre la celda en concreto
	 */
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		JComboBox<Tipologiasexo> jcbProvincias = (JComboBox<Tipologiasexo>) super.getTableCellEditorComponent(table, value, isSelected, row, column);

		// Si los hubiera, elimino los items actuales.
		jcbProvincias.removeAllItems();
		
		// Inicializo los elementos del combobox a todas las tipologías sexo disponibles y selecciono la correcta
		List<Tipologiasexo> sexos = ControladorSexo.findAll();
		for (Tipologiasexo sexo : sexos) {
			jcbProvincias.addItem(sexo);
			if (value != null && value instanceof Tipologiasexo) {
				Tipologiasexo provinciaValue = (Tipologiasexo) value;
				if (provinciaValue.getId() == sexo.getId()) {
					jcbProvincias.setSelectedItem(sexo);
				}
			}
		}
		
		return jcbProvincias;
	}

	/**
	 * Devuelvo el objeto de tipo Provincia seleccionado por el usuario
	 */
	public Object getCellEditorValue() {
		return (Tipologiasexo) jcbSexo.getSelectedItem();
	}

}
