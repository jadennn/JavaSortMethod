package com.jaden.sort;

/*
 * 堆排序
 * 思想：堆，是一个完全二叉树结构。与数组不同，假设下标是从1开始，那么最后一个根节点的索引是个数index = n/2，它的左右叶子是index*2和index*2+1（这个是完全二叉树的特性）
 * 	           排序的原理是，从最后一个根节点开始，比较该根节点与它的左右节点值的大小，如果谁大，那么将该节点值交换为最大的值。
 *     从最后一个根节点往第一个节点依次遍历，第一个遍历完成，那么最大的值肯定位于第一个节点也就是array[0]，将该值与数组最后一个值交换，那么最大的值放到最后了，
 *     第一次排序完成，已经排序的元素是最后1个。为了方便理解，将最后一个值从树中移除，那么新的树，就比之前少了一个元素。
 *     第二次，依然按照上面的规律来遍历，遍历完成，找到了新树的最大值，也就是原数组的第二大值，放到第一次的最大值前面，同理从树移除该元素，新的树又少了一个元素
 *     如此下去，每次遍历都能找到当前树中的最大值，遍历完成后，顺序也就排序好了
 * 时间复杂度：O(nlgn)
 * 空间复杂度：O(1)
 */
public class HeapSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		int unsortSize = size;
		for(int i=unsortSize; i>0; i--) {
			for(int j=i/2; j>0; j--) {
				heapUp(src, j, i);
			}
			swip(src, 0, i-1);
		}
		return src;
	}
	
	/*
	 * 堆上浮，从一个根节点与他的左右叶子（如果都存在）对比，将最大的值与根进行交换
	 */
	private void heapUp(int[] src, int index, int unsortSize) {
		int max = index - 1;
		int right  = index*2; 
		int left = index*2 - 1;
		if(right < unsortSize && src[max] < src[right]) {
			max = right;
		}
		if(left < unsortSize && src[max] < src[left]) {
			max = left;
		}
		swip(src, index - 1, max);
	}
	
	
	private void swip(int[] src, int x, int y) {
		int tmp = src[x];
		src[x] = src[y];
		src[y] = tmp;
	}

}
