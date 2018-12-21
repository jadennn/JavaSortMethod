package com.jaden.sort;

/*
 * 工厂类，用来创建各种排序算法
 * 
 */
public class SortFactory {
	public static Sort createSort(int type) {
		switch (type) {
		case Sort.BUBBLE_SORT:
			return new BubbleSort();
		case Sort.SELECTION_SORT:
			return new SelectionSort();
		case Sort.INSERTION_SORT:
			return new InsertionSort();
		case Sort.SHELL_SORT:
			return new ShellSort();
		case Sort.MERGE_SORT:
			return new MergeSort();
		case Sort.QUICK_SORT:
			return new QuickSort();
		case Sort.HEAP_SORT:
			return new HeapSort();
		case Sort.COUNTING_SORT:
			return new CountingSort();
		case Sort.BUCKET_SORT:
			return new BucketSort();
		case Sort.RADIX_SORT:
			return new RadixSort();
		default:
			return new BubbleSort();
		}
	}
}
