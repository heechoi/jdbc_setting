package kr.or.dgit.jdbc_setting;

import java.sql.Connection;

import kr.or.dgit.jdbc_setting.jdbc.DBCon;
import kr.or.dgit.jdbc_setting.jdbc.JdbcUtil;
import kr.or.dgit.jdbc_setting.service.DbService;
import kr.or.dgit.jdbc_setting.service.ExportService;
import kr.or.dgit.jdbc_setting.service.ImportService;
import kr.or.dgit.jdbc_setting.service.InitService;

public class TestMain {

	public static void main(String[] args) {
		DBCon dbCon = DBCon.getInstance(); 
		//이것을 통해서 DBCon을 생성하는것 하나만 생성하는 방법 싱글텀
		
		Connection connection = dbCon.getConnection();
		System.out.println(connection);
		
		//초기화
		DbService service = InitService.getInstance();
		service.service(); //sql문장만 다 나오는 것을 확인할 수 있다.
		
		
		service = ImportService.getInstance();
		service.service();
		
		service = ExportService.getInstance();
		service.service();
		//close는 한번만 해주는 것이 좋다 모든 작업이 완료된 후에 
		JdbcUtil.close(connection);
	}

}
