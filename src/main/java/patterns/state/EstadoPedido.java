package patterns.state;

import model.Pedido;
//aplicacion del patron state para los estados de pedidos
public interface EstadoPedido {
	
	void avanzar(Pedido pedido);
    void cancelar(Pedido pedido);
    String obtenerNombre();
	
}
