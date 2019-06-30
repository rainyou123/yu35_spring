package web.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import web.proxy.UserService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:web/aop/applicationContext.xml")

public class TestAop {
    @Resource(name = "userService")
    private UserService userService;
    //这不能用UserServiceImpl
    //原因：（默认先调用动态代理 因为动态代理的接口）
    //动态代理 加强封装后与原来的代理类 类似兄弟关系（可以说毫无关系）
    //cg代理 加强封装后与原来的代理类 继承关系（父子关系）
    //一般优先选择动态代理
    //可以在配置文件中加注解 先调用cg代理 就可以使用 UserServiceImpl
    @Test
    public void testFn(){
        userService.updateUser();
        System.out.println();
        userService.addUser();
        //结果中会有 Person初始化方法 Person销毁方法 因为Person中有注解
        // aop/xml中写了扫描web包  <context:component-scan base-package="web"/>
        //会扫描所有带注解的 Person有注解会生成一个bean 就会执行他的初始化方法和销毁方法
    }

}
