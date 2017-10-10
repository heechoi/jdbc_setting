package kr.or.dgit.jdbc_setting.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import kr.or.dgit.jdbc_setting.dao.DatabaseDao;

public class InitService implements DbService {
	private static final InitService instance = new InitService();
	
	
	public static InitService getInstance() {
		return instance;
	}

	private InitService() {}

	//싱글텀 패턴은 자주 사용하는 것만 정의하는 것이 좋다 아니면 시작할때 메모리과부하가 온다
	@Override
	public void service() {
		File f = new File(System.getProperty("user.dir") + "\\resources\\create_sql.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(f));) {
			StringBuilder statement = new StringBuilder();
			for (String line; (line = br.readLine()) != null;) {
				if (!line.isEmpty() && !line.startsWith("--")) {
					statement.append(line.trim()); //sql문장만 넣는것 
				}
				if (line.endsWith(";")) { //sql이 한문장 
				
					DatabaseDao.getInstance().executeUpdateSQL(statement.toString());
					statement.setLength(0); //비우기
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
