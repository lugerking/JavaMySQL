package com.mysql;


public class MySQLTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)   {
		
		User baobao = new User(4);
		baobao.setCity("tianjin");
		
		//User niuniu = new User(6, "niuniu", "niuniu");
		//niuniu.setCity("anhui");
		
		User.selectAllTable();
		
        //xiaoming.deleteFromTable();
	}

}