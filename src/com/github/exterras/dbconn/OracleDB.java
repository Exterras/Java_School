package com.github.exterras.dbconn;

public class OracleDB extends DBConn{
	public OracleDB(){
		super("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:xe","hr","happyday");
	}
	
	public OracleDB(String _id, String _password){
		super("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:xe",_id, _password);
	}
}
