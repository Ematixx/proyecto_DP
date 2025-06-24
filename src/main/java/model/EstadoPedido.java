package model;

public interface EstadoPedido {
	
	void avanzar(Pedido pedido);
    void cancelar(Pedido pedido);
    String obtenerNombre();
	
}
