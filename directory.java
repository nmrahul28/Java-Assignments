package java_application;
import java.io.*;
public class directory {
	//method to find the files in home directory
	public void find(String directory_path) {
		//here creating the file type object.
		File directory =new File(directory_path);
		//taking all files in the directory into a file list
		File[] list=directory.listFiles();
		if(list==null) {
			//checking whether list contains files or not
			System.out.println("Empty Directory");
			return;
		}
		//iterating through files and directories inside home directory
		for(File item:list) {
			if(item.isDirectory()) {
				//if it a directory the method is called again in recursive way
				find(item.getAbsolutePath());
			}
			else {
				System.out.println("File:"+item.getAbsolutePath());
			}
		}
	}	

	public static void main(String[] args) {
		//this the main method
		//creating object of the class
		directory path=new directory();
		path.find("/home/zadmin");
	}

}
