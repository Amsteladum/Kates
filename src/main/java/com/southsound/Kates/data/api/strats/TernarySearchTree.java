package com.southsound.Kates.data.api.strats;

public class TernarySearchTree {
	private String key;
	private int value;
	private TernarySearchTree left, right;

	public TernarySearchTree(String key, int value, TernarySearchTree left, TernarySearchTree right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public TernarySearchTree getRight() {
		return right;
	}

	public void setRight(TernarySearchTree right) {
		this.right = right;
	}

	public TernarySearchTree getLeft() {
		return left;
	}

	public void setLeft(TernarySearchTree left) {
		this.left = left;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}

class TernarySearchTreeProcessor {
	public int lookUp(String key, int defaultValue, TernarySearchTree tree) {

		if (tree == null)
			return defaultValue;
		if (key.equals(tree.getKey()))
			return tree.getValue();

		return lookUp(key, defaultValue, key.compareTo(tree.getKey()) < 0 ? tree.getLeft() : tree.getRight());
	}

	public TernarySearchTree update(String key, int newValue, TernarySearchTree tree) {
		return (tree == null) ? new TernarySearchTree(key, newValue, null, null) : key.equals(tree.getKey()) 

		? new TernarySearchTree(key, newValue, tree.getLeft(), tree.getRight())
		: key.compareTo(tree.getKey()) < 0

		? new TernarySearchTree(tree.getKey(), tree.getValue(), update(key, newValue, tree.getLeft()), tree.getRight())
		: key.compareTo(tree.getKey()) < 0 

		? new TernarySearchTree(tree.getKey(), tree.getValue(), tree.getLeft(), update(key, newValue, tree.getRight())) 
		: new TernarySearchTree(key, tree.getValue(), tree.getLeft(), tree.getRight()); // or (...(... null, null));
	}
}