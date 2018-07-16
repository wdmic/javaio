package com.imooc.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class IOUtil {
	/**
	 * ��ȡָ���ļ����ݣ�����ʮ���������������̨
	 * û���ʮ��byte ����
	 * @param filename
	 * @throws IOException
	 */
	
	public static void printHex(String filename) throws IOException {
		FileInputStream in = new FileInputStream(filename);
		int b;//����һ��int���͵ı�������סÿ�ζ�ȡ��һ���ֽڡ�
		int i = 1;//���б���
		while ((b=in.read())!=-1) {
			if (b <= 0xf) {//����ǵ�λ����ǰ�油0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + "  ");
			if (i++%10==0) {
				System.out.println();
			}
		}
		in.close();
	}
	/**
	 * int read(byte[] b,int off,int len);����������ȡ�����ֽڣ������Ǳ��浽����bָ�����ֽ������У�
	 * offָ���ֽ����鿪ʼ�������ݵ���ʼ�±꣬len��ʾ��ȡ���ֽ���Ŀ��
	 */
	public static void printHexByByte(String filename) throws IOException {
		FileInputStream in = new FileInputStream(filename);
		byte[] buf = new byte[5 * 1024];
		/**
		 * in.read(buf, 0, buf.length);
		 * ��in��������ȡ�ֽڷ���buf������
		 * �ӵ�0����ʼ���룬������buf.length��
		 * ���ص��Ƕ������ֽڸ���
		 */
//		int bytes = in.read(buf, 0, buf.length);
//		int j = 1;
//		for (int i = 0; i < bytes; i++) {
//			if (buf[i] <= 0xf) {
//				System.out.print("0");
//			}
//			System.out.print(Integer.toHexString(buf[i]) + " ");
//			if (j++%10==0) {
//				System.out.println();
//			}
//		}
		//������ٵ�����ռ䲻������������
		int bytes;
		int j = 1;
		while ((bytes=in.read(buf, 0, buf.length))!=-1) {
			for (int i = 0; i < bytes; i++) {
				if (buf[i] <= 0xf) {
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");//byte����8λ��int����32λ����������ת�����󣬽���24λ����
				if (j++%10==0) {
					System.out.println();
				}
			}
		}
		in.close();
	}
	
	/**
	 * �����ٶȺͻ��������ٶȲ�� �ܿ�
	 * ������д�����ļ�����
	 */
	public static void copyFile(String srcFile, String destFile) throws IOException {
		//�ж�Դ�ļ��Ƿ����
		if (!new File(srcFile).exists()) {
			throw new IllegalArgumentException("�ļ�" + srcFile + "������");
		}
		if (!new File(srcFile).isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ� ");
		}
		FileInputStream in = new FileInputStream(srcFile);
		//���ļ��������򴴽������ļ�������ɾ���ڴ������������true��ɾ��ֱ��׷������
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buf = new byte[1*1024];
		int bytes;
		while ((bytes = in.read(buf, 0, buf.length))!=-1) {
			out.write(buf, 0, bytes);
			out.flush();//��ü���
		}
		in.close();
		out.close();
		
	}
	
	/**
	 * ���ô�������ֽ��������ļ�
	 */
	public static void copyByBuffer(String srcFile, String destFile) throws IOException {
		//�ж�Դ�ļ��Ƿ����
		if (!new File(srcFile).exists()) {
			throw new IllegalArgumentException("�ļ�" + srcFile + "������");
		}
		if (!new File(srcFile).isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ� ");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		byte[] buf = new byte[1*1024];
		int b;
		while ((b = bis.read(buf, 0, buf.length))!=-1) {
			bos.write(buf, 0, b);
			bos.flush();//������ϣ�ˢ�»�����
		}
		bis.close();
		bos.close();
		
	}
	
	/**
	 * �����ٶ�����
	 * һ��һ���ֽڵĿ���
	 */
	public static void copyByByte(String srcFile, String destFile) throws IOException {
		//�ж�Դ�ļ��Ƿ����
		if (!new File(srcFile).exists()) {
			throw new IllegalArgumentException("�ļ�" + srcFile + "������");
		}
		if (!new File(srcFile).isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ� ");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);
			out.flush();
		}
		in.close();
		out.close();
		
	}

}
