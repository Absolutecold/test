package com.keji.jdbc;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class test02 {
    private static DataSource ds=null;
    static{
        Properties pts = new Properties();
        InputStream is = new test02().getClass().getClassLoader().getResourceAsStream("E:\\JavaWeb\\Javaweb-jdbc\\src\\main\\resources\\dbconfig.properties");
        try {
            pts.load(is);
            ds = BasicDataSourceFactory.createDataSource(pts);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
