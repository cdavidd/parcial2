package edu.eci.pdsw.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import edu.eci.pdsw.entities.*;
import edu.eci.pdsw.services.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "commentBean")
@RequestScoped
public class CommentBean extends BasePageBean {

	@ManagedProperty(value = "#{param.title}")
	private String title;
        
        
	@Inject
	private BlogServices blogServices;

	public List<Comment> getData() throws Exception {
		try {
			if (title == null) {
				return blogServices.searchCommentsByBlogTitle("");
			} else {
                                System.out.println(blogServices.searchCommentsByBlogTitle(title));
				return blogServices.searchCommentsByBlogTitle(title);
			}
		} catch (ServicesException ex) {
			throw  ex;
		}
	}
	
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	

}
	
