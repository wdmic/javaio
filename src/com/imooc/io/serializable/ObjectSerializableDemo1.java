package com.imooc.io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializableDemo1 {
	/**
	 * student���л�
	 * @param args
	 */

	public static void main(String[] args) {
		String file = "demo/obj.dat";
		try {
			//��������л�
			/*ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(file));
			Student student = new Student("10001", "����", 20);
			oos.writeObject(student);
			oos.flush();
			oos.close();*/
			//�������л�
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
