package interfaz.componentes;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import interfaz.config.Estilos;

//JTable de solo lectura con el estilo del sistema, la columna de estado se pinta de color
public class TablaDatos extends JTable {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo;

	public TablaDatos(String[] columnas, int columnaEstado) {
		modelo = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};
		setModel(modelo);
		setFont(Estilos.FUENTE_NORMAL);
		setRowHeight(26);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setSelectionBackground(Estilos.AZUL_CLARO);
		setSelectionForeground(Estilos.TEXTO);
		setGridColor(Estilos.BORDE);
		setAutoCreateRowSorter(true);
		getTableHeader().setFont(Estilos.FUENTE_NORMAL.deriveFont(java.awt.Font.BOLD));
		getTableHeader().setReorderingAllowed(false);

		if (columnaEstado >= 0) {
			getColumnModel().getColumn(columnaEstado).setCellRenderer(new DefaultTableCellRenderer() {
				private static final long serialVersionUID = 1L;

				@Override
				public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean seleccionada,
						boolean foco, int fila, int columna) {
					Component c = super.getTableCellRendererComponent(tabla, valor, seleccionada, foco, fila, columna);
					String estado = String.valueOf(valor);
					if (estado.equals("ACTIVO")) c.setForeground(Estilos.VERDE);
					else if (estado.equals("SUSPENDIDO")) c.setForeground(Estilos.ROJO);
					else c.setForeground(Estilos.TEXTO_SECUNDARIO);
					return c;
				}
			});
		}
	}

	public void limpiar() {
		modelo.setRowCount(0);
	}

	public void agregarFila(Object[] fila) {
		modelo.addRow(fila);
	}

	//Devuelve el valor de la primera columna (la clave) de la fila seleccionada, o null
	public Object getClaveSeleccionada() {
		int fila = getSelectedRow();
		if (fila == -1) {
			return null;
		}
		return modelo.getValueAt(convertRowIndexToModel(fila), 0);
	}
}
