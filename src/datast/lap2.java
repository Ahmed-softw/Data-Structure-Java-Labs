package datast;
public class lap2 {
public static int linearSearch(int[] arr, int target) {
for (int i = 0; i < arr.length; i++) {
if (arr[i] == target)
return i;
}
return -1;
} /////////////////////////////////////
public static int binarySearch(int[] arr, int target) {
int first = 0, last = arr.length - 1;
while (first <= last) {
int mid = (first + last) / 2;
if (target == arr[mid])
return mid;
if (target > arr[mid])
first = mid + 1;
last = mid - 1;
}
return -1;
}/////////////////////////////////////
public static void main(String args[]) {
int [] array = {5, 15, 75, 50, 45, 5};
System.out.println("Linear Search @ = " + linearSearch(array, 15) );
int [] arraySrtd = {5, 15, 25, 45, 50, 75};
System.out.println("Binary Search @ = " + binarySearch(arraySrtd, 45) );
}
static void bubbleSort(int arr[]) {
	int n = arr.length;
	 int i, j, temp;
	for (i = 0; i < n - 1; i++) {
		for (j = 0; j < n - 1; j++) {
			if ( arr[j] > arr[j+1]) {
				//SWAP arr[j] and arr[j+i]
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;				}
		}
	}
}
public static Integer[] toArray(Integer[] b) {
	// TODO Auto-generated method stub
	return null;
}

}