package com.jaden.sort;

/*
 * ϣ������
 * ˼�룺����ĳ��������Ԫ�ؽ������򣬼��粽��Ϊ4����ôindex=0��index=4��index=8.��������Ԫ�ؽ��бȽ�����index=1��index=5��index=9.��������Ԫ�ؽ��бȽ�����
 *     index=2��index=6��index=10.��������Ԫ�ؽ��бȽ�����index=3��index=7��index=11.��������Ԫ�ؽ��бȽ�����
 *     ��һ��������ɣ���С������ͬ��������Ĺ����������
 *     ȷ�����һ�εĲ���Ϊ1
 *     
 *     ����ֻ����һ��һ������Ϊ1��������ô���ǲ���������
 * ʱ�临�Ӷȣ�O(n^(1.3��2))
 * �ռ临�Ӷȣ�O(1)
 */
public class ShellSort implements Sort {

	@Override
	public int[] sort(int[] src) {
		int size = src.length;
		int gap = 1;
		int interval = 3; //��̬���ü��
		int tmp, p;
		while (gap < size / interval) {
			gap = gap * interval + 1;
		}
		for(; gap>0; gap=gap/interval) {
			
			for(int i=gap; i<size; i++) {
				tmp = src[i];
				p = i - gap;
				while (p >= 0 && tmp < src[p] ) {
					src[p+gap] = src[p];
					p -= gap;
				}
				src[p+gap] = tmp;
			}
		}
		return src;
	}

}
