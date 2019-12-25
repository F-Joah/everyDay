package com.joah.everyday.N201911.N20191117.composite;

public class Client {

    public static void main(String[] args) {
        /**
         *  建立一个 文件系统
         *          总文件夹
         *    A.txt    b.jpg               c文件夹
         *                      c_1.text    c_2.rmvb     c_3.jpg
         */

        // 总文件夹
        Folder zwjj = new Folder("总文件夹");
        // 向总文件夹中放入三个文件： 1.txt  2.jpg    、1 文件夹
        TextFile aText = new TextFile("a.txt");
        ImagerFile bImager = new ImagerFile("b.jpg");
        Folder cFolder = new Folder("c文件夹");

        zwjj.add(aText);
        zwjj.add(bImager);
        zwjj.add(cFolder);

        // 向C文件夹中添加文件：C_1.txt  C_2.rmvb     C_3.jpg
        TextFile cText = new TextFile("c_1.txt");
        ImagerFile cImager = new ImagerFile("c_2.jpg");
        VideoFile cVideo = new VideoFile("c_3.rmvb");

        cFolder.add(cText);
        cFolder.add(cImager);
        cFolder.add(cVideo);

        // 遍历总文件夹
        zwjj.display();
        System.out.println("---------------------------这是一条分割线---------------------------");
        // 遍历C文件夹
        cFolder.display();
        // 将c_1.txt删除
        cFolder.remove(cText);
        System.out.println("----------*-*-*----------");
        cFolder.display();

    }
}
