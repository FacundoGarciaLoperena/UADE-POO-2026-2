package modelo;

import java.util.HashSet;
import java.util.Set;

public class GestionPagos {
	private Set<Pago> pagos;

	public GestionPagos() {
		this.pagos = new HashSet<>();
	}

	public void crearPago(Pago pago) {
		pagos.add(pago);
	}

	public Pago buscarPago(int idPago) {
		for (Pago p : pagos) {
			if (p.getIdPago() == idPago)
				return p;
		}
		return null;
	}

	public void actualizarPago(Pago pago) {
		eliminarPago(pago.getIdPago());
		pagos.add(pago);
	}

	public void eliminarPago(int idPago) {
		Pago p = buscarPago(idPago);
		if (p != null)
			pagos.remove(p);
	}

	public Set<Pago> getPagos() {
		return pagos;
	}
}
