package self.practice;

public class RadixSort {
	public static void main(String[] args) {
		int arr[] = new int[] { 41, 1, 894, 2, 70, 1, 9 }; //only positive numbers
		int n = 7;
		int d = 3;
		arr=radixSort(arr, n, d);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		//System.out.println((-989 / 10));
		
	}

	private static int [] radixSort(int[] arr, int n, int d) {
		
		int k = 1;
		int output[] = new int[n];
		while(k<=d){
//			int max =Integer.MIN_VALUE;
//			int min = Integer.MAX_VALUE;
			int count[] = new int[10];
			for(int i=0;i<n;i++){
				int num = arr[i];
				int j=0;
				int digit = num;
				while(j<k){
					digit = num%10;
					num = num /10;
					j++;
				}
				++count[digit];
				
			}
			for(int i=0;i<count.length-1;i++){
				count[i+1] = count[i]+count[i+1];
			//	System.out.print(count[i] + " ");
			}
			//System.out.println(count[count.length-1]);
			for(int i=n-1;i>=0;i--){
				int num = arr[i];
				int j=0;
				int digit = num;
				while(j<k){
					digit = num%10;
					num = num /10;
					j++;
				}
				
				output[count[digit]-1] = arr[i];
				count[digit]--;
			}
			arr= output;
			output = new int[n];
//			for(int i=0;i<arr.length;i++){
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
			k++;
		}
		return arr;
	}
}
