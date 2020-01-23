package com.joah.everyday.N2019.N201911.N20191121.interpreter;

public class MulNode extends SymbolNode {

    public MulNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpret()
    {
        return super.left.interpret() * super.right.interpret();
    }
}
