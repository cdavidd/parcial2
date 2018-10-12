package edu.eci.pdsw.persistence.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;
import edu.eci.pdsw.persistence.CommentDAO;
import edu.eci.pdsw.persistence.PersistenceException;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.CommentMapper;

public class MyBatisCommentDAO implements CommentDAO {
    @Inject
    CommentMapper commentMapper;
    
    @Override
    public List<Comment> searchCommentsByBlogTitle(String title) throws PersistenceException {
        try {
            return commentMapper.searchCommentsByBlogTitle(title);
        }catch(UnsupportedOperationException e) {
                throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public List<Comment> searchOffensiveLanguageComments() throws PersistenceException {
        return commentMapper.comentariosOfensivos();
    }
}
    