package com.joah.everyday.N2019.N201911.N20191119.proxy;

public class Client {

    public static void main(String[] args) {
        BeautifulGirl girl = new BeautifulGirl("清风");

        HerChum chum = new HerChum(girl);

        chum.giveBook();
        chum.giveChocolate();
        chum.giveFlowers();

    }
}
