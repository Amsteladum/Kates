package org.amstel.Kates.data.api.methods;

//import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisjointSet<T> {
	HashMap<T, List<T>> partitionsMap = new HashMap<T, List<T>>();

	List<T> initialList = new ArrayList<T>(); // TODO change <String> to a class.

	DisjointSet(List<T> initialList) {
		this.partitionsMap = new HashMap<T, List<T>>();

		for (int index = 0; index < initialList.size(); index++) {
			if (initialList.isEmpty() || initialList.get(index).equals(initialList.get(index))) {
				partitionsMap.keySet();
			}
		}
	}

	DisjointSet<T> add(T a) {
		boolean state = false;

		if (partitionsMap.isEmpty() ? partitionsMap.containsValue( (Object) a) : partitionsMap.containsKey(state))
			state = false;
		else
			state = true;

		return new DisjointSet<T>(initialList);
	}

	DisjointSet<T> findPartition(T a) {
		if (a == null ? !partitionsMap.equals((Object) a) : partitionsMap.equals((Object) a))
			partitionsMap.get((Object) a);

		return findPartition(a);
	}

	DisjointSet<T> arDisjointed(T a, T b) {
		findPartition(a);
		findPartition(b);
		
		if (a != b)
			return findPartition(a);
		else
			return findPartition(b);
	}

	DisjointSet<T> mergeSet(T a, T b) {
		findPartition(a);
		findPartition(b);

		boolean state = false;
		
		if (this.findPartition(a) == this.findPartition(b))
			state = false;
		else {
			for (int index = 0; index < partitionsMap.size(); index++) {
				state = initialList.add(a);
				this.partitionsMap.get(state);
			}

			state = true;
		}

		return mergeSet(a, b);
	}
}