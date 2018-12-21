package com.jaden.sort;

/*
 * 排序算法的接口，必须实现sort
 */
public interface Sort {
	public static final int BUBBLE_SORT = 1; //冒泡
	public static final int SELECTION_SORT = 2; //选择
	public static final int INSERTION_SORT = 3; //插入
	public static final int SHELL_SORT = 4; //希尔
	public static final int MERGE_SORT = 5; //归并
	public static final int QUICK_SORT = 6; //快速
	public static final int HEAP_SORT = 7; //堆排序
	public static final int COUNTING_SORT = 8; //计数排序
	public static final int BUCKET_SORT = 9; //痛排序
	public static final int RADIX_SORT = 10; //基数排序
	
	int[] sort(int []src );
}
