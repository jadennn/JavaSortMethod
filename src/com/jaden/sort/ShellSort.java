package com.jaden.sort;

/*
 * 希尔排序
 * 思想：按照某个步长对元素进行排序，假如步长为4，那么index=0，index=4，index=8.。。。的元素进行比较排序，index=1，index=5，index=9.。。。的元素进行比较排序，
 *     index=2，index=6，index=10.。。。的元素进行比较排序，index=3，index=7，index=11.。。。的元素进行比较排序
 *     第一次排序完成，减小步长，同理按照上面的规则进行排序
 *     确保最后一次的步长为1
 *     
 *     假如只进行一次一个步长为1的排序，那么就是插入排序了
 * 时间复杂度：O(n^(1.3—2))
 * 空间复杂度：O(1)
 */
public class ShellSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		int gap = 1;
		int interval = 3; //动态设置间隔
		int tmp, p;
		while (gap < size / interval) {
			gap = gap * interval + 1;
		}
		for(; gap>0; gap=gap/interval) {
			
			for(int i=gap; i<size; i++) {
				tmp = src[i];
				p = i - gap;
				while (p >= 0 && tmp < src[p] ) {
					src[p+gap] = src[p];
					p -= gap;
				}
				src[p+gap] = tmp;
			}
		}
		return src;
	}

}
