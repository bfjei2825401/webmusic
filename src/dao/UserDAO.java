package dao;

import db.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by baofeng on 2017/4/20.
 */
public class UserDAO {

    public boolean login(String username, String password) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        boolean isLogin = false;
        String sql = "SELECT count(*) FROM user WHERE username=? AND password=?";
        connection = DbUtil.getConnection();
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        rs = stmt.executeQuery();
        while (rs.next()) {
            if (rs.getInt(1) > 0) {
                isLogin = true;
            }
        }
        DbUtil.close(rs);
        return isLogin;
    }

    public boolean register(String username, String password) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        Connection connection = null;
        boolean canRegister = false;
        String sql = "INSERT INTO user(username, password) VALUES(?,?)";
        connection = DbUtil.getConnection();
        stmt = connection.prepareStatement(sql);
        stmt.setString(1,username);
        stmt.setString(2,password);
        canRegister = stmt.execute();
        DbUtil.close(stmt);
        return canRegister;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.login("leelddd", "123456"));
    }
}
