package testCases;

import java.util.Arrays;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 249, 10, 6, 8, 5, 3 };
		System.out.println("before sorting" + Arrays.toString(a));
		int n = a.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1]) {

					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		System.out.println("before sorting" + Arrays.toString(a));

	}
}
