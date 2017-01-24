package com.github.exterras.fuzzy02;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.github.exterras.dbconn.MysqlDB;

public class MysqlDBConnSelect {
	
	ResultSet rs;
	MysqlDB mysql;
	
	public MysqlDBConnSelect(String database, String query, boolean alertVisible){
		if (alertVisible) {
			MysqlDB.setDebug();
		}
		mysql = new MysqlDB(database);
		rs = mysql.excuteSelect(query);
		
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				if (i == rsmd.getColumnCount()) {
					System.out.println(rsmd.getColumnName(i));
				} else {
					System.out.print(rsmd.getColumnName(i) + "\t");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet DBSelectRSReturn(){
		return rs;
	}
	
	public MysqlDB DBReturn(){
		return mysql;
	}
}
