package com.jaden.sort;

/*
 * 计数排序
 * 思想：适用于数组全部是正整数的情况，假如数据最大值是100，那么可以新建一个数组newAry，数组个数是101个，分别对应对应0-100的索引，将所有索引对应的值初始化为0，假如一个数出现一次，那么对应索引的值加1，
 *     如：出现了一次50，那么新数组newAry[50]=0+1=1，如果再次出现50，那么newAry[50]=1+1=2， 遍历原数组，将所有的值映射到新的数组中。
 *     那么最后，newAry中值大于0的下标，对应的是原数组的值，newAry的值，对应的是原数组中该值出现的次数。
 *     最后，遍历newAry，以上面的规则，将数组排序
 * 时间复杂度：O(n+k)
 * 空间复杂度：O(n+k)
 */
public class CountingSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		int max = findMax(src);
		
		int []countAry = new int[max + 1];
		//统计每个值出现的次数
		for(int i=0; i<size; i++) {
			countAry[src[i]]++;
		}
		
		//将每个值从小到大赋予给src数组
		int size2 = countAry.length;
		int index = 0;
		for(int i=0; i<size2; i++) {
			for(int j=0; j<countAry[i]; j++) {
				src[index++] = i;
			}
		}
		return src;
	}
	
	
	/*
	 * 找出数组中的最大值
	 */
	private int findMax(int[] src) {
		int size = src.length;
		int maxIndex = 0;
		for(int i=0; i<size; i++) {
			if(src[maxIndex] < src[i]) {
				maxIndex = i;
			}
		}
		return src[maxIndex];
	}

}
