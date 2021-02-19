package io;

import java.io.*;

public class ioput {
    public static void main(String[] args) {
        try {
            byte[] buffer = new byte[1024];
            // 来源文件
            FileInputStream fileInputStream = new FileInputStream(new File("D:\\test\\xiaoshuo.txt"));
            // 目的文件
            FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\test\\xiaoshuo2.txt"));
            while(true) {
                if(fileInputStream.available() < 1024) {// available()可取得未读取的数据长度
                    // 剩余的数据比1024字节少，一位一位读出再写入目的文件
                    int remain = -1;
                    while((remain = fileInputStream.read()) != -1) {
                        fileOutputStream.write(remain);
                    }
                    break;
                } else {
                    // 从来源文件读取数据至缓冲区
                    fileInputStream.read(buffer);
                    // 将数组数据写入目的文件
                    fileOutputStream.write(buffer);
                }
            }
            // 关闭流
            fileInputStream.close();
            fileOutputStream.close();
            System.out.println("复制完成");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("using: java FileStreamDemo src des");
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
