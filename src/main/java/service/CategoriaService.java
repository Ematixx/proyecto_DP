package service;

import java.util.List;

import model.Categoria;

public interface CategoriaService {
	List<Categoria> findAll();
	Categoria findById(int id);
	int save(Categoria t);
	int update(Categoria t);
}
