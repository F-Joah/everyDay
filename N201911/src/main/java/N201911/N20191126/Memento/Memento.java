package N201911.N20191126.Memento;

import lombok.Data;

@Data
public class Memento {

    private int bloodFlow;
    private int magicPoint;

    public Memento(int bloodFlow, int magicPoint){
        this.bloodFlow = bloodFlow;
        this.magicPoint = magicPoint;
    }
}
