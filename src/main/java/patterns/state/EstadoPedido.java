package patterns.state;

import model.Pedido;

public interface EstadoPedido {
	
	void avanzar(Pedido pedido);
    void cancelar(Pedido pedido);
    String obtenerNombre();
	
}
