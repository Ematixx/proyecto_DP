package repository;

import java.util.List;

public interface GenericRepository<T> {
	
	List<T> findAll();
    T findById(int id);
    int save(T t);
    int update(T t);
	
}
