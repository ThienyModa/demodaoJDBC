package model.Dao;

import java.util.List;

import model.entities.Departament;

public interface DepartmentDao {
	
	void insert(Departament obj);
	void update(Departament obj);
	void deleteById(Integer id);
	Departament findById(Integer id);
	List<Departament> findAll();

}
