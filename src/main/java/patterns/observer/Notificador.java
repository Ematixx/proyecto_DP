package patterns.observer;

import model.Pedido;

public interface Notificador {
	
	void agregarObservador(NotificacionObserver o);
	void eliminarObservador(NotificacionObserver o);
	void notificar(Pedido pedido);
	
}
