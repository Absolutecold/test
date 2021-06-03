package com.keji.jdbc;


import java.sql.*;

public class Testjdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url="jdbc:mysql://localhost:3306/jdbc?userSSL=false&serverTimezone=Asia/Shanghai";
        String username="root";
        String passwd="root";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, passwd);
        String sql = "select * from users";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        while(rs.next()){
            System.out.print(rs.getObject("id"));
            System.out.print(rs.getObject("name"));
            System.out.print(rs.getObject("passwd"));
            System.out.print(rs.getObject("email"));
            System.out.print(rs.getObject("birthday"));
            System.out.println();
        }

    }
}
