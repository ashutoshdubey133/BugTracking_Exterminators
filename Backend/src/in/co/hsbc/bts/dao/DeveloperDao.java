package in.co.hsbc.bts.dao;

import java.util.Set;

import in.co.hsbc.bts.model.Developer;

public interface DeveloperDao {
	boolean create(Developer developer);
	Developer getById(int id);
	boolean update(Developer developer);
	boolean deleteById(int id);
	Set<Developer> findAll();
}
