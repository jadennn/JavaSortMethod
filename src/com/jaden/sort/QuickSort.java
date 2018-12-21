package com.jaden.sort;

/*
 * ��������
 * ˼�룺ȡ��һ��Ԫ����Ϊ��׼ֵ���ѱ�����ķŵ��ұߣ��ѱ���С�ķŵ���ߣ���һ��ѭ����ɣ���ô��߶��Ǳ���С�ģ��ұ߶��Ǳ�����ģ���ô�����ֵ������������ɵ������е�λ�ý�����ı�
 *     ��ô�µ����ݿ��Էֳ��������֣����б���С��������飨δ������һ����׼ֵ�����б�������ұ����飨δ���򣩣��õݹ��˼�룬��ߵ�������԰�������㷨�������׼ֵ���ұߵ�����ͬ��Ҳ���Եõ���׼ֵ
 *     ��һ��ѭ����ϣ���ô�͵õ��ˣ�δ����-��׼���-δ����-��׼1-δ����-��׼�ұ�-δ����Ȼ���ٴεݹ飬ֱ�������еĻ�׼ֵ��λ��ѡ�ԣ���ô���������������ˡ���
 *     ע������߽�ֵ�Ĵ���
 * ʱ�临�Ӷȣ�O(nlgn)
 * �ռ临�Ӷȣ�O(nlgn)
 */
public class QuickSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		if(size < 2) {
			return src;
		}
		int left = 0;
		int right = size - 1;
		quickSort(src, left, right);
		return src;
	}
	
	private void quickSort(int[] src, int left, int right) {
		if(right - left > 0) {
			int p = left + 1;
			int level = src[left];
			for(int i=left+1; i<=right; i++) {
				if(src[i] < level) {
					swip(src, p, i);
					p++;
				}
			}
			swip(src, p-1, left);
			//��ߵݹ�
			quickSort(src, left, p-2);
			//�ұߵݹ�
			quickSort(src, p, right);
		}
	}
	
	private void swip(int[] src, int x, int y) {
		int tmp = src[x];
		src[x] = src[y];
		src[y] = tmp;
	}

}
