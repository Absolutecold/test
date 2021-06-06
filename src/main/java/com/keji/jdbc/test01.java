package com.keji.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.*;

public class test01 {
    @Test
    public void test() {
        String url="jdbc:mysql://localhost:3306/jdbc?userSSL=false&serverTimezone=Asia/Shanghai";
        String username="root";
        String passwd="root";

        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, passwd);

            con.setAutoCommit(false);
            String sql1="update account set money=money-100 where name ='A'";
            con.prepareStatement(sql1).executeUpdate();
//            int o=1/0;
            String sql2="update account set money=money+100 where name ='B'";
            con.prepareStatement(sql2).executeUpdate();
            con.commit();
        } catch (ClassNotFoundException | SQLException e) {
            try {
                con.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}
