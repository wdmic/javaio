package com.imooc.io;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest {

	public static void main(String[] args) throws IOException {
		//FileUtils类下的listDirectory是静态方法 所以不用创建对象可直接调用
		FileUtils.listDirectory(new File("G:\\code"));
		
	}

}
