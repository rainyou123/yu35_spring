package web.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:web/jdbc/applicationContext.xml")
public class JdbcTest {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jt;
    @Test
    public void testJdbc2(){
        String sql = "insert into user values (null , ? , ?)";
        jt.update(sql,"haha","haha@163.com");

    }

    @Test
    public void testJdbc3(){
        String sql = "update user set username = ? where id = ?";
        jt.update(sql , "吴亦凡", 4);
    }

    @Test
    public void testJdbc() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();// 如果有C3p0.xml 可以自己匹配C3p0
        //手动配置（没用C3p0的xml）
//            dataSource.setDriverClass("com.mysql.jdbc.Driver");
//            dataSource.setJdbcUrl("jdbc:mysql:///yu35_spring");
//            dataSource.setUser("root");
//            dataSource.setPassword("wangyu");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);//c3p0Utils有没有都行 用不上
        //将c3p0隐藏（放在除src根目录下的地方 在app  .xml文件中配置）
        String sql = "select * from user";
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
        for (User u : userList) {
            System.out.println(u);
        }

    }
}
