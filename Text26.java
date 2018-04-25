package com.NiuKeWang;
/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 思路一：假设总共有n个节点，在对比情况之下生成2*n-1个节点，
 * 在逻辑上面结构是一样的，只是在物理存储上面要多n-1个节点。
 * 
 * 思路二：先将n个节点扩展到2*n个节点，在源节点后面添加一个复制的节点，
 * A->B->C变成A->A`->B->B`->C->C`
 * 然后有A.next.readom=A.readom.next;（关键点）
 * 最后拆分整个链表，得到A`->B`->C`;
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
		//穿插节点
		RandomListNode first=pHead;
		while(first!=null){
			RandomListNode head=new RandomListNode(first.label);
			head.next=first.next;
			first.next=head;
			first=head.next;
		}
		first=pHead;
		//得到random
		while(first!=null){
			if(first.random!=null){
				first.next.random=first.random.next;
			}
			first=first.next.next;
		}
		//拆分节点
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



