package self.practice;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SubArraySum {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<Result> answer = new ArrayList<Result>();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
		   answer.add(getResult(n,s,arr));
		}
		for(Result result: answer){
			if(result.getLastIndex() == 0 && result.getStartIndex() == 0){
				System.out.println("-1");
			}else{
			System.out.println(result.getStartIndex() + " " + result.getLastIndex());
			}
			//System.out.println();
		}
	}

	private static Result getResult(int n, int s, int[] arr) {
		Result result = new Result();
		for(int i=0;i<n;i++){
			int currSum = 0;
			for(int j=i ; j<n;j++){
				currSum = currSum + arr[j];
				if(currSum == s){
					
					result.setStartIndex(i+1);
					result.setLastIndex(j+1);
					return result;
				}
			}
		}
		
		return result;
	}
}

class Result{
	int startIndex;
	int lastIndex;
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getLastIndex() {
		return lastIndex;
	}
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	
}