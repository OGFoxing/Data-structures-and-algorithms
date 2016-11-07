package kz.ogfox.binarysearch;
/*Binary search is inefficient use the cache memory of the processor 
 - access to the array elements inconsistent (jumping over the array)*/
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len;
		int A[];
		int key;
		
		System.out.println("Input count of elements in array :");
		Scanner scan = new Scanner(System.in);
		len = (int)(scan.nextInt());
		A = new int [len];
		
		/*generate ordered array*/
		for(int i = 0; i < len; i++) {
			A[i] =  i *10;
			System.out.print(A[i] + " ");
		}
		
		System.out.println("\nKey of element :");
		Scanner scan1 = new Scanner(System.in);
		key = (int)(scan1.nextInt());
		binary_Search(A,len,key);
		System.out.println("Index of element");
		System.out.println(binary_Search(A,len,key));
	}
	
	private static int binary_Search(int[] A, int len, int key) {

		int mid;
		int left = 1;
		int right = len;
		while (left <= right) {
			mid = (left + right) / 2;
			if (A[mid] == key) 
				return mid;
			else if (key > A[mid]) 
				left = mid + 1;
			else 
				right = mid - 1;
		}
		return -1;
	}

}
