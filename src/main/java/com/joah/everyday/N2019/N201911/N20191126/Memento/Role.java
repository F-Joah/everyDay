package com.joah.everyday.N2019.N201911.N20191126.Memento;

import lombok.Data;

/**
 * 游戏角色类
 */
@Data
public class Role {

    private int bloodFlow;
    private int magicPoint;

    public Role(int bloodFlow,int magicPoint){
        this.bloodFlow = bloodFlow;
        this.magicPoint = magicPoint;
    }

    /**
     * 展示角色当前状态
     */
    public void display(){
        System.out.println("用户当前状态");
        System.out.println("血量：" + getBloodFlow() + "; 蓝量：" + getMagicPoint());
    }

    /**
     * 保存存档、当前状态
     * @return
     */
    public Memento saveMemento(){
        return new Memento(getBloodFlow(), getMagicPoint());
    }

    /**
     * 恢复文档
     * @param memento
     */
    public void restoreMemento(Memento memento){
        this.bloodFlow = memento.getBloodFlow();
        this.magicPoint = memento.getMagicPoint();
    }

}
