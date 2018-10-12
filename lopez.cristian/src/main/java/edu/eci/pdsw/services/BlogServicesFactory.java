package edu.eci.pdsw.services;

import static com.google.inject.Guice.createInjector;

import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Injector;

import edu.eci.pdsw.persistence.BlogDAO;
import edu.eci.pdsw.persistence.CommentDAO;
import edu.eci.pdsw.persistence.UserDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBatisBlogDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBatisCommentDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBatisUserDAO;
import edu.eci.pdsw.services.impl.BlogServicesImpl;

public class BlogServicesFactory {

	private static BlogServicesFactory instance = new BlogServicesFactory();

    private static Optional<Injector> optInjector = Optional.empty();

    private Injector myBatisInjector(String env, String pathResource, JdbcHelper jdbcHelper) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                install(jdbcHelper);
                setClassPathResource(pathResource);
                
                bind(BlogServices.class).to(BlogServicesImpl.class);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(BlogDAO.class).to(MyBatisBlogDAO.class);
                bind(CommentDAO.class).to(MyBatisCommentDAO.class);
            }
        });
    }

    private BlogServicesFactory() {
    }

    public BlogServices getBlogServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml", JdbcHelper.MySQL));
        }

        return optInjector.get().getInstance(BlogServices.class);
    }


    public BlogServices getBlogServicesTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml", JdbcHelper.H2_FILE));
        }

        return optInjector.get().getInstance(BlogServices.class);
    }



    public static BlogServicesFactory getInstance(){
        return instance;
    }

}
