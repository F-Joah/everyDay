package N201911.N20191117.composite;

public class ImagerFile extends File{

    public ImagerFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("这是图像文件夹，文件名：" + super.getName());
    }
}
