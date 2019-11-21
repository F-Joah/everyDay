package com.joah.everyday.N20191121.interpreter;

public abstract class SymbolNode implements Node
{
    protected Node left;

    protected Node right;

    public SymbolNode(Node left, Node right)
    {
        this.left = left;
        this.right = right;
    }
}
