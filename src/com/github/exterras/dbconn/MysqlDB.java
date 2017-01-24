package com.github.exterras.dbconn;

public class MysqlDB extends DBConn{

	public MysqlDB(String database){
		super("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/"+database+"?useSSL=false",
				"root","frostgenius");
	}
	
	public MysqlDB(String database, String _id, String _password){
		super("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/"+database+"?useSSL=false",
				_id, _password);
	}
}
