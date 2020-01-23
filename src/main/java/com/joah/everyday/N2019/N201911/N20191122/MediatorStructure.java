package com.joah.everyday.N2019.N201911.N20191122;

public class MediatorStructure extends Mediator {

    /**
     * 首先中介者结构必须知道所有房主和租房者信息
     */
    private HouseOwner houseOwner;
    private Tenant tenant;

    public HouseOwner getHouseOwner(){
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner){
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant(){
        return tenant;
    }

    public void setTenant(Tenant tenant){
        this.tenant = tenant;
    }

    @Override
    public void constant(String message, Person person) {
        // 如果是房主，则租房者获得信息
        if (person == houseOwner){
            tenant.getMessage(message);
        }else {
            // 反正则是房主获得信息
            houseOwner.getMessage(message);
        }
    }
}
