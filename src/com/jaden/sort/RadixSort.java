package com.jaden.sort;

import java.util.ArrayList;

/*
 * 基数排序
 * 思想：适用于正整数的排序，先找出整个数组中的最大值，然后再判断该值一共有多少位，假如是5位数，那么从个位开始，遍历整个数组，将整个数组分成10个部分，个位数为0的存到第一个部分，个位数为1的存在第二个部分，以此类推
 *     第一次循环完成，然后从第1部分到第10部分（也就是从个位数为0到个位数为9）依次给数组赋值，新的数组就是按个位数排序的数组了。然后开始第二次循环，从十位开始，还是一样，将十位数的数值分成十个部分，然后再生成新的数组
 *     然后是百位，千位，万位依次重复，那么最后得到的数组就排好序了
 *     仔细思考，假如我们要比较两个数的大小，那么先看最高位，如果最高位一样，那么看次高位，。。。依次向下，直到个位，那么就能区分两个值的大小了，这也是基数排序的思想
 * 时间复杂度：O(n*k)
 * 空间复杂度：O(n+k)
 */
public class RadixSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		
		//初始化list，用来存储每次比较后的临时变量，因为list可以动态增加
		ArrayList<ArrayList<Integer>> tmpList = new ArrayList<>(10);
		for(int i=0; i<10; i++) {
			tmpList.add(new ArrayList<>());
		}
		
		int size = src.length;
		int max = findMax(src);
		int maxDigit = getDigit(max); //最大位数
		int index;
		
		for(int digit=1; digit <=maxDigit; digit++) {
			for(int i=0; i<size; i++) {
				tmpList.get(src[i] % (int)Math.pow(10, digit) / (int)Math.pow(10, digit-1)).add(src[i]); //分别存储在0-9的list中
			}
			index = 0;
			for(int i=0; i<10; i++) {
				for(int x : tmpList.get(i)) {
					src[index++] = x; //每次排序完成后把数组改序
				}
				tmpList.get(i).clear(); //清除ArrayList
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
	
	/*
	 * 获取一个整数的位数
	 */
	private int getDigit(int a) {
		if(a < 0) {
			return 0;
		}
		int digit = 0;
		int c = a;
		do {
			c = c / 10;
			digit++;
		}while(c > 0);
		
		return digit;
	}

}
