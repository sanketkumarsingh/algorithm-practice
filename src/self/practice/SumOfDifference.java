package self.practice;

import java.util.Scanner;

public class SumOfDifference {

	private static int totalSum = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		for(int i=1;i<=n;i++){
			int temp[] = new int[i];
			combination(arr, i , 0, 0 , temp);
			//System.out.println(combination(arr, i , 0, 0 , temp));
		}
		System.out.println("Sum:" + totalSum);
	}

	private static int combination(int[] arr, int size, int startIndex, int count , int temp[]) {
		
		if(count == size){
			
			for(int i=0;i<temp.length;i++){
				System.out.print(temp[i]+" ");
			}
			System.out.println();
			//System.out.println("Sum for :" + (temp[temp.length-1] - temp[0]));
			//totalSum = totalSum + (temp[temp.length-1] - temp[0]);
			return (temp[temp.length-1] - temp[0]);
		}
		
		for(int i=startIndex;i<arr.length;i++){
			temp[count] = arr[i];
			int sum = combination(arr, size, i+1, count+1, temp);
			if(count+1 == size){
				totalSum = totalSum + sum;
				//System.out.println("Sum inside:" + totalSum);
			}
		}
		
		return totalSum;
	}
	
}
