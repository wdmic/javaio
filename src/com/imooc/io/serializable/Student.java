package com.imooc.io.serializable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 实现序列化必须实现Serializable接口，这个接口没有方法，这是标准
 * @author WDMIC
 *
 */

public class Student implements Serializable {
	private String num;
	private String name;
	//transient修饰的是不可以被jvm默认序列化的，但是可以自己完成该序列化
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
		s.defaultWriteObject();//将jvm能默认序列化的元素进行序列化
		s.writeInt(age);//自己完成age的序列化
	}
	
	private void readObject(java.io.ObjectInputStream s)
	        throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();//将jvm能默认反序列化的元素进行反序列化
		this.age = s.readInt();//自己完成age的反序列化
	}

}
