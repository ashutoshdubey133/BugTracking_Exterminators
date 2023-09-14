package in.co.hsbc.bts.dao;

import java.util.Set;

import in.co.hsbc.bts.model.Bug;

public interface BugDao {
	boolean create(Bug bug);
	Bug getById(int id);
	boolean update(Bug bug);
	boolean deleteById(int id);
	Set<Bug> findAll();
}
