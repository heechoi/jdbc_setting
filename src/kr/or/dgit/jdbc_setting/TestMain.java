package kr.or.dgit.jdbc_setting;

import kr.or.dgit.jdbc_setting.jdbc.DBCon;

public class TestMain {

	public static void main(String[] args) {
		DBCon.getInstance(); //이것을 통해서 DBCon을 생성하는것 하나만 생성하는 방법 싱글텀
	}

}
