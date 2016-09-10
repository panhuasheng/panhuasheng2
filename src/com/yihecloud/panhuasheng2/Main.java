package com.yihecloud.panhuasheng2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	/**
	 * 主方法入口 32
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("请输入两个以下格式的时间：（HH:mm:ss HH:mm:ss）(用空格隔开，第一个时间为开始时间，回车结束)");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String time = bufferedReader.readLine();
		String times[] = time.split(" ");
		String hm1[] = null, hm2[] = null;
		if (times[0].indexOf(":")>=0) {
			hm1 = times[0].split(":");
			hm2 = times[1].split(":");
		}else if (times[0].indexOf("：")>=0) {
			hm1 = times[0].split("：");
			hm2 = times[1].split("：");
		}
		int h1 = Integer.parseInt(hm1[0]),
				m1 = Integer.parseInt(hm1[1]),
				h2 = Integer.parseInt(hm2[0]),
				m2 = Integer.parseInt(hm2[1]);
		count(h1,m1,h2,m2);
	}
	/**
	 * 实际执行方法 69
	 */
	public static void count(int h1,int m1,int h2,int m2){
		if (h2 == 24) h2--;
		int count = h2-h1-1, a1 = 0, a2 = 0 , m = m1;
        for(; m<60; m++){  
            double gap = (30 * h1 - 5.5 * m) % 360;  
            if(-6.0 < gap && gap < 6.0) a1++;
        }  
        for(m=0; m<m2; m++){  
            double gap = (30 * h2 - 5.5 * m) % 360;  
            if(-6.0 < gap && gap < 6.0) a2++;
        }  
        if (a1>0) count++; 
        if (a2>0) count++;  
		System.out.println(count);
	}
}
