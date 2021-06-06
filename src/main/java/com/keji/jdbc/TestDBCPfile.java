package com.keji.jdbc;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class TestDBCPfile {
    private static DataSource ds=null;
    static{
        try {
            Properties pro = new Properties();
            InputStream is = new TestDBCPfile().getClass().getClassLoader()
                    .getResourceAsStream("src\\main\\resources\\dbconfig.properties");
            pro.load(is);
            ds= BasicDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Connection con = ds.getConnection();
            System.out.println(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
