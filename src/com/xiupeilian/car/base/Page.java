package com.xiupeilian.car.base;

import java.util.List;

/**
 * 
 * ʹ�÷����������ҳ�Ķ���Page<Publicmessage>
 * Page<News>
 * ��ҳ�����а����˷��Ͷ���
 * ��ҳ���߶���
 * ��ѯ�Ľ������
 * ������.
 *
 * 
 */
public class Page<T> {
	//��װ��������
	private T t;
	//��װ��ҳ����(ƫ������ÿҳ������)
    private Pager pager;
    //��ѯ�����¼
	private List<T> list;
	//����������������
	private int totalRows;
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}

	
	
	

}
