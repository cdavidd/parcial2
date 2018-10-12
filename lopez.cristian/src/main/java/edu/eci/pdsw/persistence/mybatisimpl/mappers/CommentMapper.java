package edu.eci.pdsw.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;
import edu.eci.pdsw.persistence.PersistenceException;


public interface CommentMapper {
	List<Comment> searchCommentsByBlogTitle (@Param("title") String title);
	List<Comment> comentariosOfensivos();
}