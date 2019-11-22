package com.joah.everyday.N20191122;

public class Client {

    public static void main(String[] args) {
        // 一个房东、一个租房者、一个中介机构
        MediatorStructure mediatorStructure = new MediatorStructure();

        // 房东和租房者只需要知道中介机构即可
        HouseOwner houseOwner = new HouseOwner("张三", mediatorStructure);
        Tenant tenant = new Tenant("李四", mediatorStructure);

        // 中介结构要知道房主和租房者
        mediatorStructure.setHouseOwner(houseOwner);
        mediatorStructure.setTenant(tenant);

        tenant.constact("听说你那里有三室的房主出租");
        houseOwner.constact("是的，");
    }
}
