package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private int cnt;
	private String sql;

	// DB 연결
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DB 연결 종료
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 회원 가입
	public int memberJoin(MemberDTO memberDTO) {

		connect();
		
		// id, pw, nick, phone, birth, sex 순으로 입력
		sql = "insert into member values(?,?,?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, memberDTO.getId());
			psmt.setString(2, memberDTO.getPw());
			psmt.setString(3, memberDTO.getNick());
			psmt.setString(4, memberDTO.getPhone());
			psmt.setString(5, memberDTO.getBirthday());
			psmt.setInt(6, memberDTO.getSex());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close();
		}
		
		return cnt;
	}

	public MemberDTO memberLogin(String id, String pw) {
		
		connect();
		
		MemberDTO member = null;
		sql = "select * from member where id = ? and pw = ? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			
			if (rs.next()) {
				member = new MemberDTO(id, pw, rs.getString("nick"), rs.getString("phone"), rs.getString("birth"), rs.getInt("sex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return member;
	}

	public int update(MemberDTO memberDTO) {
		

		connect();

		sql = "update member set pw=?, nick=?, phone=? where id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(4, memberDTO.getId());
			psmt.setString(1, memberDTO.getPw());
			psmt.setString(2, memberDTO.getNick());
			psmt.setString(3, memberDTO.getPhone());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return cnt;
	}
}