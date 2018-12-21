package com.jaden.sort;


/*
 * 选择排序
 * 思想：从index=0遍历数组，选择最小的元素，与第一个元素（index=0）交换，那么第一个元素即排好序的，
 *     然后从index=1遍历数组，再选择剩余数组最小元素，与第二个元素（index=1）交换，那么前两个也排好序了。
 *     然后从index=2开始。。。。
 *     不停遍历，最终能够得到一个排好序的数组
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 */
public class SelectionSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		int tmp, min;
		for(int i=0; i<size-1; i++) {
			min = i;
			for(int j=i+1; j<size; j++) {
				if(src[min] > src[j]) {
					min = j;
				}
			}
			//最小值，跟i交换
			tmp = src[i];
			src[i] = src[min];
			src[min] = tmp;
		}
		return src;
	}

}
