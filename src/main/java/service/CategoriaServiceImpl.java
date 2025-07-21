package service;

import java.util.List;

import model.Categoria;
import repository.CategoriaRepository;

public class CategoriaServiceImpl implements CategoriaService{
	
	private final CategoriaRepository categoriaRepository;
	
	public CategoriaServiceImpl() {
        this.categoriaRepository = new CategoriaRepository();
    }

	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria findById(int id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public int save(Categoria t) {
		return categoriaRepository.save(t);
	}

	@Override
	public int update(Categoria t) {
		return categoriaRepository.update(t);
	}

}
