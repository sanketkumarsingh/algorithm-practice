package self.practice;

public class BinarySearch {

	public static void main(String[] args) {
		
	 int arr[] = new int[] {1,2,3,4,5,6};	
	 int n = 6;
	 int m = 0;
	  int index = 	binarySearch( arr, 0,  n-1,  m );
	  System.out.println(index);
	}

	private static int binarySearch(int[] arr, int startIndex, int lastIndex, int m) {
		if(startIndex > lastIndex){
			return -1;
		}
		int midIndex = (startIndex + lastIndex)/2;
		if(m ==  arr[midIndex]){
			return midIndex;
		}
		if(m >  arr[midIndex]){
			startIndex = midIndex+1;
		}
		if(m <  arr[midIndex]){
			lastIndex = midIndex -1;
		}
		return binarySearch(arr, startIndex, lastIndex, m);
	}
	
}
