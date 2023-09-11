package in.co.hsbc.bts.dao;

import in.co.hsbc.bts.model.Team;

public interface TeamDao {
	boolean create(Team team);
	Team getById(int id);
	boolean update(Team team);
	boolean deleteById(int id);
}
