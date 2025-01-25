package com.study.toby.domain.user;

import java.sql.*;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)"
        );
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?"
        );
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        c.close();
        ps.close();
        rs.close();

        return user;
    }

    // proteced 로 선언해 서브클래스에서 선택적으로 오버라이드할 수 있게해 확장성을 높일 수 있음 = 훅 메소드
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost/toby", "mkong", "1234"
        );
    }
    // 추상메소드로 선언해 서브클래스에서 반드시 구현하게 해 확장성을 높이면서 기존 코드를 은닉할 수 있음
//    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}

//public class NUserDao extends UserDao {
//    protected Connection getConnection() throws ClassNotFoundException, SQLException{
//        // N사 DB Connection 생성코드
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        return DriverManager.getConnection(
//                "jdbc:mysql://localhost/toby", "mkong", "1234"
//        );
//    }
//}
//
//public class DUserDao extends UserDao {
//    protected Connection getConnection() throws ClassNotFoundException, SQLException{
//        // D사 DB Connection 생성코드
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        return DriverManager.getConnection(
//                "jdbc:mysql://localhost/toby", "mkong", "1234"
//        );
//    }
//}