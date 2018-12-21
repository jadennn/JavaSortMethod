package com.jaden.sort;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Ͱ����
 * ˼�룺������ֳ����ɸ����ݷ�Χ��Ͱ�������磬һ��������СֵΪ0�����ֵΪ100���ٶ���10��Ͱ����ô����0-10��Ϊһ��Ͱ��10-20Ϊ�ڶ���Ͱ�� �������ơ����ݷ�Χ�����ݷ����Ӧ��Ͱ��
 *     ��ô����ǰ����ǰ��Ͱ��ֵ�϶���С�ں���Ͱ��ֵ��ֻҪ��ÿ��Ͱ�ڲ�������������ɣ���ô�ٴӵ�һ��Ͱ�����һ��Ͱ������ȡ���ݣ���ô�µ�����˳������鼴���кõ�����
 *     Ͱ�ڵ����������ѡ�����ǵ�Ͱ�ڵ�Ԫ�ظ������Ƕ�����ֱ�Ӳ���ArrayList���д洢������Collections������������ֻ��Ϊ��˵��Ͱ�����˼��
 * ʱ�临�Ӷȣ�O(n+k)
 * �ռ临�Ӷȣ�O(n+k)
 */
public class BucketSort implements Sort {
	int BucketCount = 10; //����ʮ��Ͱ
	int maxIndex = 0;
	int minIndex = 0;

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		findMaxAndMin(src);
		int min = src[minIndex];
		int max = src[maxIndex];
		//����ÿ��Ͱ�ķ�Χ
		int perCount = (int)Math.ceil(1.0f * (max - min + 1) / BucketCount);
		
		//��ʼ��ArrayList����Ϊ����Զ�̬���ӣ�Ŀǰ����֪��ÿ��Ͱ�Ĵ�С
		ArrayList<ArrayList<Integer>> bucket  = new ArrayList<>(BucketCount);
		for(int i=0; i<BucketCount; i++) {
			bucket.add(new ArrayList<Integer>());
		}
		//ͨ��ÿ��ֵ�ķ�Χ����ֵ���뵽��Ӧ��Ͱ����
		for(int i=0; i<size; i++) {
			bucket.get((src[i] - min) / perCount).add(src[i]);
		}
		
		//��ÿ��Ͱ��������
	    for(int i = 0; i < BucketCount; i++){
	        Collections.sort(bucket.get(i));
	    }
	    
	    //������ɣ���˳��ȡ��ÿ��Ͱ��ֵ
	    int index = 0;
	    for(int i=0; i<BucketCount; i++) {
	    	for(int x : bucket.get(i)) {
	    		src[index++] = x;
	    	}
	    }
	    
	    return src;
	}
	
	
	/*
	 * �ҳ������е����ֵ,��Сֵ
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
