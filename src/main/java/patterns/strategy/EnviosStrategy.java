package patterns.strategy;

import model.Pedido;

public interface EnviosStrategy {
	void enviar(Pedido pedido);
}
