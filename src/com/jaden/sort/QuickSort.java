package com.jaden.sort;

/*
 * 快速排序
 * 思想：取第一个元素做为基准值，把比他大的放到右边，把比他小的放到左边，第一次循环完成，那么左边都是比他小的，右边都是比他大的，那么，这个值在最终排序完成的数组中的位置将不会改变
 *     那么新的数据可以分成三个部分：所有比他小的左边数组（未排序）上一个基准值，所有比他大的右边数组（未排序），用递归的思想，左边的数组可以按上面的算法来排序基准值，右边的数组同理也可以得到基准值
 *     这一次循环完毕，那么就得到了：未排序-基准左边-未排序-基准1-未排序-基准右边-未排序。然后再次递归，直至把所有的基准值的位置选对，那么整个数组就排序好了。。
 *     注意各个边界值的处理
 * 时间复杂度：O(nlgn)
 * 空间复杂度：O(nlgn)
 */
public class QuickSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		if(size < 2) {
			return src;
		}
		int left = 0;
		int right = size - 1;
		quickSort(src, left, right);
		return src;
	}
	
	private void quickSort(int[] src, int left, int right) {
		if(right - left > 0) {
			int p = left + 1;
			int level = src[left];
			for(int i=left+1; i<=right; i++) {
				if(src[i] < level) {
					swip(src, p, i);
					p++;
				}
			}
			swip(src, p-1, left);
			//左边递归
			quickSort(src, left, p-2);
			//右边递归
			quickSort(src, p, right);
		}
	}
	
	private void swip(int[] src, int x, int y) {
		int tmp = src[x];
		src[x] = src[y];
		src[y] = tmp;
	}

}
