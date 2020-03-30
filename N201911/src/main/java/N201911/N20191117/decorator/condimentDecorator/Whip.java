package N201911.N20191117.decorator.condimentDecorator;

import com.joah.everyday.N2019.N201911.N20191117.decorator.beverage.Beverage;

public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
}
