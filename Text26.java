package com.NiuKeWang;
/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬
 * ��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * ˼·һ�������ܹ���n���ڵ㣬�ڶԱ����֮������2*n-1���ڵ㣬
 * ���߼�����ṹ��һ���ģ�ֻ��������洢����Ҫ��n-1���ڵ㡣
 * 
 * ˼·�����Ƚ�n���ڵ���չ��2*n���ڵ㣬��Դ�ڵ�������һ�����ƵĽڵ㣬
 * A->B->C���A->A`->B->B`->C->C`
 * Ȼ����A.next.readom=A.readom.next;���ؼ��㣩
 * ��������������õ�A`->B`->C`;
 */
public class Text26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
}

class RandomListNode{
	int label;
	RandomListNode next=null;
	RandomListNode random=null;
	RandomListNode(int label){
		this.label=label;
	}
}
class Solution26{
	public RandomListNode Clone(RandomListNode pHead){
		if(pHead==null){
			return null;
		}
		RandomListNode first=new RandomListNode(pHead.label);
		RandomListNode head=first;
		if(pHead.random!=null){
			first.random=new RandomListNode(pHead.random.label);
		}
		while(pHead.next!=null){
			first.next=new RandomListNode(pHead.next.label);
			pHead=pHead.next;
			first=first.next;
			if(pHead.random!=null){
				first.random=new RandomListNode(pHead.random.label);
			}
		}
		if(pHead.random!=null){
			first.random=new RandomListNode(pHead.random.label);
		}
		return head;
	}
}

class Solution26_1{
	public RandomListNode Clone(RandomListNode pHead){
		if(pHead==null)
			return null;
		//����ڵ�
		RandomListNode first=pHead;
		while(first!=null){
			RandomListNode head=new RandomListNode(first.label);
			head.next=first.next;
			first.next=head;
			first=head.next;
		}
		first=pHead;
		//�õ�random
		while(first!=null){
			if(first.random!=null){
				first.next.random=first.random.next;
			}
			first=first.next.next;
		}
		//��ֽڵ�
		first=pHead;
		RandomListNode head=first.next;
		RandomListNode headD=head;
		while(first!=null){
			first.next=first.next.next;
			if(head.next!=null){
				head.next=head.next.next;
			}
			first=first.next;
			head=head.next;
		}
		return headD;
	}
}



