package patterns.strategy;

public class PagoConTarjeta implements PagosStrategy{

	@Override
	public void pagar(double monto) {
		System.out.println("Pagando S/." + monto + " con tarjeta de credito.");
	}

}
