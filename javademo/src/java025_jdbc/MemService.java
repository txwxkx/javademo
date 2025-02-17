package java025_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MemService {
	MemDAO dao = null;
	
	public MemService() {
		dao = MemDAO.getInstance();

	}

	public List<MemDTO> getMemList() {
			Connection conn = JdbcTemplate.getConnection();
			
			List<MemDTO> aList = null;
			try {
				conn.setAutoCommit(false);
				aList = dao.getListMethod(conn);
				JdbcTemplate.commit(conn);
			} catch (SQLException e) {
				e.printStackTrace();
				JdbcTemplate.rollback(conn);
			} finally {
				JdbcTemplate.close(conn);
			}
			
		return aList;
			
	}
	
	public int getInsert(MemDTO dto) {
		int chk = 0;
		
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			conn.setAutoCommit(false);
			chk = dao.insertMethod(conn, dto);
			JdbcTemplate.commit(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		} finally {
			JdbcTemplate.close(conn);
		}
				
		return chk;
	}
	
}
