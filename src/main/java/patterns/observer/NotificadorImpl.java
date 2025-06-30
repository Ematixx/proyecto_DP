package patterns.observer;

import java.util.ArrayList;
import java.util.List;

import model.Pedido;
//tiene la lista de observadores
public class NotificadorImpl implements Notificador{
	
	private List<NotificacionObserver> observadores = new ArrayList<>();
	//agrega un observador a la lista
	@Override
	public void agregarObservador(NotificacionObserver o) {
		observadores.add(o);
	}
	
	//elimina un observcador de la lista
	@Override
	public void eliminarObservador(NotificacionObserver o) {
		observadores.remove(o);
	}

	//notifica a todos los observadores sobre el nuevo pedido
	@Override
	public void notificar(Pedido pedido) {
		for (NotificacionObserver o : observadores) {
            o.actualizar(pedido);
        }
	}

}
