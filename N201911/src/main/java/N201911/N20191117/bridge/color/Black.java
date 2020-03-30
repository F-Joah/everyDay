package N201911.N20191117.bridge.color;

public class Black implements Color {

    @Override
    public void bepaint(String shape) {
        System.out.println("黑色的：" + shape);
    }
}
