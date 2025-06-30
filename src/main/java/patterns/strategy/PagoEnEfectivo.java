package patterns.strategy;
//tipo de pago
public class PagoEnEfectivo implements PagosStrategy{

	@Override
	public void pagar(double monto) {
		System.out.println("Pagando S/." + monto + " con efectivo.");
	}

}
