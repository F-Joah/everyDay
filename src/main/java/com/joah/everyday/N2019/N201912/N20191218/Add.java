package com.joah.everyday.N2019.N201912.N20191218;

/**
 * 一堆物品，摆成三角形，对折垒起来
 *          #
 *        #   #
 *      #   #   #
 *      ...
 *
 */
public class Add {

    public static void main(String[] args) {
        int answer = new Add().answer(40);
        System.out.println("answer-------->" + answer);
    }

    /**
     * 底层应该放几个
     * @param all 总物体数
     * @return
     */
    public int answer(int all){
        // 底层放的数量
        int sum = 0;
        int n = -1;
        int i ;
        for (i = 1; i < all; i++){
            sum  += i;
            if (sum == all || sum > all){
                break;
            }
            System.out.println("sum-------->" + sum);
            System.out.println("i-------->" + i);

        }
        System.out.println("sum-------->" + sum);
        System.out.println("all-------->" + all);
        return i;
    }
}
