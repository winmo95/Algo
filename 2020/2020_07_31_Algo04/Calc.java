package com.ssafy.ws.day05;

import java.util.Scanner;
import java.util.Stack;

public class Calc {
	public static void main(String[] args) {
	    
		Scanner sc = new Scanner(System.in);
	     int len;
	     for(int tc=1;tc<=10;tc++) {
	    	  len = Integer.parseInt(sc.nextLine());
	    	  String str = sc.nextLine();
	    	  String postOrder = doPostOrder(str);
	    	
		      int num = doCalc(postOrder);
		      System.out.println("#"+tc+" "+num);
	      }
	      
	 }
	
	static int doCalc(String s) {
	      char[] srr = s.toCharArray();
	      Stack<Integer> stack = new Stack<Integer>();
	      int num1, num2, num3;
	      for(char ch : srr) {
	         if(ch >= '0' && ch <= '9') {
	            stack.push(ch - '0');  //ch-'0'
	         }else {
	        	
	            num2 = stack.pop();
	            num1 = stack.pop();
	            num3 = calc(ch, num1, num2);
	            stack.push(num3);
	         }
	      }
	      return stack.pop();      
	   }
	  
	   static String doPostOrder(String str) {
	      String result = "";
	      char[] srr = str.toCharArray();
	      Stack<Character> s = new Stack<Character>();
	      char temp;
	      int cnt =0;
	      for(char ch : srr) {
	    	  switch(ch) {
	    	  case '+':
	    		  if(!s.isEmpty()) {
	    			  while(!s.isEmpty()) {	    				  
	    				  result+=s.pop();
	    			  }
	    		  }
	    		  s.push(ch);
	    		  break;
	    	  case '*':
	    		  if(!s.isEmpty()) {
	    			  while(!s.isEmpty()) {
	    				  if(s.peek() !='+') {
	    					  result+=s.pop();
	    				  }else {
	    					  break;
	    				  }
	    			  }
	    		  }
	    		  s.push(ch);
	    		  break;
	    	  default:
	    		  result+=ch;
	    	  }
	      }
	      
	      while(!s.isEmpty()) result+=s.pop();
	      return result;
	   }
	   static int getPrority(char ch) {
	      int result = 0;
	      switch(ch) {
	      case '*':    
	         result = 2;
	         break;
	      case '+':     
	         result = 1;
	         break;
	      }      
	      return result;
	   }
	   
	   static int calc(char ch, int num1, int num2) {
		      int result = 0;
		      switch(ch) {
		      case '+':
		         result = num1 + num2;
		         break;
		      case '*':
		         result = num1 * num2;
		         break;
		      }
		      return result;
		   }
}
