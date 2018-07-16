package com.imooc.io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializableDemo1 {
	/**
	 * student序列化
	 * @param args
	 */

	public static void main(String[] args) {
		String file = "demo/obj.dat";
		try {
			//对象的序列化
			/*ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(file));
			Student student = new Student("10001", "张三", 20);
			oos.writeObject(student);
			oos.flush();
			oos.close();*/
			//对象反序列化
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(file));
			Student student = (Student) ois.readObject();
			System.out.println(student);
			ois.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
