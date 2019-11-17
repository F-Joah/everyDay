package com.joah.everyday.N20191117.bridge;

import com.joah.everyday.N20191117.bridge.color.Color;
import com.joah.everyday.N20191117.bridge.color.White;
import com.joah.everyday.N20191117.bridge.shape.Rectangle;
import com.joah.everyday.N20191117.bridge.shape.Shape;
import com.joah.everyday.N20191117.bridge.shape.Square;

public class Bridge {

    public static void main(String[] args) {
        // 白色
        Color white = new White();
        // 正方形
        Shape square = new Square();
        // 白色的正方形
        square.setColor(white);
        square.draw();

        // 长方形
        Shape rectange = new Rectangle();
        // 白色的长方形
        rectange.setColor(white);
        rectange.draw();
    }
}
