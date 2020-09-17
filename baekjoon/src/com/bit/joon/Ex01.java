package com.bit.joon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		OutputStream os = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		int a = sc.nextInt();


		int ans = ((a - 1) * 1000) + 666;
		// System.out.print(ans);
		
		String aa = ans+"";
	
		while(true){
			
			
			
			break;
		}

		if(aa.contains("6666")) {
			aa.replace(aa.valueOf(aa.lastIndexOf("6")), "7");
		}
		if(aa.contains("66666")) {
			
			aa.replace(aa.valueOf(aa.lastIndexOf("66")), "7");
		}
		if(aa.contains("666666")) {
			
		}
		if(aa.contains("6666666")) {
			
		}
//		6666666
//		666666
//		66666
//		6666
		try {
			os.write((ans+"").getBytes());
			os.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// main

}
