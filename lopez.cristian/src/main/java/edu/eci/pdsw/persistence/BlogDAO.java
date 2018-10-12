/*
 * Copyright (C) 2018 fchaves, salzate
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.persistence;

import java.util.List;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;

/**
 *
 * @author fchaves
 * @author salzate
 */
public interface BlogDAO {
 
    public List<Blog> loadAll() throws PersistenceException;
    
    public void save(Blog b) throws PersistenceException;
    
    public void update(Blog b) throws PersistenceException;
    
    public void addComment(int blogId, Comment comment) throws PersistenceException;
    
    public Blog load(int blogID) throws PersistenceException;

    public Blog load(String title) throws PersistenceException;

    public List<Blog> loadByUser(String login) throws PersistenceException;
}
