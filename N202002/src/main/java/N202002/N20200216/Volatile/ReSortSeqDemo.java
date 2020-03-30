package N202002.N20200216.Volatile;

/**
 * @author Joah
 * @time 2020/2/16 13:30
 * 指令重排
 */
public class ReSortSeqDemo {
    int a = 0;
    boolean flag = false;

    public void method01(){
        // 语句1
        a = 1;
        // 语句2
        flag = true;
    }

    /**
     * 多线程环境中，线程交替执行，由于编译器优化重排的存在
     * 两个线程中使用的变量能否保证一致性无法确定，结果无法预测
     */
    public void method02(){
        if (flag){
            // 语句3
            a = a + 5;
            System.out.println("*********************retValue:" + a);
        }
    }

}
