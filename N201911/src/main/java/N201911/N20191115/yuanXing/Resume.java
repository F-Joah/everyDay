package N201911.N20191115.yuanXing;

/**
 * 简历
 */
public class Resume implements Cloneable{

    /**
     * 姓名
     */
    private String name;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 性别
     */
    private String sex;

    /**
     * 学校
     */
    private String school;

    /**
     * 工作年限
     */
    private String timeArea;

    /**
     * 公司
     */
    private String company;

    /**
     * 构造函数：初始化简历赋值姓名
     * @param name
     */
    public Resume(String name){
        this.name = name;
    }

    /**
     * 设定个人基本信息
     * @param birthday
     * @param sex
     * @param school
     */
    public void setPersonInfo(String birthday, String sex, String school){
        this.birthday = birthday;
        this.sex = sex;
        this.school = school;
    }

    /**
     * 设定工作年限
     * @param timeArea
     * @param company
     */
    public void setWorkExperience(String timeArea,String company){
        this.timeArea = timeArea;
        this.company = company;
    }

    @Override
    public Object clone(){
        Resume resume = null;
        try {
            resume = (Resume) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return resume;
    }

    public void display(){
        System.out.println("姓名：" + name);
        System.out.println("生日：" + birthday + "，性别：" + sex + ",毕业学校：" + school);
        System.out.println("工作年限：" + timeArea + "，公司：" + company);
    }


}
