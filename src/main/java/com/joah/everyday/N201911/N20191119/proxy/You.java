package com.joah.everyday.N201911.N20191119.proxy;

public class You implements GiveGift {

    BeautifulGirl girl;

    public You(BeautifulGirl girl){
        this.girl = girl;
    }

    @Override
    public void giveFlowers() {
        System.out.println(girl.getName() + "，送你一本书");
    }

    @Override
    public void giveChocolate() {
        System.out.println(girl.getName() + "，送你一盒巧克力");
    }

    @Override
    public void giveBook() {
        System.out.println(girl.getName() + "，送你一束花");
    }
}
