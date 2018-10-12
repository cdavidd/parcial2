/*
 * Copyright (C) 2015 hcadavid
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
package edu.eci.pdsw.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public class Blog {
    
    private int id;
    private User author;
    private String title;
    private Date creationDate;
    List<Comment> comments;
    
    //el identificador es asignado por la base de datos,
    //por eso no se incluye en el constructor.
    public Blog(User author, String title, Date creationDate, List<Comment> comments) {
		super();
		this.id = -1;
		this.author = author;
		this.title = title;
		this.creationDate = creationDate;
		this.comments = comments;
	}

    public Blog() {
    	this.comments = new ArrayList<>();
    }
   
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	@Override
    public String toString() {
        StringBuffer rep = new StringBuffer("Blog: { id:"+id+", author: "+author+", title: "+title+", creationDate: "+creationDate+", comments : [\n");
        for (Comment comment:comments){
            rep.append(comment+"\n");
        }
        rep.append("]");
        return rep.toString();
    }
    
    
    
}
