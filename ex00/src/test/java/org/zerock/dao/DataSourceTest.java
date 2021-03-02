package org.zerock.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTest {

	
	//자동 DI선언 - root-context.xml에 bean으로 선언되어있음  
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;

	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMybatis() {
		log.info("=====Mybatis Connection 테스트 ============= ");

		try(SqlSession session = sqlSessionFactory.openSession();
				Connection con = session.getConnection()) {
			
			//try 조건문에 두줄 이상 쓸수있다 ,세미콜론으로 ㅇㅇ ,  즉 session도 선언하고 con도 선언하고 ,,
			log.info(session);
			log.info(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	
	
	
	@Test
	public void testConnection() {
		log.info("=====DataSource Connection 테스트 ============= ");

		try(Connection con = dataSource.getConnection()) {
			log.info(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	
	
	
}
