package com.leo.ordenacao;

import java.util.stream.IntStream;

public class AlgoritmosOrdenacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testeShell [] = {14,7,15,12,2,5,13,6,3,1,0,8,9,4,10,11};
		
		shellSort(testeShell);
		
		int [] actual = {5,1,6,2,3,4};
		int [] expected = {1,2,3,4,5,6};
		/*
		 * mergeSort(actual, actual.length); //assertArrayEquals(expected, actual); org.
		 */
	}

	
	public static int verificaOrdenacao(int n, int [] vetor) {
			
		if(n>0) {
			// se igual a 1 está ordenado // se = 0 vazio
		}
		return 0;
	}
	
	public static Integer [] insertionSort(Integer [] valores) { 
		for(int i = 1; i < valores.length; i++ ) {
			int a = valores[i];
			int j;
			for(j = 1; j >= 0 && valores[j] > a; j--) {
				valores[j + 1] = valores[j];
			}
			valores[j] = a;
		}
		
		return valores;
	
	}
	
	/* O método é invocado atraves de chamada estática passando a cópia da referência
	 * do vetor a ser ordenado como parametro e esse parametro  fazendo com que o objeto
	 * vetor seja ordenado, devido a serem referencias ao mesmo objeto, não é necessário
	 * retorno, pois na chamada do objeto, o mesmo já estará ordenado.
	 * Exemplo de chamada: int vetor = AlgoritmosOrdenacao.shellSort(vetor)
	 * */
	public static void shellSort(int [] valores) {
		int i, j, temp, size = valores.length;
		
		int incremento = 1;
		while(incremento < size) {
			incremento = 3 * incremento + 1;
		}
		
		while (incremento > 1) {
			incremento /= 3;
			
			for (i = incremento; i < size; i++) {
				temp = valores[i];
				j = i - incremento;
				while(j >= 0 && temp < valores[j]) {
					valores[j + incremento] = valores[j];
					j -= incremento;
				}
				valores[j + incremento] = temp;
			}
		}
	}
	
	/*Quicksort is a sorting algorithm, which is leveraging the divide-conquer principle. It has
	 * an average O(n log n) complexity and it's one of the most used sorting algorithms, especially for
	 * big data volumes
	 * */
	public static void quickSort(int vetor[], int inicio, int fim) {
		if(inicio < fim) {
			int partitionIndex = partition(vetor, inicio, fim);
			
			quickSort(vetor, inicio, partitionIndex);
			
			quickSort(vetor, partitionIndex + 1, fim);
		}
	}
	
	private static int partition(int vetor[], int inicio, int fim) {
		int pivot = vetor[fim];
		int i = (inicio - 1);
		
		for (int j = inicio; j < fim; j++) {
			if (vetor[j] <= pivot) {
				i++;
				
				int swapTemp = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = swapTemp;
			}
		}
		
		int swapTemp = vetor[i+1];
		vetor[i+1] = vetor[fim];
		vetor[fim] = swapTemp;
		return 0;
	}
	
	/*Mergesort algorithm
	 * The algorithm can be described as the following 2 steps process
	 * - Divide: In this step, we divide the input array into 2 halves,
	 * the pivot being the midpoint of the array. This step is carried
	 * out recursively for all the half arrays until there are no more
	 * half arrays to divide
	 * - Conquer: In this step, we sort and merge the divided arrays
	 * from bottom to top and get the sorted array
	 * */
	public static void mergeSort(int[] a , int n) {
		if (n< 2) {return;}
		int mid = n/2;
		int [] l = new int[mid];
		int [] r = new int[n - mid];
		
		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);
		
		merge(a, l, r, mid, n-mid);
	}
	
	public static void merge(int [] a, int [] l, int [] r, int left, int right) {
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if(l[i] <= r[j]) {
				a[k++] = l[i++];
			}else {
				a[k++] = r[j++];
			}
		}
		while(i < left) {
			a[k++] = l[i++];
		}
		while(j < right) {
			a[k++] = r[j++];
		}
	}
	
	/*Implementation sorting the array using Java 8 approach
	 * */
	public static void bubbleSort(Integer [] valores) {
		int n = valores.length;
		IntStream.range(0,  n-1).flatMap(i -> IntStream.range(1,  n-1)).forEach(j -> {
			if(valores[j-1] > valores[j]) {
				int temp = valores[j];
				valores[j] = valores[j-1];
				valores[j-1] = temp;
			}
		});

	}
	
	public void optimizedBubbleSort(Integer [] valores) {
		int i = 0, n = valores.length;
		boolean swapNeeded = true;
		while (i<n-1 && swapNeeded) {
			swapNeeded = false;
			for (int j = 1; j < n - 1; j++) {
				if(valores[j - 1] > valores[j]) {
					int temp = valores [j -1];
					valores[j-1] = valores[j];
					valores[j] = temp;
					swapNeeded = true;
				}
			}
			if(!swapNeeded) {
				break;
			}
			i++;
		}
	}
	
}

















