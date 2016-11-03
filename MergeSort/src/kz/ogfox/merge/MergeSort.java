package kz.ogfox.merge;

import java.util.Scanner;

public class MergeSort {
	private static int[] mergeSort(int[] a) {
			if(a.length == 1)
				return a;
			else 
			{
				/*find half of array -> array/2*/	
				int n = (int)Math.floor(a.length/2);
				/*array division on 2 sides*/
				int b[] = new int [n];
				int c[] = new int [a.length -n];
				for(int i=0; i < a.length; i++) {
					if (i < n) {
						b[i]=a[i];
					}
					else {
						c[i-n] = a[i];
					}
				}
				b = mergeSort(b);
				c = mergeSort(c);
				a = Merge(b,c);
			return a;	
			}		
}


	private static int[] Merge(int[] a, int[] b) {
			int c [] = new int [a.length + b.length];
			int a1 = 0,b1 = 0;
			for(int i=0; i < a.length + b.length ; i++) {
				if(a1 == a.length) {
					c[i] = b [b1];
					++b1;
				}
				else 
					if(b1 == b.length) {
						c[i] = a[a1];
						++a1;
					}
				else
					if(a[a1] > b[b1]) {
						c[i] = b[b1];
						++b1;
					}
				else
					{
						c[i] = a[a1];
						++a1;
					}
			}
			return c;	
}
		
	public void start() {
		int lenght;
		Scanner scan = new Scanner(System.in);
		lenght = scan.nextInt();
		int a[]; 
		a = new int [lenght];
		long startTime = System.currentTimeMillis();
		System.out.println("Not ordered array:");
		for(int i=0; i < lenght; i++) {
			a[i] = (int)(Math.random()*100);
			System.out.print(a[i] + " ");
		}
		
		a = mergeSort(a);
		
		System.out.println();
		System.out.println("Ordered array");
		for(int i=0 ; i < lenght; i++) {
			System.out.print(a[i] + " ");
		}	
		Check(a, lenght);
		long endTime = System.currentTimeMillis();		
		System.out.println("\nAverage time :" +  (endTime - startTime) + "ms");
	}
	
	public static void Check(int[] A, int len) {
		for(int i=0; i < len - 1; i++) {
			if (A[i] > A[i+1]) {
				System.out.println("Some one of elemnts not consist by rule");	
			}
		}
	}
	 
}
