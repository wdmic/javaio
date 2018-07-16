package com.imooc.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafDemo {

	public static void main(String[] args) throws IOException {
		//��ǰ·������Ŀ¼
		File demo = new File("demo");
		if (!demo.exists()) {
			demo.mkdir();
		}
		//�����ļ�
		File file = new File(demo, "raf.dat");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		//ָ��λ��
		System.out.println(raf.getFilePointer());
		
		raf.write('A'); //ֻдһ���ֽڣ���8λ
		
		int i = 0x7fffffff;
		//��writeдint���ͣ���Ҫд���Ĵ�
		raf.write(i >>> 24); //����24λ��ȡ��8λ
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		
		//����writeInt������ֱ��д��int
		raf.writeInt(i);//ԭ���������ͬ
		
		String string = "��";
		byte[] gbk = string.getBytes();
		raf.write(gbk);//ֱ��д���ֽ�����
		
		//���ļ����뽫ָ���Ƶ�ͷ��
		raf.seek(0);
		//һ���Զ�ȡ�������ݶ����ֽ�������
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		System.out.println(Arrays.toString(buf));
		
		raf.close();
	}

}
