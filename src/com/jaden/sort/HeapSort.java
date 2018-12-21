package com.jaden.sort;

/*
 * ������
 * ˼�룺�ѣ���һ����ȫ�������ṹ�������鲻ͬ�������±��Ǵ�1��ʼ����ô���һ�����ڵ�������Ǹ���index = n/2����������Ҷ����index*2��index*2+1���������ȫ�����������ԣ�
 * 	           �����ԭ���ǣ������һ�����ڵ㿪ʼ���Ƚϸø��ڵ����������ҽڵ�ֵ�Ĵ�С�����˭����ô���ýڵ�ֵ����Ϊ����ֵ��
 *     �����һ�����ڵ�����һ���ڵ����α�������һ��������ɣ���ô����ֵ�϶�λ�ڵ�һ���ڵ�Ҳ����array[0]������ֵ���������һ��ֵ��������ô����ֵ�ŵ�����ˣ�
 *     ��һ��������ɣ��Ѿ������Ԫ�������1����Ϊ�˷�����⣬�����һ��ֵ�������Ƴ�����ô�µ������ͱ�֮ǰ����һ��Ԫ�ء�
 *     �ڶ��Σ���Ȼ��������Ĺ�����������������ɣ��ҵ������������ֵ��Ҳ����ԭ����ĵڶ���ֵ���ŵ���һ�ε����ֵǰ�棬ͬ������Ƴ���Ԫ�أ��µ���������һ��Ԫ��
 *     �����ȥ��ÿ�α��������ҵ���ǰ���е����ֵ��������ɺ�˳��Ҳ���������
 * ʱ�临�Ӷȣ�O(nlgn)
 * �ռ临�Ӷȣ�O(1)
 */
public class HeapSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		int unsortSize = size;
		for(int i=unsortSize; i>0; i--) {
			for(int j=i/2; j>0; j--) {
				heapUp(src, j, i);
			}
			swip(src, 0, i-1);
		}
		return src;
	}
	
	/*
	 * ���ϸ�����һ�����ڵ�����������Ҷ�ӣ���������ڣ��Աȣ�������ֵ������н���
	 */
	private void heapUp(int[] src, int index, int unsortSize) {
		int max = index - 1;
		int right  = index*2; 
		int left = index*2 - 1;
		if(right < unsortSize && src[max] < src[right]) {
			max = right;
		}
		if(left < unsortSize && src[max] < src[left]) {
			max = left;
		}
		swip(src, index - 1, max);
	}
	
	
	private void swip(int[] src, int x, int y) {
		int tmp = src[x];
		src[x] = src[y];
		src[y] = tmp;
	}

}
