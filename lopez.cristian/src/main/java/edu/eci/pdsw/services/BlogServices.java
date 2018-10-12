package edu.eci.pdsw.services;


import java.util.List;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;
import edu.eci.pdsw.entities.User;

public interface BlogServices {
	
	/**
     * Crear usuario
     * @return la lista de comentarios
     * @throws ServicesException 
     */
    public void createUser(User user) throws ServicesException;


    /**
     * Consultar todos los usuarios
     * @return la lista de comentarios
     * @throws ServicesException 
     */
    public List<User> listUsers() throws ServicesException;

    /**
     * Consultar todos los comentarios a partir de un título de un blog
     * @return la lista de comentarios
     * @throws ServicesException 
     */
    public List<Blog> listAll() throws ServicesException;

	/**
     * Consultar todos los blogs a partir de un login de usuario
     * @return la lista de comentarios
     * @throws ServicesException 
     */
    public List<Blog> searchByUser(String login) throws ServicesException;

    
    /**
     * Consultar todos los comentarios a partir de un título de un blog
     * @return la lista de comentarios
     * @throws ServicesException 
     */
    public List<Comment> searchCommentsByBlogTitle(String title) throws ServicesException;


    /**
     * Consultar todos los comentarios con lenguaje ofensivo
     * @return la lista de comentarios
     * @throws ServicesException 
     */
    public List<Comment> searchOffensiveLanguageComments() throws ServicesException;
    
    /**
     * Consultar un blog con sus comentarios por el id del blog
     * @return el blog
     * @throws ServicesException 
     */
    public Blog searchBlog(int blogID) throws ServicesException;

}
