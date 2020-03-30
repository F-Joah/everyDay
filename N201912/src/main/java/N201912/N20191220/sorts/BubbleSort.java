package N201912.N20191220.sorts;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] data = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        int length = data.length;

        long startTime = System.currentTimeMillis();
        bubbleSort(data, length);
        long endTime = System.currentTimeMillis();
        System.out.println("bubbleSort消耗用时：" + (endTime - startTime));
        System.out.println(Arrays.toString(data));
        int[] arrays = new int[]{2, 8, 9, 5, 6, 7, 12, 58, 78};

        long startTime2 = System.currentTimeMillis();
        bubbleSort2(arrays, arrays.length);
        long endTime2 = System.currentTimeMillis();

        System.out.println("bubbleSort2消耗用时：" + (endTime2 - startTime2));
        System.out.println(Arrays.toString(arrays));
    }

    /**
     *
     * @param data 数组
     * @param n 数组大小
     */
    public static void bubbleSort(int[] data,int n){
        if (n <= 1){
            return;
        }
        for (int i = 0; i < n; ++i){
            // 提前退出的标识
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j){
                if (data[j] > data[j+1]){
                    // 交换位置
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }

    public static void bubbleSort2(int[] data, int n){
        if (n <= 1){
            return;
        }
        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界，每次只需比较到这里就可以了
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            // 提前退出标志位
            boolean flge = false;
            for (int j = 0; j < sortBorder; j++) {
                if (data[j] > data[j + 1]){
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                    flge = true;
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flge){
                break;
            }
        }

    }
}
