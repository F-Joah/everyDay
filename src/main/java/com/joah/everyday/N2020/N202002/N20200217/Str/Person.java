package com.joah.everyday.N2020.N202002.N20200217.Str;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Joah
 * @time 2020/2/17 11:03
 */
@Getter
@Setter
@NoArgsConstructor
public class Person {

    private Integer id;

    private String personName;

    public Person(String personName){

        this.personName = personName;
    }
}
