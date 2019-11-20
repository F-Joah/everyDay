package com.joah.everyday.N20191119.proxy;

public class Client {

    public static void main(String[] args) {
        BeautifulGirl girl = new BeautifulGirl("清风");

        HerChum chum = new HerChum(girl);

        chum.giveBook();
        chum.giveChocolate();
        chum.giveFlowers();

    }
}
