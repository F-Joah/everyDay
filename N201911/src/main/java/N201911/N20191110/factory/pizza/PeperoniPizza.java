package N201911.N20191110.factory.pizza;

public class PeperoniPizza extends Pizza  {

    @Override
    public void prepare() {
        System.out.println("----------------->>>> prepare ChicagoStylePeperoniPizza...");
    }

    @Override
    public void bake() {
        System.out.println("----------------->>>> bake ChicagoStylePeperoniPizza...");
    }

    @Override
    public void cut() {
        System.out.println("----------------->>>> cut ChicagoStylePeperoniPizza...");
    }

    @Override
    public void box() {
        System.out.println("----------------->>>> box ChicagoStylePeperoniPizza...");
    }
}
