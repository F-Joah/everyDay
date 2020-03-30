package N201911.N20191115.singLeton;

public class SingLetonVolatile {

    /**
     * 利用静态变量来记录SingLeton 的唯一实例
     * Volatile 关键字确保：当 uniqueInstance 变量被初始化成 SingLeton 实例时，
     * 多个线程正确处理 uniqueInstance 变量
     */
    private volatile static SingLetonVolatile uniqueInstance;

    /**
     * 构造器私有化，只有SingLeton 类内才可以调用构造器
     */
    private SingLetonVolatile(){

    }

    /**
     * 检查实例 如果不存在 就进入同步区域
     * @return
     */
    public static SingLetonVolatile getInstance(){
        if (uniqueInstance == null){
            synchronized (SingLeton.class){
                // 进入同步区域
                if (uniqueInstance == null){
                    // 再检查一次，如果为null 则创建
                    uniqueInstance = new SingLetonVolatile();
                }
            }
        }
        return uniqueInstance;
    }
}
