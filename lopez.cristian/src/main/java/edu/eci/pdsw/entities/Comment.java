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

/**
 *
 * @author hcadavid
 */
public class Comment {
    //el identificador es asignado por la base de datos,
    //por eso no se incluye en el constructor.
    private int id;
    private Date creationDate;
    private User author;
    private String content;
    
    
    public Comment(Date creationDate, User author, String content) {
		super();
		this.id = -1;
		this.creationDate = creationDate;
		this.author = author;
		this.content = content;
	}
    
        public Comment(){
            
        }

    

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	public User getAuthor() {
		return author;
	}



	public void setAuthor(User author) {
		this.author = author;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	@Override
    public String toString() {
        return "Comment { id: "+id+", author: "+author+", creationDate: "+creationDate+", content: "+content+" }";
    }
    
    
}
