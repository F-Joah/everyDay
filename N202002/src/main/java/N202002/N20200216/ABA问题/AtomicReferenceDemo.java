package N202002.N20200216.ABA问题;


import java.util.concurrent.atomic.AtomicReference;

class User{

    String userName;
    int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

/**
 * 原子引用
 * @author Joah
 * @time 2020/2/16 18:20
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {

        User zs = new User("zs",22);
        User ls = new User("ls",25);

        AtomicReference<User> atomicUser = new AtomicReference<>();
        atomicUser.set(zs);

        // 张三 变 李四
        System.out.println(atomicUser.compareAndSet(zs, ls) + "\t " + atomicUser.get().toString());
        System.out.println(atomicUser.compareAndSet(zs, ls) + "\t " + atomicUser.get().toString());

    }
}
