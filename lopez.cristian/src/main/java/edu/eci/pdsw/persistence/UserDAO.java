package edu.eci.pdsw.persistence;

import java.util.List;

import edu.eci.pdsw.entities.User;

public interface UserDAO {
	
    public void save(User user) throws PersistenceException;

	public List<User> loadAll() throws PersistenceException;
	
}
