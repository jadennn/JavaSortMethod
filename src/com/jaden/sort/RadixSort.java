package com.jaden.sort;

import java.util.ArrayList;

/*
 * ��������
 * ˼�룺���������������������ҳ����������е����ֵ��Ȼ�����жϸ�ֵһ���ж���λ��������5λ������ô�Ӹ�λ��ʼ�������������飬����������ֳ�10�����֣���λ��Ϊ0�Ĵ浽��һ�����֣���λ��Ϊ1�Ĵ��ڵڶ������֣��Դ�����
 *     ��һ��ѭ����ɣ�Ȼ��ӵ�1���ֵ���10���֣�Ҳ���ǴӸ�λ��Ϊ0����λ��Ϊ9�����θ����鸳ֵ���µ�������ǰ���λ������������ˡ�Ȼ��ʼ�ڶ���ѭ������ʮλ��ʼ������һ������ʮλ������ֵ�ֳ�ʮ�����֣�Ȼ���������µ�����
 *     Ȼ���ǰ�λ��ǧλ����λ�����ظ�����ô���õ���������ź�����
 *     ��ϸ˼������������Ҫ�Ƚ��������Ĵ�С����ô�ȿ����λ��������λһ������ô���θ�λ���������������£�ֱ����λ����ô������������ֵ�Ĵ�С�ˣ���Ҳ�ǻ��������˼��
 * ʱ�临�Ӷȣ�O(n*k)
 * �ռ临�Ӷȣ�O(n+k)
 */
public class RadixSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		
		//��ʼ��list�������洢ÿ�αȽϺ����ʱ��������Ϊlist���Զ�̬����
		ArrayList<ArrayList<Integer>> tmpList = new ArrayList<>(10);
		for(int i=0; i<10; i++) {
			tmpList.add(new ArrayList<>());
		}
		
		int size = src.length;
		int max = findMax(src);
		int maxDigit = getDigit(max); //���λ��
		int index;
		
		for(int digit=1; digit <=maxDigit; digit++) {
			for(int i=0; i<size; i++) {
				tmpList.get(src[i] % (int)Math.pow(10, digit) / (int)Math.pow(10, digit-1)).add(src[i]); //�ֱ�洢��0-9��list��
			}
			index = 0;
			for(int i=0; i<10; i++) {
				for(int x : tmpList.get(i)) {
					src[index++] = x; //ÿ��������ɺ���������
				}
				tmpList.get(i).clear(); //���ArrayList
			}
	
		}
		
		return src;
	}
	
	
	
	/*
	 * �ҳ������е����ֵ
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
	 * ��ȡһ��������λ��
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
