package com.joah.everyday.N20191110;

import com.joah.everyday.N20191110.factory.PizzaStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;

/**
 * http://www.iocoder.cn/DesignPattern/xiaomingge/Simple-Factory-Pattern/
 *
 *  Factory：工厂角色。专门用于创建实例类的工厂，提供一个方法，该方法根据传递的参数不同返回不同类的具体实例。
 * ​Product：抽象产品角色。为所有产品的父类。
 * ​ConcreteProduct：具体的产品角色。
 * ​简单工厂模式将对象的创建和对象本身业务处理分离了，可以降低系统的耦合度，
 *  使得两者修改起来都相对容易些。当以后实现改变时，只需要修改工厂类即可
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class Factory {

    public static void main(String[] args) {
        SpringApplication.run(Factory.class,args);
    }

    @Autowired
    PizzaStore pizzaStore;

    @PostConstruct
    public void test(){
        pizzaStore.orderPizza("pepperoni");
    }
}
