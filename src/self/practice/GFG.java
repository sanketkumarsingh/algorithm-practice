package self.practice;

import java.util.*;
import java.util.Map.Entry;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Map<Integer, int[]> ans= new HashMap<Integer, int[]>();
		for(int i=0;i<t;i++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int j=0;j<n;j++){
		        arr[j] = sc.nextInt();
		    }
		  arr = getMinMaxList(n, arr);
		  ans.put(i,arr);
		}
	Iterator<?> it =	ans.entrySet().iterator();
	while(it.hasNext()){
	   @SuppressWarnings("rawtypes")
	Map.Entry entry =  (Entry) it.next();
	   int arr[] = (int[])entry.getValue();
	   for(int i = 0 ;i <arr.length ;i++){
	   	if(i == arr.length-1){
	       System.out.print(arr[i]);
	   }
	   else{
	       	System.out.print(arr[i]+" ");
	       }
	   }
	   System.out.println("");
	}
	}
	
	private static int[] getMinMaxList(int n, int arr[]){
		if ( n ==1){
			return arr;
		}
		
		boolean isEven = false;
	   	if(n%2 == 0){
	   		isEven = true;
	   	}
	   	int count = 0;
	   	int index = 0;
	   	int temp1= arr[index];
	   	int temp2 =0;
	   	if(n==2){
			temp2 = arr[0];
			arr[0] = arr[1];
			arr[1] = temp2;
			return arr;
		}
	   	temp2 = 0;
	   	while(count != n){
	   		if(isEven){
	   			int indexToReplace = 0;
	   			if(index <= ((n/2)-1)){
	   				 indexToReplace = 2*index + 1;
	   			}else{
	   				 indexToReplace = 2*(n-index-1);
	   			}
	   			temp2 = arr[indexToReplace];
   				arr[indexToReplace] = temp1;
   				index = indexToReplace;
   				temp1 = temp2;
   				count = count+1;
	   		}else{
	   			int indexToReplace = 0;
	   			if(index < (n/2)){
	   				 indexToReplace = 2*index + 1;
	   			}else if(index > (n/2)){
	   				 indexToReplace = 2*(n-index-1);
	   			}else{
	   				indexToReplace = n-1;
	   			}
	   			temp2 = arr[indexToReplace];
   				arr[indexToReplace] = temp1;
   				index = indexToReplace;
   				temp1 = temp2;
   				count = count+1;
	   		}
	   	}

	   	return arr;
	}
	
}