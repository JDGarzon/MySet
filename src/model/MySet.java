package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;


public class MySet<T> extends CopyOnWriteArraySet<T> implements  Set<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CopyOnWriteArraySet<T> set;
	
	public MySet() {
		set =new CopyOnWriteArraySet<>();
	}

	
	public void clear() {
		set.clear();
	}
	
	public boolean remove(Object toRemove) {
		return set.remove(toRemove);
	}
	
	public boolean add(T toAdd){ 
		return set.add(toAdd);
	}
	
	
	public boolean removeAll(Collection<?> toRemove) {
		return set.removeAll(toRemove);
	}
	
	
	public boolean addAll(Collection<? extends T> toAdd) {
		return set.addAll(toAdd);
	}
	
	public boolean retainAll(Collection<?> toRetain) {
		return set.retainAll(toRetain);
	}
	
	public Object[] toArray() {
		return  set.toArray();
	}
	
	public void forEach(Consumer<? super T> paramConsume) {
		set.forEach(paramConsume);
	}
	
	public Spliterator<T> spliterator(){
	    return Spliterators.spliterator(set.toArray(), 1025);
	}
	
	public Iterator<T> iterator(){
		return set.iterator();
	}
	
	public int size() {
		return set.size();
	}
}
