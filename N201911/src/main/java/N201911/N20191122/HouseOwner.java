package N201911.N20191122;

public class HouseOwner extends Person {

    HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    /**
     * 与中介者联系
     * @param message
     */
    public void constact(String message){

        mediator.constant(message,this);
    }

    /**
     * 获取信息
     * @param message
     */
    public void getMessage(String message){

        System.out.println("房主：" + name + ",获得信息：" + message);
    }
}
