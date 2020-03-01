package com.joah.everyday.N2020.N202001.N20200111.redis;

import lombok.Data;

@Data
public class Author {

    private String name;

    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
