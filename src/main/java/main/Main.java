package main;

import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.ProductoCompuesto;
import model.ProductoSimple;
import patterns.composite.Producto;
import patterns.facade.PedidoFacade;
import patterns.factory.EnvioExpressFactory;
import patterns.factory.MetodoEnvioFactory;
import patterns.factory.MetodoPagoFactory;
import patterns.factory.PagoConTarjetaFactory;
import patterns.observer.EmailNotificacion;
import patterns.observer.Notificador;
import patterns.observer.NotificadorImpl;
import patterns.observer.SMSNotificacion;
import patterns.strategy.EnviosStrategy;
import patterns.strategy.PagosStrategy;
import service.CategoriaService;
import service.CategoriaServiceImpl;
import service.ClienteService;
import service.ClienteServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("---------------------------");
		System.out.println("Sistema de inventario");
		System.out.println("---------------------------");
		
		//instanciamos los servicios
		CategoriaService categoriaService = new CategoriaServiceImpl();
		ClienteService clienteService = new ClienteServiceImpl();
		
		//creamos la categoria
		//Categoria categoriaGamer = new Categoria(0, "Normales");
		//categoriaService.save(categoriaGamer);
		
		//buscamos la categoria, gamer
		Categoria categoriaGamer = categoriaService.findById(1); 
		
		//creamos los productos simples
		Producto simple1 = new ProductoSimple(1, "Teclado", "Teclado Gamer", 50.0, 10, categoriaGamer);
        Producto simple2 = new ProductoSimple(2, "Mouse", "Mouse Gamer", 30.0, 15, categoriaGamer);
		
        //creamos los productos compuestos
        ProductoCompuesto combo = new ProductoCompuesto("Combo PC", 25);
        combo.agregarProducto(simple1);
        combo.agregarProducto(simple2);
        
        //creamos el cliente
        //Cliente cliente = new Cliente(0, "Juan Pérez", "juan@gmail.com");
        //clienteService.save(cliente);
        
        //buscamos al cliente
        Cliente cliente = clienteService.findById(1);
        
        //creamos los items de pedido
        List<ItemPedido> items = new ArrayList<>();
        items.add(new ItemPedido(1, simple1, 1));
        items.add(new ItemPedido(2, combo, 1));
        
        //creamos los observadores
        Notificador notificador = new NotificadorImpl();
        notificador.agregarObservador(new EmailNotificacion());
        notificador.agregarObservador(new SMSNotificacion());
        
        //cremos la instancia del facade
        PedidoFacade pedidoFacade = new PedidoFacade();
        pedidoFacade.setNotificador(notificador);
        
        //creamos el pedido
        Pedido pedido = pedidoFacade.crearPedido(cliente, items);
        
        //aplicamos la estrategia de pago
        MetodoPagoFactory pagoFactory = new PagoConTarjetaFactory();
        PagosStrategy metodoPago = pagoFactory.crearMetodoPago();
        metodoPago.pagar(pedido.getTotal());
        
        //aplicamos la estrategia de envio
        MetodoEnvioFactory envioFactory = new EnvioExpressFactory();
        EnviosStrategy metodoEnvio = envioFactory.crearMetodoEnvio();
        metodoEnvio.enviar(pedido);
        
        //cambiamos estado (state)
        System.out.println("Estado actual: " + pedido.getEstadoPedido().obtenerNombre());
        pedido.getEstadoPedido().avanzar(pedido);
        System.out.println("Nuevo estado: " + pedido.getEstadoPedido().obtenerNombre());
        
	}

}
