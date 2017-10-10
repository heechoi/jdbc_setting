package kr.or.dgit.jdbc_setting;

import java.sql.Connection;

import kr.or.dgit.jdbc_setting.jdbc.DBCon;
import kr.or.dgit.jdbc_setting.jdbc.JdbcUtil;

public class TestMain {

	public static void main(String[] args) {
		DBCon dbCon = DBCon.getInstance(); 
		//이것을 통해서 DBCon을 생성하는것 하나만 생성하는 방법 싱글텀
		
		Connection connection = dbCon.getConnection();
		System.out.println(connection);
		
		
		
		//close는 한번만 해주는 것이 좋다 모든 작업이 완료된 후에 
		JdbcUtil.close(connection);
	}

}
