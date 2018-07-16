package com.imooc.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BrAndBwOrPwDemo {
	
	/**
	 * BufferedReader BufferedWriter PrintWriter 的演示
	 * @param args
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("G:\\code\\python code\\break_continue.py")));
//		BufferedWriter bw = new BufferedWriter(
//				new OutputStreamWriter(
//						new FileOutputStream("G:\\code\\python code\\break_continuecopy.py")));
		//通常用PrintWriter
		PrintWriter pw = new PrintWriter("G:\\code\\python code\\break_continuecopy.py");
		String line;
		while ((line = bf.readLine()) != null) {//readLine()不支持换行
			System.out.println(line);
//			bw.write(line);
//			bw.newLine();//添加换行
//			bw.flush();
			pw.println(line);
			pw.flush();
		}
		bf.close();
//		bw.close();
		pw.close();
	}

}
