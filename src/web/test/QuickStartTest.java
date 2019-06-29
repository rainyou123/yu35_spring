package web.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import web.domain.User;

public class QuickStartTest {
    @Test
    public void testFn(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user =(User) applicationContext.getBean("user");
        user.setName("张三");
        user.setAge(4);
        System.out.println(user);
    }
}
