package com.neo.data.N20200401;

import java.io.*;

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
        soutSparseArr(chessArr1);

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
        System.out.println("------------------得到的稀疏数组,并把保存到文件中------------------");
        for (int[] row : sparseArr){
            for (int data : row){
                System.out.printf("%d\t", data);
                // 把数组元素放到number.list中
                putInNumber(data);
            }
            System.out.println();
        }

        // 读取文件，获取到稀疏数组
        String s = readFile();
        int[][] sparseArrByFile = file2SparseArr(s);

        // 将稀疏数组，恢复成二维数组
        // 1、先读取第一行，获取到原始二维数组的行列数
        int[][] twoArr = new int[sparseArrByFile[0][0]][sparseArrByFile[0][1]];

        // 2、循环二维数组，剩下的每一行中的数据
        for (int i = 1; i < sparseArrByFile.length; i++){
            int col1 = sparseArrByFile[i][0];
            int col2 = sparseArrByFile[i][1];
            int col3 = sparseArrByFile[i][2];
            twoArr[col1][col2] = col3;
        }
        System.out.println();
        System.out.println("------------------读取文件中的稀疏数组转换成二维数组------------------");
        soutSparseArr(twoArr);
    }

    /**
     * 把文件中查出来的 稀疏数组 String 转换成 数组并输出
     */
    public static int[][] file2SparseArr(String str){
        String[] split = str.split("-");
        int val = 0;
        int sparseArr2[][] = new int[split.length / 3][3];
        System.out.println( "split.length:" + split.length + "   split.length / 3 = " + split.length / 3);
        for (int i = 0; i < split.length / 3; i++) {
            for (int j = 0; j < 3; j++) {
                sparseArr2[i][j] = Integer.valueOf(split[val++]);
            }
        }
        System.out.println("------------------file2SparseArr得到的稀疏数组------------------");
        soutSparseArr(sparseArr2);
        return sparseArr2;
    }

    /**
     * 输出二维数组
     * @param sparseArr2
     */
    private static void soutSparseArr(int[][] sparseArr2) {
        for (int[] row : sparseArr2){
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    /**
     * 读取文件
     */
    public static String readFile(){
        // 文件名称
        File f = new File("D:\\sparse.data");
        String s="";
        InputStream in=null;
        try{
            in=new FileInputStream(f);
            //在这里设置每次读取多少个字符，不用特别大
            byte[] b = new byte[10];
            while(in.read(b)!=-1){
                s+=new String(b);
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("content:"+s);
        return s;
    }


    /**
     * 把数组元素放到number.list中
     * @param d
     */
    public static void putInNumber(int d) {
        String str = d + "";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\sparse.data", true);
            fos.write(str.getBytes());
            fos.write('-');
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex);
            throw new RuntimeException("写入失败！");
        } finally {
            try {
                if (fos != null){
                    fos.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
                throw new RuntimeException("释放资源失败！");
            }
        }
    }

}



















