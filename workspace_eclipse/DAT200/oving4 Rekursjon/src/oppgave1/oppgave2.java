package oppgave1;

import java.util.Stack;

public class oppgave2 {

	public static Stack<Integer> A;
	public static Stack<Integer> B;
	public static Stack<Integer> C;
	public static Integer en;
	public static Integer to;
	public static Integer tre; 

	public static void main(String[] args){
		A=new Stack<Integer>();
		B=new Stack<Integer>();
		C=new Stack<Integer>();

		en= 1;
		to= 2;
		tre= 3;

		A.push(tre);
		A.push(to);
		A.push(en);
		
		HannoisTaarn();
		System.out.println(B.toString());

	}
	
	public static void hanoi(int n,Stack<Integer> A, Stack<Integer>B, Stack<Integer> C){
		 if (n > 0){ 
		   hanoi(n-1, A, B, C); 
		   System.out.println("flytt %d --> %d\n", fra, til); 
		   hanoi(n-1, A, B, ); 
		   } 
		  
		 
		
		
		
		
	}
	
	
	

	public static void HannoisTaarn(){

		if(B.isEmpty()){
			B.push(A.pop());//a

		}else if(C.isEmpty()){
			C.push(A.pop());//a

		}else if(A.isEmpty()){
			A.push(C.pop());//c

		}else if(B.peek()<C.peek()){
			C.push(B.pop());//b

		}else if(C.peek()<B.peek()){
			B.push(C.pop());//c

		}else if(A.peek()<B.peek()){
			B.push(A.pop());//a
		}
		
		HannoisTaarn();
		
		
		
	}



}




