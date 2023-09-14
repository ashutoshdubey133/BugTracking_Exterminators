package in.co.hsbc.bts.dao;

import java.util.Set;

import in.co.hsbc.bts.dao.exception.NoSuchRecordException;
import in.co.hsbc.bts.model.User;

public interface UserDao {
	boolean create(User user);
	User getById(int id);
	boolean update(User user);
	boolean deleteById(int id);
	Set<User> findAll();
	User getByEmail(String email) throws NoSuchRecordException;
}
