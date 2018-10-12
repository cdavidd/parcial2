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
package edu.eci.pdsw.tests;

import edu.eci.pdsw.entities.User;
import edu.eci.pdsw.services.BlogServices;
import edu.eci.pdsw.services.ServicesException;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import static org.quicktheories.QuickTheory.qt;

import com.google.inject.Inject;


/**
 *
 * @author hcadavid
 * @author fchaves
 */
public class BlogServicesTest extends TestBase {

    @Inject
    private BlogServices blogServices;
    
    @Test
    public void pruebaCeroTest() throws SQLException, ServicesException {
        qt().forAll(Generators.users())
            .check((user) -> {  
                try {
                    blogServices.createUser(user);
                    
                    List<User> allUsers = blogServices.listUsers();
                    
                    boolean result = false;
                    for (User otherUser : allUsers) {
                        if (user.getLogin() == otherUser.getLogin()) {
                            result = true;
                            break;
                        }
                    }
                    
                    return allUsers.size() > 0 && result;
                } 
                catch(ServicesException ex) {
                    ex.printStackTrace();
                    return false;
                }
                
            });
    }    
}