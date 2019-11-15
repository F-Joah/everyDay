package com.joah.everyday.N20191115.singLeton;

/**
 *  应用场景
 *
 *  系统只需要一个实例对象，如系统要求提供一个唯一的序列号生成器，或者需要考虑资源消耗太大而只允许创建一个对象。
 *
 *  客户调用类的单个实例只允许使用一个公共访问点，除了该公共访问点，不能通过其他途径访问该实例。
 */
public class SingLeton {

    /**
     * 利用静态变量来记录SingLeton 的唯一实例
     */
    private static SingLeton uniqueInstance;

    /**
     * 构造器私有化，只有SingLeton 类内才可以调用构造器
     */
    private SingLeton(){

    }

    public static SingLeton getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new SingLeton();
        }
        return uniqueInstance;
    }
}
