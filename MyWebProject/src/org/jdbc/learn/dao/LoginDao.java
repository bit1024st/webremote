package org.jdbc.learn.dao;
import java.sql.DriverManager;

import org.jdbc.dao.Login;

import java.sql.*;
public class LoginDao {
	private String url = "jdbc:mysql://localhost:3306/student?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
	private String username = "root";
	private String password = "Sust5l000777@";
	public int login(Login login){
		Connection connection = null;
		PreparedStatement pstate = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
			String sql = "select count(*) from login where uname=? and upass=?";
			pstate = connection.prepareStatement(sql);
			
			pstate.setString(1, login.getName());
			pstate.setString(2,login.getPassword());
			
			rs = pstate.executeQuery();
			int count=-1;
			if(rs.next()) {
				count = rs.getInt(1);
			}
			System.out.println(count);
			return count;
		}catch (ClassNotFoundException e){
            e.printStackTrace();
            return -1;
        }catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }finally
        {
            try{
                if(pstate!=null) pstate.close();
                if(connection!=null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
		
	}
}
