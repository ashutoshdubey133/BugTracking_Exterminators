package in.co.hsbc.bts.dao;

import in.co.hsbc.bts.model.Tester;

public interface TesterDao {
	boolean create(Tester tester);
	Tester getById(int id);
	boolean update(Tester tester);
	boolean deleteById(int id);
}
