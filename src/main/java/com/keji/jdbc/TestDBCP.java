package com.keji.jdbc;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDBCP {
    private static DataSource ds=null;
    static {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/jdbc?userSSL=false&serverTimezone=Asia/Shanghai");
        bds.setUsername("root");
        bds.setPassword("root");
        bds.setInitialSize(5);
        bds.setMaxActive(20);
        ds=bds;
    }

    public static void main(String[] args) throws SQLException {
        Connection con = ds.getConnection();
        String sql = "select * from users";
        PreparedStatement prs = con.prepareStatement(sql);
        ResultSet rs = prs.executeQuery();
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

