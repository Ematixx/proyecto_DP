package patterns.strategy;
//patron strategy para los metodos de pago
//define el comportamiento que tendran las estrategias de envio
import model.Pedido;

public interface EnviosStrategy {
	//ejecuta el proceso de envio
	void enviar(Pedido pedido);
}
