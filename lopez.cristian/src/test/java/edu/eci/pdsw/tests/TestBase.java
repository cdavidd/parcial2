package edu.eci.pdsw.tests;

import org.junit.Before;
import org.mybatis.guice.XMLMyBatisModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.pdsw.persistence.BlogDAO;
import edu.eci.pdsw.persistence.UserDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBatisBlogDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBatisUserDAO;
import edu.eci.pdsw.services.BlogServices;
import edu.eci.pdsw.services.impl.BlogServicesImpl;

public class TestBase {
    protected Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId("test");
                setClassPathResource("mybatis-config-h2.xml");
                
                bind(BlogServices.class).to(BlogServicesImpl.class);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(BlogDAO.class).to(MyBatisBlogDAO.class);
            }
    });
    
    @Before
    public void setup() {
        injector.injectMembers(this);
    }
}
