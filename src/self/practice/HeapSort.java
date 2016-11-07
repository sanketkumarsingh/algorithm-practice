package self.practice;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = new int[] { 4, 11, 5, 2, 7, 1, 9 };
		int n = 7;
		
		for(int i=0;i<n;i++){
			heapify(arr, 0, n - i-1,i);
			
			
		}
		for(int j=0;j<n;j++){
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}


	
	private static void heapify(int[] arr, int startIndex, int endIndex, int x) {
		int currentIndex = endIndex ;
		while(currentIndex >= startIndex){
			int pIndex = (currentIndex-1)/2;
			if(pIndex >= startIndex){
				if(arr[pIndex+x] < arr[currentIndex+x]){
					int temp = arr[currentIndex+x];
					arr[currentIndex+x] = arr[pIndex+x];
					arr[pIndex+x] = temp;
					int lcIndex = 2* currentIndex +1;
					int rcIndex = 2* currentIndex +2;
					int cIndex = rcIndex;
					if(lcIndex <= endIndex){
						cIndex = lcIndex;
					}
					if(lcIndex <= endIndex && rcIndex <= endIndex){
						if (arr[lcIndex+x] > arr[rcIndex+x]){
							cIndex = lcIndex;
						}else{
							cIndex = rcIndex;
						}
					}
					
					
					int index = currentIndex;
					while(cIndex <= endIndex && arr[index+x] < arr[cIndex+x]){
						temp = arr[cIndex+x];
						arr[cIndex+x] = arr[index+x];
						arr[index+x] = temp;
						index = cIndex;
						 lcIndex = 2* cIndex +1;
						 rcIndex = 2* cIndex +2;
						 cIndex = rcIndex;
						 if(lcIndex <= endIndex){
								cIndex = lcIndex;
							}
						if(lcIndex <= endIndex && rcIndex <= endIndex){
							if (arr[lcIndex+x] > arr[rcIndex+x]){
								cIndex = lcIndex;
							}else{
								cIndex = rcIndex;
							}
						}
						
						//cIndex = 2*cIndex + 1;
					}
				}
			}
			currentIndex = currentIndex - 1;
		}
		
	}
	
	
}
