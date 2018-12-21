package com.jaden.sort;


public class Main {
	
	public static void main(String[] args) {
		int count = 500000;
		int[] src = createRandomAry(count);
		System.out.println("Array count = " + count );
		//printAry(src);
		System.out.println("-------------------------------------------------");
		for(int i=Sort.BUBBLE_SORT; i<=Sort.RADIX_SORT; i++) {
			int[] tmp = copyAry(src);
			Sort sort = SortFactory.createSort(i);
			long begin = System.currentTimeMillis();
			int []dest = sort.sort(tmp);
			long after = System.currentTimeMillis();
			//printAry(dest);
			formatPrint(sort, after-begin);
		}
	}
	
	/*
	 * 创建乱序数组
	 */
	private static int[] createRandomAry(int count) {
		int []ary = new int[count];
		for(int i=0; i<count; i++) {
			ary[i] = (int)(Math.random() * count * 100);
		}
		return ary;
	}
	
	/*
	 * 打印数组
	 */
	private static void printAry(int []ary) {
		for(int i : ary) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println("");
	}
	
	private static String  getClassName(Class classex) {
		return classex.getName();
	}
	
	private static void formatPrint(Sort sort, long spend) {
		String name = getClassName(sort.getClass());
		System.out.println(name + "  |  spend = " + spend + "ms");
	}
	
	
	/*
	 * 复制数组，确保各种排序用到的数组是同一个
	 */
	private static int[] copyAry(int[] src) {
		int size = src.length;
		int[] dest = new int[size];
		for(int i=0; i<size; i++) {
			dest[i] = src[i];
		}
		return dest;
	}
	
}
