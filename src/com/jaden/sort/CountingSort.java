package com.jaden.sort;

/*
 * ��������
 * ˼�룺����������ȫ����������������������������ֵ��100����ô�����½�һ������newAry�����������101�����ֱ��Ӧ��Ӧ0-100��������������������Ӧ��ֵ��ʼ��Ϊ0������һ��������һ�Σ���ô��Ӧ������ֵ��1��
 *     �磺������һ��50����ô������newAry[50]=0+1=1������ٴγ���50����ônewAry[50]=1+1=2�� ����ԭ���飬�����е�ֵӳ�䵽�µ������С�
 *     ��ô���newAry��ֵ����0���±꣬��Ӧ����ԭ�����ֵ��newAry��ֵ����Ӧ����ԭ�����и�ֵ���ֵĴ�����
 *     ��󣬱���newAry��������Ĺ��򣬽���������
 * ʱ�临�Ӷȣ�O(n+k)
 * �ռ临�Ӷȣ�O(n+k)
 */
public class CountingSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		int max = findMax(src);
		
		int []countAry = new int[max + 1];
		//ͳ��ÿ��ֵ���ֵĴ���
		for(int i=0; i<size; i++) {
			countAry[src[i]]++;
		}
		
		//��ÿ��ֵ��С�������src����
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

}
