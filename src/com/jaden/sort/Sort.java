package com.jaden.sort;

/*
 * �����㷨�Ľӿڣ�����ʵ��sort
 */
public interface Sort {
	public static final int BUBBLE_SORT = 1; //ð��
	public static final int SELECTION_SORT = 2; //ѡ��
	public static final int INSERTION_SORT = 3; //����
	public static final int SHELL_SORT = 4; //ϣ��
	public static final int MERGE_SORT = 5; //�鲢
	public static final int QUICK_SORT = 6; //����
	public static final int HEAP_SORT = 7; //������
	public static final int COUNTING_SORT = 8; //��������
	public static final int BUCKET_SORT = 9; //ʹ����
	public static final int RADIX_SORT = 10; //��������
	
	int[] sort(int []src );
}
