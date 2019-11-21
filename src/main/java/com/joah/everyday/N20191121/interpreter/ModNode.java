package com.joah.everyday.N20191121.interpreter;

public class ModNode extends SymbolNode {

    public ModNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return super.left.interpret() % super.right.interpret();
    }
}
