package N201911.N20191117.flyweight;

import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    static Map<String,Shape> shapeMap = new HashMap<>();

    public static Shape getShap(String key){
        Shape shape = shapeMap.get(key);

        if (ObjectUtils.isEmpty(shape)){
            shape = new Circle(key);
            shapeMap.put(key,shape);
        }
        return shape;
    }

    public static int getSum(){

        return shapeMap.size();
    }
}
