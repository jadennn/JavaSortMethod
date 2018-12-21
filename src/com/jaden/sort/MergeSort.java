package com.jaden.sort;

/*
 * �鲢����
 * ˼�룺���������м��ֳ�2�����飬Ȼ���ٷֱ�2��������Ϊ4�����飬���εݹ飬��ô���Ὣԭ������Ϊһ����Ԫ��
 *     1��Ԫ�ص�������Կ������������飬Ȼ��ֱ����������������鰴˳��ϲ����ϲ����������Ȼ������ģ�Ȼ�����εݹ飬ÿ�ζ����Կ�����������������ĺϲ�
 *     ��������ĺϲ������õ�ʱ�临���Ӷ���O(n)
 *     �ݹ鵽���պͲ���ɣ��õ����µ���������������
 *     �鲢���򣬿��Կ����Ƿָ�ͺϲ��ĵݹ飬ע�⴦��ø��߽��߼�
 * ʱ�临�Ӷȣ�O(nlgn)
 * �ռ临�Ӷȣ�O(n)
 */
public class MergeSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		if(size < 2) {
			return src;
		}
		slice(src, 0, size-1);
		
		return src;
	}
	
	/*
	 * �ָ����С��λ
	 */
	private void slice(int[] src, int start, int end) {
		int middle = (end + start) / 2;
		if(end - start  > 0) {
			slice(src, start, middle);
			slice(src, middle+1, end);
			merge(src, start, middle, end);
		}
		
	}
	
	/*
	 * �ϲ���������
	 */
	private void merge(int[] src, int start, int middle, int end) {
		int[] tmp = new int[end - start + 1];
		int p1 = start;  //ָ���һ��˳������ĵ�λ
		int p2 = middle + 1; //ָ��ڶ���˳������ĵ�λ
		for(int i=0; i<end-start+1; i++) {
			if(p1 <= middle && p2 <= end) {
				if(src[p1] < src[p2]) {
					tmp[i] = src[p1];
					p1++;
				}else {
					tmp[i] = src[p2];
					p2++;
				}
			}else if(p1 > middle) { //���ϴ������������һ������ȫ���ϲ��ֱ꣬�ӽ�ʣ��ĵڶ�������ϲ�
				tmp[i] = src[p2];
				p2++;
			}else if(p2 > end) { //���ϴ�����������ڶ�������ȫ���ϲ��ֱ꣬�ӽ�ʣ��ĵ�һ������ϲ�
				tmp[i] = src[p1];
				p1++;
			}
		}
		//����ʱ�����ֵ��ص�src��
		for(int i=start; i<end+1; i++) {
			src[i] = tmp[i-start];
		}
	}

}
