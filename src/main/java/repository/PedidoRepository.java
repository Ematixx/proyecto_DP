package repository;

import java.util.List;

import model.Pedido;

public interface PedidoRepository {
	List<Pedido> findAll();
    Pedido findById(int id);
    int save(Pedido pedido);
}
