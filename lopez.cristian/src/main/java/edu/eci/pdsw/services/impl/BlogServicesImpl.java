/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.services.impl;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;
import edu.eci.pdsw.entities.User;
import edu.eci.pdsw.persistence.BlogDAO;
import edu.eci.pdsw.persistence.CommentDAO;
import edu.eci.pdsw.persistence.PersistenceException;
import edu.eci.pdsw.persistence.UserDAO;
import edu.eci.pdsw.services.ServicesException;
import edu.eci.pdsw.services.BlogServices;
import java.util.List;

/**
 *
 * @author fchaves
 * @author salzate
 */
public class BlogServicesImpl implements BlogServices {

	@Override
	public void createUser(User user) throws ServicesException {
		 try {
			userDAO.save(user);
		} catch (PersistenceException ex) {
			throw new ServicesException("Create user error:"+ex.getLocalizedMessage(), ex);
		}		
	}

	@Inject
	private BlogDAO blogDAO;
	
	@Inject
	private UserDAO userDAO;
        
        @Inject
        private CommentDAO commentDAO;

    @Override
	public List<User> listUsers() throws ServicesException {
		try {
            return userDAO.loadAll();
        } catch (PersistenceException ex) {
            throw new ServicesException("Load users error:"+ex.getLocalizedMessage(), ex);
        }
	}

	@Override
	public List<Blog> listAll() throws ServicesException {
    	throw new UnsupportedOperationException("Not supported yet.");
	}

    @Override
    public List<Blog> searchByUser(String login) throws ServicesException {
    	try {
			return blogDAO.loadByUser(login);
		} catch (PersistenceException ex) {
            throw new ServicesException("Search error:"+ex.getLocalizedMessage(), ex);
		}
    }

	@Override
	public List<Comment> searchCommentsByBlogTitle(String title) throws ServicesException {
            try{
                System.out.println(commentDAO.searchCommentsByBlogTitle(title));
                return commentDAO.searchCommentsByBlogTitle(title);
            }catch(PersistenceException ex){
                throw new UnsupportedOperationException("Search error"+ex.getLocalizedMessage(),ex);
            }
		
	}

	@Override
	public List<Comment> searchOffensiveLanguageComments() throws ServicesException {
            try{
                return commentDAO.searchOffensiveLanguageComments();
            }catch(PersistenceException ex){
                throw new UnsupportedOperationException("Search error"+ex.getLocalizedMessage(),ex);
            }
	}

	@Override
	public Blog searchBlog(int blogID) throws ServicesException {
		try {
            return blogDAO.load(blogID);
        } catch (PersistenceException ex) {
            throw new ServicesException("Search error:"+ex.getLocalizedMessage(), ex);
        }
	}
   
}