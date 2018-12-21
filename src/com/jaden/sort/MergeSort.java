package com.jaden.sort;

/*
 * 归并排序
 * 思想：将数组由中间拆分成2个数组，然后再分别将2个数组拆分为4个数组，依次递归，那么最后会将原数组拆分为一个个元素
 *     1个元素的数组可以看成是有序数组，然后分别将两个相邻有序数组按顺序合并，合并完的数组仍然是有序的，然后依次递归，每次都可以看成是两个有序数组的合并
 *     有序数组的合并，所用的时间复复杂度是O(n)
 *     递归到最终和并完成，得到的新的数组就是有序的了
 *     归并排序，可以看成是分割和合并的递归，注意处理好各边界逻辑
 * 时间复杂度：O(nlgn)
 * 空间复杂度：O(n)
 */
public class MergeSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		if(size < 2) {
			return src;
		}
		slice(src, 0, size-1);
		
		return src;
	}
	
	/*
	 * 分割成最小单位
	 */
	private void slice(int[] src, int start, int end) {
		int middle = (end + start) / 2;
		if(end - start  > 0) {
			slice(src, start, middle);
			slice(src, middle+1, end);
			merge(src, start, middle, end);
		}
		
	}
	
	/*
	 * 合并有序数组
	 */
	private void merge(int[] src, int start, int middle, int end) {
		int[] tmp = new int[end - start + 1];
		int p1 = start;  //指向第一段顺序数组的低位
		int p2 = middle + 1; //指向第二段顺序数组的低位
		for(int i=0; i<end-start+1; i++) {
			if(p1 <= middle && p2 <= end) {
				if(src[p1] < src[p2]) {
					tmp[i] = src[p1];
					p1++;
				}else {
					tmp[i] = src[p2];
					p2++;
				}
			}else if(p1 > middle) { //符合此条件，代表第一段数组全部合并完，直接将剩余的第二段数组合并
				tmp[i] = src[p2];
				p2++;
			}else if(p2 > end) { //符合此条件，代表第二段数组全部合并完，直接将剩余的第一段数组合并
				tmp[i] = src[p1];
				p1++;
			}
		}
		//将临时数组的值存回到src中
		for(int i=start; i<end+1; i++) {
			src[i] = tmp[i-start];
		}
	}

}
