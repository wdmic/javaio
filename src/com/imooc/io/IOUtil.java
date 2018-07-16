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
	 * 读取指定文件内容，按照十六进制输出到控制台
	 * 没输出十个byte 换行
	 * @param filename
	 * @throws IOException
	 */
	
	public static void printHex(String filename) throws IOException {
		FileInputStream in = new FileInputStream(filename);
		int b;//定义一个int类型的变量，记住每次读取的一个字节。
		int i = 1;//换行变量
		while ((b=in.read())!=-1) {
			if (b <= 0xf) {//如果是单位数，前面补0
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
	 * int read(byte[] b,int off,int len);从输入流读取若干字节，把它们保存到参数b指定的字节数组中，
	 * off指定字节数组开始保存数据的起始下标，len表示读取的字节数目。
	 */
	public static void printHexByByte(String filename) throws IOException {
		FileInputStream in = new FileInputStream(filename);
		byte[] buf = new byte[5 * 1024];
		/**
		 * in.read(buf, 0, buf.length);
		 * 从in中批量读取字节放入buf数组中
		 * 从第0个开始放入，最多放入buf.length个
		 * 返回的是读到的字节个数
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
		//如果开辟的数组空间不够，则用下面
		int bytes;
		int j = 1;
		while ((bytes=in.read(buf, 0, buf.length))!=-1) {
			for (int i = 0; i < bytes; i++) {
				if (buf[i] <= 0xf) {
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");//byte类型8位，int类型32位，避免数据转换错误，将高24位清零
				if (j++%10==0) {
					System.out.println();
				}
			}
		}
		in.close();
	}
	
	/**
	 * 拷贝速度和缓冲区的速度差不多 很快
	 * 批量读写进行文件拷贝
	 */
	public static void copyFile(String srcFile, String destFile) throws IOException {
		//判断源文件是否存在
		if (!new File(srcFile).exists()) {
			throw new IllegalArgumentException("文件" + srcFile + "不存在");
		}
		if (!new File(srcFile).isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件 ");
		}
		FileInputStream in = new FileInputStream(srcFile);
		//若文件不存在则创建，若文件存在则删除在创建，如果加上true则不删除直接追加内容
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buf = new byte[1*1024];
		int bytes;
		while ((bytes = in.read(buf, 0, buf.length))!=-1) {
			out.write(buf, 0, bytes);
			out.flush();//最好加上
		}
		in.close();
		out.close();
		
	}
	
	/**
	 * 利用带缓冲的字节流拷贝文件
	 */
	public static void copyByBuffer(String srcFile, String destFile) throws IOException {
		//判断源文件是否存在
		if (!new File(srcFile).exists()) {
			throw new IllegalArgumentException("文件" + srcFile + "不存在");
		}
		if (!new File(srcFile).isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件 ");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		byte[] buf = new byte[1*1024];
		int b;
		while ((b = bis.read(buf, 0, buf.length))!=-1) {
			bos.write(buf, 0, b);
			bos.flush();//必须加上，刷新缓冲区
		}
		bis.close();
		bos.close();
		
	}
	
	/**
	 * 拷贝速度最慢
	 * 一个一个字节的拷贝
	 */
	public static void copyByByte(String srcFile, String destFile) throws IOException {
		//判断源文件是否存在
		if (!new File(srcFile).exists()) {
			throw new IllegalArgumentException("文件" + srcFile + "不存在");
		}
		if (!new File(srcFile).isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件 ");
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
