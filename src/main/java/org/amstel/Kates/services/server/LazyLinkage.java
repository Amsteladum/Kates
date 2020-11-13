package org.amstel.Kates.services.server;

//import java.util.stream.Stream;
//import java.util.stream.IntStream;
//import java.util.function.Predicate;
import java.util.function.Supplier;
/*19.3. Lazy evaluation with streams*/
interface LinkedList<T> {
	T head();
	Supplier<LinkedList<T>> tail();
	default boolean isEmpty() { return true; }
} // NOTE Supplier encodes laziness.

public class LazyLinkage<T> implements LinkedList<T> {
	/*IntStream numbers() {
		return IntStream.iterate(2, n->n+1);
	}

	int head(IntStream numbers) {
		return numbers.findFirst().getAsInt();
	}

	IntStream tail(IntStream numbers) {
		return numbers.skip(1);
	}*/
	private final T head;
	private final Supplier<LinkedList<T>> tail;
	public LazyLinkage(T head, Supplier<LinkedList<T>> tail) {
		this.head = head;
		this.tail = tail;
	}

	public T head() { return head; }
	public Supplier<LinkedList<T>> tail() { return tail; }
	public boolean isEmpty() { return false; }

	public LazyLinkage<Integer> from(int n) {
		return new LazyLinkage<Integer>(n, ()->from(n+1));
	}

	/*public LazyLinkage<T> filter(Predicate<T> p) {
		return isEmpty() ? this
		: p.test(head()) ? new LazyLinkage<T>(head(), ()->tail().filter(p)) 
		: tail().filter(p);
	}*/
}

class Empty<T> implements LinkedList<T> {
	public T head() { throw new UnsupportedOperationException(); }
	public Supplier<LinkedList<T>> tail() { throw new UnsupportedOperationException(); }
}