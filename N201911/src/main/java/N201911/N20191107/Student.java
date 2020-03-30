package N201911.N20191107;

import lombok.Data;

@Data
public class Student implements Comparable<Student>{

    private Integer id;

    private Integer age;

    private String name;

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    /**
     * 按照年龄排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Student o) {

        return this.age - o.age;
    }
}
