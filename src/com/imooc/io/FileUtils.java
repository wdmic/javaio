package com.imooc.io;

import java.io.File;
import java.io.IOException;

//列出File的一些常用操作 比如过滤、遍历等操作
public class FileUtils {
	
	/**
	 * 列出指定目录包括其子目录下的所有文件
	 */
	public static void listDirectory(File dir) throws IOException {
		//判断传入目录的规范性
		if (!dir.exists()) {
			throw new IllegalArgumentException("目录：" + dir + "不存在");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "不是目录");
		}
		File[] files = dir.listFiles();
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isDirectory()) {
					listDirectory(file);
				}
				System.out.println(file);
			}
		}
		
	}

}
