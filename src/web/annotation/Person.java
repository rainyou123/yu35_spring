package web.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.domain.Car;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service(value = "person1")
//@Component  这三个与Service是一样的
//@Repository
//@Controller
@Scope("singleton")
public class Person {
    @Value("大力")
    private String name;
    @Value("101")
    private int no;
//    @Autowired
//    @Qualifier("car1")
    @Resource(name = "car1")
    private Car car;
    @PostConstruct
    public void init(){
        System.out.println("Person初始化方法");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Person销毁方法");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", no=" + no +
                ", car=" + car +
                '}';
    }
}
