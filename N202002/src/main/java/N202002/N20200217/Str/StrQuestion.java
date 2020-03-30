package N202002.N20200217.Str;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author Joah
 * @time 2020/2/17 9:32
 */
public class StrQuestion {

    public void changeValue1(int age){
        age = 30;
    }

    public void changeValue2(Person person){
        person.setPersonName("xxx");
    }

    public void changeValue3(String str){
        str = "xxx";
    }
    public static void main(String[] args) {

        /**
         * 基本类型，传值，是 传的 “复印件”
         */

        StrQuestion strQuestion = new StrQuestion();
        int age = 20;
        strQuestion.changeValue1(age);

        // 20
        System.out.println("age----------------->" + age);

        /**
         * 引用的是 地址 （修改的时候，也是去修改地址中的值）
         */
        Person person = new Person("ac");
        strQuestion.changeValue2(person);

        // xxx
        System.out.println("personName----------------->" + person.getPersonName());

        String str = "abc";
        strQuestion.changeValue3(str);
        // abc
        System.out.println("str----------------->" + str);

    }

    public static void strQuestion(){
        String a = new String();
        a += "李四";

        a += "王五";
        System.out.println("---------->>>>>>>>>" + a);


        /**
         * public synchronized StringBuffer append
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("李四");

        /**
         * public StringBuilder append
         */
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("张三");

        /**
         * public V put(K key, V value)
         *
         * key,value都可以为空
         */
        HashMap hashMap = new HashMap();
        hashMap.put(null,null);

        /**
         * public synchronized V put
         * // Make sure the value is not null
         *         if (value == null) {
         *             throw new NullPointerException();
         *         }
         *
         * key，value都不能为空
         * java.lang.NullPointerException
         */
        Hashtable hashtable = new Hashtable();
        hashtable.put(null,"张三");

    }
}
