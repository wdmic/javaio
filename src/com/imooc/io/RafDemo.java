package com.imooc.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafDemo {

	public static void main(String[] args) throws IOException {
		//当前路径创建目录
		File demo = new File("demo");
		if (!demo.exists()) {
			demo.mkdir();
		}
		//创建文件
		File file = new File(demo, "raf.dat");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		//指针位置
		System.out.println(raf.getFilePointer());
		
		raf.write('A'); //只写一个字节，后8位
		
		int i = 0x7fffffff;
		//用write写int类型，需要写入四次
		raf.write(i >>> 24); //右移24位，取高8位
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		
		//调用writeInt，可以直接写入int
		raf.writeInt(i);//原理和上面相同
		
		String string = "中";
		byte[] gbk = string.getBytes();
		raf.write(gbk);//直接写入字节数组
		
		//读文件必须将指针移到头部
		raf.seek(0);
		//一次性读取，将内容读到字节数组中
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		System.out.println(Arrays.toString(buf));
		
		raf.close();
	}

}
