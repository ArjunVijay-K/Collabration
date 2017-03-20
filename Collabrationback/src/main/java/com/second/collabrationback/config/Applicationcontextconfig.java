package com.second.collabrationback.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.second.collabrationback.DAO.BlogDAOImpl;
import com.second.collabrationback.DAO.ChatDAOImpl;
import com.second.collabrationback.DAO.CommentDAOImpl;
import com.second.collabrationback.DAO.ForumDAOImpl;
import com.second.collabrationback.DAO.FriendListDAOImpl;
import com.second.collabrationback.DAO.JobsDAOImpl;
import com.second.collabrationback.DAO.UserDAOImpl;
import com.second.collabrationback.Model.Blog;
import com.second.collabrationback.Model.Chat;
import com.second.collabrationback.Model.Comment;
import com.second.collabrationback.Model.Forum;
import com.second.collabrationback.Model.FriendList;
import com.second.collabrationback.Model.Jobs;
import com.second.collabrationback.Model.User;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.second.*")
@EnableTransactionManagement
public class Applicationcontextconfig {

	@Autowired
	@Bean(name = "dataSource")
	public DataSource getH2DataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("collabration");
		dataSource.setPassword("123456789");
		return dataSource;
		} 
	
	private Properties getHibernateProperties(){
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		
		properties.put("hibernate.format_sql","true");
		
		
		return properties;
		}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(Chat.class);
		sessionBuilder.addAnnotatedClass(Comment.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(FriendList.class);
		sessionBuilder.addAnnotatedClass(Jobs.class);
		return sessionBuilder.buildSessionFactory();
		}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
	}
	
	@Autowired(required=true)
	@Bean(name="UserDAO")
	public UserDAOImpl getUserDAOimpl(SessionFactory sessionFactory){
		
		return new UserDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name="blogDAO")
	public BlogDAOImpl getBlogDAOImpl(SessionFactory sessionFactory){
		return new BlogDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name="chat")
	public ChatDAOImpl getChatDAOImpl(SessionFactory sessionFactory){
		return new ChatDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="commentDAO")
	public CommentDAOImpl getCommentDAOImpl(SessionFactory sessionFactory){
		return new CommentDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="forumDAO")
	public ForumDAOImpl getForumDAOImpl(SessionFactory sessionFactory){
		return new ForumDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name="friendlist")
	public FriendListDAOImpl getFriendDAOImpl(SessionFactory sessionFactory){
		return new FriendListDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name="jobs")
	public JobsDAOImpl getJobDAOImpl(SessionFactory sessionFactory){
		return new JobsDAOImpl(sessionFactory);
	}
}
