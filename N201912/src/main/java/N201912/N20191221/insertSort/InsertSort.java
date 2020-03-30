package N201912.N20191221.insertSort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] data = new int[]{3, 5, 8, 4, 9, 12, 0, 2, 5, 7, 9};
        insertSort(data);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 插入排序
     * @param data 数组
     */
    public static void insertSort(int[] data){
        for (int i = 1; i < data.length; i++) {
            int value = data[i];

            int[] tem = new int[2];
            int change = i;
            for (int j = 0; j < i; j++) {
                if (value > data[j]){
                    continue;
                }
                int index = j%2;
                if (change == i){
                    tem[Math.abs(index - 1)] = data[j];
                    change = j;
                }
                tem[index]= data[j + 1];
                if (0 == index){
                    data[j + 1] = tem[index + 1];
                }else {
                    data[j + 1] = tem[index - 1];
                }
            }
            data[change] = value;
        }
    }
}
