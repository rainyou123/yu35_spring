package web.domain;

public class UserFactory {
    //静态工厂创建
    public static User createUser(){
        return new User();
    }
    /**
     * 实例工厂创建
     */
    public User createUser2(){
        return new User();
    }

}
