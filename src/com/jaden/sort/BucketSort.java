package com.jaden.sort;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 桶排序
 * 思想：将数组分成若干个数据范围（桶），比如，一个数组最小值为0，最大值为100，假定有10个桶，那么数组0-10的为一个桶，10-20为第二个桶， 依次类推。根据范围将数据放入对应的桶。
 *     那么，从前到后，前面桶的值肯定都小于后面桶的值，只要把每个桶内部的数据排序完成，那么再从第一个桶到最后一个桶，依次取数据，那么新的数据顺序的数组即排列好的数组
 *     桶内的排序可以自选，考虑到桶内的元素个数不是定长，直接采用ArrayList进行存储，利用Collections进行排序，这里只是为了说明桶排序的思想
 * 时间复杂度：O(n+k)
 * 空间复杂度：O(n+k)
 */
public class BucketSort implements Sort {
	int BucketCount = 10; //定义十个桶
	int maxIndex = 0;
	int minIndex = 0;

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		findMaxAndMin(src);
		int min = src[minIndex];
		int max = src[maxIndex];
		//计算每个桶的范围
		int perCount = (int)Math.ceil(1.0f * (max - min + 1) / BucketCount);
		
		//初始化ArrayList，因为其可以动态增加，目前并不知道每个桶的大小
		ArrayList<ArrayList<Integer>> bucket  = new ArrayList<>(BucketCount);
		for(int i=0; i<BucketCount; i++) {
			bucket.add(new ArrayList<Integer>());
		}
		//通过每个值的范围，将值加入到对应的桶里面
		for(int i=0; i<size; i++) {
			bucket.get((src[i] - min) / perCount).add(src[i]);
		}
		
		//对每个桶进行排序
	    for(int i = 0; i < BucketCount; i++){
	        Collections.sort(bucket.get(i));
	    }
	    
	    //排序完成，按顺序取出每个桶的值
	    int index = 0;
	    for(int i=0; i<BucketCount; i++) {
	    	for(int x : bucket.get(i)) {
	    		src[index++] = x;
	    	}
	    }
	    
	    return src;
	}
	
	
	/*
	 * 找出数组中的最大值,最小值
	 */
	private void findMaxAndMin(int[] src) {
		int size = src.length;		
		for(int i=0; i<size; i++) {
			if(src[maxIndex] < src[i]) {
				maxIndex = i;
			}
			if(src[minIndex] > src[i]) {
				minIndex = i;
			}
		}
	}

}
