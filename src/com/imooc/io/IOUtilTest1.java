package com.imooc.io;

import java.io.IOException;

public class IOUtilTest1 {

	public static void main(String[] args) {
		try {
//			IOUtil.printHexByByte("G:\\code\\python code\\break_continue.py");
			long start = System.currentTimeMillis();
			IOUtil.copyFile("C:\\Users\\WDMIC\\Desktop\\1.CHM", "C:\\Users\\WDMIC\\Desktop\\2.CHM"); //11∫¡√Î
//			IOUtil.copyByBuffer("C:\\Users\\WDMIC\\Desktop\\1.CHM", "C:\\Users\\WDMIC\\Desktop\\3.CHM"); // 11∫¡√Î
//			IOUtil.copyByByte("C:\\Users\\WDMIC\\Desktop\\1.CHM", "C:\\Users\\WDMIC\\Desktop\\4.CHM"); // 6819∫¡√Î
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
