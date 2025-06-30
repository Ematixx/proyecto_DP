package patterns.observer;

import model.Pedido;
//implemente la interfaz NotificacionObserver y define un comportamiento especifico
//al recibir una actualizacion del notificador
public class ConsolaNotificacion implements NotificacionObserver{

	@Override
	public void actualizar(Pedido pedido) {
		System.out.println("Notificación por consola: Pedido de S/," + pedido.getTotal());
	}

}
