package com.itkevin.prototype.test.greatestsage;

import java.io.Serializable;

/**
 * �𹿰�
 * @author Kevin
 *
 */
public class GoldRingedStaff implements Serializable{
	
	private float height = 100; //����
	private float diameter = 10;//ֱ��
	
	
	
	/**
	 * �𹿰�����
	 */
	public void grow(){
		this.diameter *= 2;
		this.height *= 2;
	}
	
	/**
	 * �𹿰���С
	 */
	public void shrink(){
		this.diameter /= 2;
		this.height /= 2;
	}
	
}
