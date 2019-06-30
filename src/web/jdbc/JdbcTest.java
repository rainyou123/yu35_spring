package web.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTest {
    @Test
    public void testJdbc(){
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();// 如果有C3p0.xml 可以自己匹配C3p0
            //手动配置（没用C3p0的xml）
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql:///yu35_spring");
            dataSource.setUser("root");
            dataSource.setPassword("wangyu");
            JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
            String sql="select * from user";
            List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int i) throws SQLException {
                    User u = new User();
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setEmail(rs.getString("email"));
                    return u;
                }
            });
            for(User u:userList){
                System.out.println(u);
            }
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

    }
}
