package com.imooc.io.serializable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ʵ�����л�����ʵ��Serializable�ӿڣ�����ӿ�û�з��������Ǳ�׼
 * @author WDMIC
 *
 */

public class Student implements Serializable {
	private String num;
	private String name;
	//transient���ε��ǲ����Ա�jvmĬ�����л��ģ����ǿ����Լ���ɸ����л�
	private transient int age;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String num, String name, int age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", age=" + age + "]";
	}
	public Student() {
		
	}
	private void writeObject(java.io.ObjectOutputStream s)
	        throws java.io.IOException{
		s.defaultWriteObject();//��jvm��Ĭ�����л���Ԫ�ؽ������л�
		s.writeInt(age);//�Լ����age�����л�
	}
	
	private void readObject(java.io.ObjectInputStream s)
	        throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();//��jvm��Ĭ�Ϸ����л���Ԫ�ؽ��з����л�
		this.age = s.readInt();//�Լ����age�ķ����л�
	}

}
