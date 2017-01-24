package com.github.exterras.fuzzy02;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.github.exterras.dbconn.MysqlDB;

public class FuzzyMain {
	public static void main(String[] args) {
		// fuzzy calculation (fuzzyDAO) object created
		FuzzyDAO dao = new FuzzyDAO(); 
		
		// doFuzzy(High Standard Height = int, Average Rate (0.0~1.0) = double)
		dao.doFuzzy(180, 0.5);
		
		// db connection pool, select database fuzzy01, table height, in mysql 
//		MysqlDBConnSelect db = new MysqlDBConnSelect("fuzzy01", "select * from height", false);
//		
//		ResultSet rs = db.DBSelectRSReturn();
//		MysqlDB sql = db.DBReturn();
//		try {
//			while (rs.next()) {
//				String name = rs.getString(1);
//				String height = rs.getString(2);
//				System.out.println(name + "\t" + height);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			sql.close(rs);
//		}
	}
}
