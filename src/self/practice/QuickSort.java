package self.practice;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = new int[] { 4, 1, 5, 2, 7, 1, 9 };
		int n = 7;
		quickSort(arr, 0, n - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int index = partition(arr, low, high);
			quickSort(arr, low, index - 1);
			quickSort(arr, index + 1, high);

		}
	}

	private static int partition(int[] arr, int low, int high) {
		
		int i = low-1;
		int pivot = arr[high];
		for(int j=low;j<=high-1;j++){
			if(arr[j] <= pivot ){
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		int temp  =  arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}

}
