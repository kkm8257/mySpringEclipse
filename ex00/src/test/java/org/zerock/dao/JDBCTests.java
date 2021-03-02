package org.zerock.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import lombok.extern.log4j.Log4j;



//log라는 변수를 사용 할 수 있게 하는것 . lombok 설정이 제대로 되어있어야한다.
@Log4j
public class JDBCTests {

	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //인자로 받은것이 바로 메모리로 로드 되는 것 . Class.forName
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testExist() {
		log.info("=====JDBC 테스트 ======= ");
		
		//연결
		//try(자원 선언)  -> 선언된 자원은 try 블록을 빠져 나갈 때 , 자동 반
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kyungmin","1234")) {
			
			log.info(con);
			
			
			//실제로는 이렇게 직접 연결하지않고 커넥션 풀을 만들어서 이용//주로 히카리 커넥션풀을 많이 쓴다고한다.
			
			
			
		} catch (Exception e) {
			//간단하게 메시지만 볼때는 fail을 써보는 것도 좋음
			e.printStackTrace();
		}
		
	
	}
	
	
	
}