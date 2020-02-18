package com.joah.everyday.N2020.N202002.N20200217.CountDownLatch;

import lombok.Getter;

import javax.security.auth.login.Configuration;

/**
 * @author Joah
 * @time 2020/2/17 16:54
 */
public enum ContryEnum {

    ONE(1,"齐"),
    TWO(2,"楚"),
    THREE(3,"燕"),
    FOUR(4,"赵"),
    FIVE(5,"魏"),
    SIX(6,"韩");

    @Getter
    private Integer retCode;

    @Getter
    private String retMessage;

    ContryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static ContryEnum forEachContryEnum(int index){

        ContryEnum[] myArry = ContryEnum.values();

        for (ContryEnum element : myArry){
            if (index == element.getRetCode()){
                return element;
            }
        }

        return null;
    }
}
