package com.joah.everyday.N2019.N201911.N20191121.interpreter;

/**
 * 主要用解释该表达式的值
 */
public class ValueNode implements Node {

    private int value;

    public ValueNode(int value)
    {
        this.value = value;
    }

    @Override
    public int interpret()
    {
        return this.value;
    }
}
