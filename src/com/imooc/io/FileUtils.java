package com.imooc.io;

import java.io.File;
import java.io.IOException;

//�г�File��һЩ���ò��� ������ˡ������Ȳ���
public class FileUtils {
	
	/**
	 * �г�ָ��Ŀ¼��������Ŀ¼�µ������ļ�
	 */
	public static void listDirectory(File dir) throws IOException {
		//�жϴ���Ŀ¼�Ĺ淶��
		if (!dir.exists()) {
			throw new IllegalArgumentException("Ŀ¼��" + dir + "������");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "����Ŀ¼");
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
