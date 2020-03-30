package N201911.N20191117.decorator.beverage;

public abstract class Beverage {

    protected String description = "Unknown Beverage";

    /**
     * 抽象一个 详情 方法
     * @return
     */
    public String getDescription(){

        return description;
    }

    /**
     * 抽象一个 价格 方法
     * @return
     */
    public abstract double cost();
}
