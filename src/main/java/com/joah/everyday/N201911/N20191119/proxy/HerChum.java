package com.joah.everyday.N201911.N20191119.proxy;

public class HerChum implements GiveGift {

    You you;

    public HerChum(BeautifulGirl girl){
        you = new You(girl);
    }

    @Override
    public void giveFlowers() {
        you.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        you.giveChocolate();
    }

    @Override
    public void giveBook() {
        you.giveBook();
    }
}
