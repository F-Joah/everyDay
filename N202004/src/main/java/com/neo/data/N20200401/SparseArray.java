package com.neo.data.N20200401;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 稀疏数组
 * @author Joah
 * @time 2020/4/1 9:39
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0 表示没有棋子，1 表示黑子， 2 表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        // 输出原始二维数组
        System.out.println("------------------原始二维数组------------------");
        for (int[] row : chessArr1){
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        /**
         * 将二维数组 转换成 稀疏数组
         */
        // 1、先遍历二维数组，得到 【非0】数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++){
            for (int j = 0; j < 11; j++){
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        // 2、创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 3、给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 4、遍历二维数组，将非零的值，存放到 稀疏数组中
        // 用来记录第几个非零数据
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++){
            for (int j = 0; j < 11; j++){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        // 输出稀疏数组
        System.out.println();
        System.out.println("------------------得到的稀疏数组------------------");
        for (int[] row : sparseArr){
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /**
         * TODO 把稀疏数组保存到磁盘上
         */

        // 将稀疏数组，恢复成二维数组
        // 1、先读取第一行，获取到原始二维数组的行列数
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] twoArr = new int[row][col];

        // 2、循环二维数组，剩下的每一行中的数据
        for (int i = 1; i < sparseArr.length; i++){
            int col1 = sparseArr[i][0];
            int col2 = sparseArr[i][1];
            int col3 = sparseArr[i][2];
            twoArr[col1][col2] = col3;
        }
        System.out.println();
        System.out.println("------------------转换成二维数组------------------");
        for (int[] rows : twoArr){
            for (int data : rows){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}



















