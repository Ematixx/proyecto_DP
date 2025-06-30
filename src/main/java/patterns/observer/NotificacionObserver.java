package patterns.observer;

import model.Pedido;
//interfaz del patron observer para notificaciones
public interface NotificacionObserver {
	//se ejecutara cuando hay un nuevo pedido
	void actualizar(Pedido pedido);
}
