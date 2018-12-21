package com.jaden.sort;

/*
 * 冒泡排序
 * 思想：每次比较相邻的两个元素，如果相邻元素顺序错误，那么则将其交换，第一次排序完成，最大的值位于数组的最后
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 */
public class BubbleSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		int tmp;
		for(int i=0; i<size-1; i++) {
			for(int j=0; j<size-i-1; j++) {
				//交换值，将最大值放到后面
				if(src[j] > src[j+1]) {
					tmp = src[j];
					src[j] = src[j+1];
					src[j+1] = tmp;
				}
			}
		}
		return src;
	}

}
