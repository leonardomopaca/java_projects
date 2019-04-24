package com.leo.ordenacao;

import java.util.Arrays;

public class RadixSort {

	//A utility function to get maximum value in array[]
	static int getMax(int array[], int n) {
		int mx = array[0];
		for (int i = 1; i < n; i++) {
			if(array[i] > mx)
				mx = array[i];
		}
		return mx;
	}
	
	//A function to do counting sort of array[] according to
	//the digit represented by exp.
	static void countSort(int array[], int n, int exp) {
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		
		// Store count of occurrences in count[]
		for (i = 0; i < n; i++) {
			count[(array[i]/exp)%10]++;
		}
		
		//Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		
		//Build the output array
		for(i = n - 1; i >= 0; i--) {
			output[count[(array[i]/exp)%10] - 1] = array[i];
			count[(array[i]/exp)%10]--;
		}
		
		//Copy the output array to array[], so that array[] not
		//Contains sorted numbers according to current digit
		for(i =0; i<n; i++)
			array[i] = output[i];
	}
	
	//The main function to that sorts array[] of size n using
	//Radix Sort
	static void radixsort(int array[], int n) {
		// Find the maximum number to know number of digits
		int m = getMax(array, n);
		// Do counting sort for every digit. Note that instead
		// of passing digit number, exp is passed. exp is 10^i
		// where i is current digit number
		for ( int exp = 1; m/exp > 0; exp *= 10)
			countSort(array, n, exp);
	}
	
	//A utility function to print an array
	static void print(int array[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(array[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int array[] = {170, 45, 75, 90, 802, 24, 2, 66};
		int n = array.length;
		radixsort(array, n);
		print(array, n);
	}

}
