package com.github.exterras.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	private String driver; // JDBC 드라이버
	private String url;// DB URL
	private String id;// DB 아이디
	private String password; // 디비 패스워드
	private static boolean isDebug = false;

	private Connection conn = null;
	private PreparedStatement ps = null;
	private Statement stmt = null;

	public DBConn(String driver, String url, String id, String password) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.password = password;
		connection();
	}

	static public void setDebug() {
		isDebug = true;
	}

	// 데이터 베이스 연결
	private void connection() {
		try {
			Class.forName(driver);
			if (isDebug) {
				System.out.println("jdbc 드라이버 로드 성공 ");
			}

			conn = DriverManager.getConnection(url, id, password);
			if (isDebug) {
				System.out.println("DB 연결 성공");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc 드라이버 로드 실패");
			if (isDebug) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("DB 연결 성공실패 데이터 베이스 URL 또는 아이디 비밀번호를 확인해주세요!");
			if (isDebug) {
				e.printStackTrace();
			}
		}
	}

	// insert update delete create drop alter 에 사용
	public int excuteIUD(String query, String[] arrPrepare) {
		int resultCount = 0;
		try {
			if (!conn.isClosed()) {
				ps = conn.prepareStatement(query);

				int i = 1;
				for (String val : arrPrepare) {
					if (val != null) {
						ps.setString(i, val);
						i++;
					}
				}

				resultCount = ps.executeUpdate();

				if (isDebug) {
					System.out.println(resultCount + "개의 쿼리 반영");
				}
			} else {
				if (isDebug) {
					System.out.println("연결 종료된 디비 접속 시도");
				}
			}
		} catch (SQLException e) {
			System.out.println("excuteIUD 쿼리문 에러");
			if (isDebug) {
				System.out.println(query);
				int i = 1;
				for (String val : arrPrepare) {
					if (i > 1) {
						System.out.print(", ");
					}
					System.out.print(i + ":" + val);
					i++;
				}
				System.out.println();
				e.printStackTrace();
			}
		}

		return resultCount;
	}

	// select 에 사용
	public ResultSet excuteSelect(String query, String[] arrPrepare) {
		ResultSet rs = null;

		try {
			if (!conn.isClosed()) {
				ps = conn.prepareStatement(query);

				int i = 1;
				for (String val : arrPrepare) {
					if (val != null) {
						ps.setString(i, val);
						i++;
					}
				}

				rs = ps.executeQuery();

				if (isDebug) {
					System.out.println("select 성공");
				}
			} else {
				close();
				if (isDebug)
					System.out.println("연결 종료된 디비 접속 시도");
			}
		} catch (SQLException e) {
			System.out.println("excuteSelect 쿼리문 에러");
			if (isDebug) {
				System.out.println(query);
				int i = 1;
				for (String val : arrPrepare) {
					if (i > 1) {
						System.out.print(", ");
					}
					System.out.print(i + ":" + val);
					i++;
				}
				e.printStackTrace();
			}
		}

		return rs;
	}

	// insert update delete create drop alter 에 사용
	public int excuteIUD(String query) {
		int resultCount = 0;
		try {
			if (!conn.isClosed()) {
				stmt = conn.createStatement();
				resultCount = stmt.executeUpdate(query);
				if (isDebug) {
					System.out.println(resultCount + "개의 쿼리 반영");
				}
			} else {
				if (isDebug) {
					System.out.println("연결 종료된 디비 접속 시도");
				}
			}
		} catch (SQLException e) {
			System.out.println("excuteIUD 쿼리문 에러");
			if (isDebug) {
				System.out.println(query);
				e.printStackTrace();
			}
		}

		return resultCount;
	}

	// select 에 사용
	public ResultSet excuteSelect(String query) {
		ResultSet rs = null;

		try {
			if (!conn.isClosed()) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				if (isDebug) {
					System.out.println("select 성공");
				}
				
			} else {
				close();
				if (isDebug)
					System.out.println("연결 종료된 디비 접속 시도");
			}
		} catch (SQLException e) {
			System.out.println("excuteSelect 쿼리문 에러");
			if (isDebug) {
				System.out.println(query);
				e.printStackTrace();
			}
		}

		return rs;
	}

	// 디비 연결 종료
	public void close() {
		close(null);
	}

	// ResultSet을 포함한 디비연결 종료
	public void close(ResultSet rs) {
		try {
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
			if (stmt != null)
				stmt.close();

			if (rs != null)
				rs.close();
			if (isDebug) {
				System.out.println("DB 연결 종료");
			}
		} catch (SQLException e) {
			if (isDebug) {
				e.printStackTrace();
			}
		}
	}
}
