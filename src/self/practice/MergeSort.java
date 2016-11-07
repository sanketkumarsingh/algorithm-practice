package self.practice;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = new int[] { 4, 1, 5, 2, 7, 1, 9 };
		int n = 7;
		arr = mergeSort(arr, 0, n - 1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}

	private static int[] mergeSort(int[] arr, int startIndex, int lastIndex) {

		int mergedArray[] = null;
		if (startIndex != lastIndex) {
			int midIndex = (startIndex + lastIndex) / 2;
			mergeSort(arr, startIndex, midIndex);
			mergeSort(arr, midIndex + 1, lastIndex);
			mergedArray = merge(arr, startIndex, midIndex, lastIndex);

		}
		return mergedArray;
	}

	private static int[] merge(int[] arr, int startIndex, int midIndex, int lastIndex) {

		int arrL[] = new int[midIndex - startIndex + 1];
		int arrR[] = new int[lastIndex - midIndex ];
		int lIndex = 0;
		int rIndex = 0;
		for (int i = startIndex; i <= midIndex; i++) {
			arrL[lIndex] = arr[i];
			lIndex++;
		}
		for (int i = midIndex + 1; i <= lastIndex; i++) {
			arrR[rIndex] = arr[i];
			rIndex++;
		}
		int i = 0;
		int j = 0;
		int k = startIndex;
		while (i < lIndex && j < rIndex) {
			if (arrL[i] < arrR[j]) {
				arr[k] = arrL[i];
				i++;
			} else {
				arr[k] = arrR[j];
				j++;
			}
			k++;
		}

		while (i < lIndex) {
			arr[k] = arrL[i];
			i++;
			k++;
		}

		while (j < rIndex) {
			arr[k] = arrR[j];
			j++;
			k++;
		}

		return arr;
	}
	
//
//	private static void heapify(int[] arr, int startIndex, int endIndex) {
//		int currentIndex = endIndex;
//		while(currentIndex >= startIndex){
//			int pIndex = (currentIndex-1)/2;
//			if(pIndex >= startIndex){
//				if(arr[pIndex] < arr[currentIndex]){
//					int temp = arr[currentIndex];
//					arr[currentIndex] = arr[pIndex];
//					arr[pIndex] = temp;
//					int lcIndex = 2* currentIndex +1;
//					int rcIndex = 2* currentIndex +2;
//					if(lcIndex <= endIndex && rcIndex <= endIndex){
//						
//					}
//					int index = currentIndex;
//					while(cIndex <= endIndex && arr[index] < arr[cIndex]){
//						temp = arr[cIndex];
//						arr[cIndex] = arr[index];
//						arr[index] = temp;
//						index = cIndex;
//						cIndex = 2*cIndex + 1;
//					}
//				}
//			}
//			currentIndex = currentIndex - 1;
//		}
//		
//	}

}
