package web.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class C3P0Utils {
    private static ComboPooledDataSource dataSource;
    static {
        dataSource=new ComboPooledDataSource();
    }
//    获取数据源
    public static DataSource getDataSource(){
        return dataSource;
    }
//    获取连接
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void releaseRes(Connection conn, Statement st, ResultSet rt){
        if(null!=conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=st){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=rt){
            try {
                rt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
