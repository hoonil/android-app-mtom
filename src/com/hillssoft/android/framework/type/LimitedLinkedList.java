package com.hillssoft.android.framework.type;

import java.util.LinkedList;

public class LimitedLinkedList<E> extends LinkedList<E> {
	private static final long serialVersionUID = 4143924470451118518L;
	private int size;
	
	public LimitedLinkedList(int size) {
		this.size = size;
	}
	
	@Override
	public synchronized boolean add(E object) {
		if (this.size() >= size) {
			removeFirst();
		}
		return super.add(object);
	}
}
