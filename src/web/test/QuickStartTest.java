package web.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import web.annotation.Person;
import web.domain.User;

public class QuickStartTest {
    @Test
    public void testFn(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user =(User) applicationContext.getBean("user");
        //user.setName("张三");
        //user.setAge(4);
        User user2 =(User) applicationContext.getBean("user2");
        //System.out.println(user==user2); false
        User user3 =(User) applicationContext.getBean("user3");

    }
    @Test
    public void testFn2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:web/set_zr/applicationContext.xml");
        User user =(User) applicationContext.getBean("user");
        System.out.println(user);
    }

    @Test
    public void testFn3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:web/set_zr/applicationContext.xml");
        User user =(User) applicationContext.getBean("user2");
        System.out.println(user);
    }

    @Test
    public void testFn5(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Person person = (Person)applicationContext.getBean("person1");
        System.out.println(person);
        applicationContext.close();
    }
}
