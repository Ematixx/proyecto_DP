package patterns.strategy;
//patron strategy para los metodos de pago
//define el comportamiento que tendran las estrategias de pago
public interface PagosStrategy {
	//ejecuta el pago del monto
	void pagar(double monto);
}
