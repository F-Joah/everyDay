package N201911.N20191107;

import java.util.*;

public class Algorithm {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();

        // 数组重组，成最小的数
        int[] numbers = {45, 12, 21};
        algorithm.printNum(numbers);
        // 比较器
        algorithm.comparato();

    }


    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     */
    public static String printNum(int[] numbers){
        String result = "";
        int length = numbers.length;
        if (length < 1){
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0; i < length; i++){
            list.add(numbers[i]);
        }

        /**
         * 比较器的使用
         */
        Collections.sort(list, new Comparator<Integer>() {
            /**
             * 如果两个字符串首字母不同，则该方法返回首字母的asc码的差值
             * 参与比较的两个字符串如果首字符相同，则比较下一个字符，直到有不同的为止，
             * 返回该不同的字符的asc码差值，如果两个字符串不一样长，
             * 可以参与比较的字符又完全一样，则返回两个字符串的长度差值
             * @param o1
             * @param o2
             * @return 比较的前后两个字符串的asc码的差值
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                String result1 = o1 + "" + o2;
                String result2 = o2 + "" + o1;
                return result1.compareTo(result2);
            }
        });

        Iterator<Integer> integer = list.iterator();
        while (integer.hasNext()){
            result += (integer.next() + "");
        }

        System.out.println("最小值为：---------->>>> " + result);

        return result;
    }

    /**
     *  比较器的使用
     */
    public static void comparato(){
        List<Student> list = new ArrayList();
        list.add(new Student(1,12,"张三"));
        list.add(new Student(2,15,"李四"));
        list.add(new Student(3,6,"王五"));
        list.add(new Student(4,34,"赵六"));
        list.add(new Student(5,25,"冯巩"));
        list.add(new Student(6,40,"李彦"));
        System.out.println("-------------------------------");
        for (Student stu : list){
            System.out.println(stu.toString());
        }
        System.out.println("-------------------------------");
        Collections.sort(list);
        for (Student stu : list){
            System.out.println(stu.toString());
        }
    }
}
