package N201911.N20191115.yuanXing;

public class Client {

    public static void main(String[] args) {
        // 原型A对象
        Resume a = new Resume("小李子");
        a.setPersonInfo("10.14","男","xx大学");
        a.setWorkExperience("2012-09-05","xx公司");

        // 克隆B对象
        Resume b = (Resume) a.clone();

        // 输出A对象和B对象
        System.out.println("------------A------------");
        a.display();
        System.out.println("------------B------------");
        b.display();

        /**
         * 测试A == B?
         * 对任何对象x,都有x.clone() != x,即克隆对象与对象不是同一个对象
         */
        System.out.println("A == B?");
        System.out.println(a == b);

        /**
         * 对任何的对象X,都有x.clone().getClass() == x.getClass().
         * 即克隆对象和原对象一致
         */
        System.out.println("A.getClass() == B.getClass()");
        System.out.println(a.getClass() == b.getClass());
    }
}
