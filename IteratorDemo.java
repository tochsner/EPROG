import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IteratorDemo {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		
		myList.add(5);			// 4
		myList.add(10);
		myList.add(-20);
		myList.add(-60);
		myList.add(12);
		
	
		Iterator<Integer> iter = new PositiveIterator(myList);
		
		while (iter.hasNext()) {			
			int i = iter.next();
			System.out.println(i);			
		}
	}
	
}











class PositiveIterator implements Iterator<Integer> {

	private List<Integer> list;
	private int next_index = 0;

	public PositiveIterator(List<Integer> list) {
		this.list = list;		
	}
	
	@Override
	public boolean hasNext() {		
		this.findNext();
	
		return (next_index < list.size());
	}

	@Override
	public Integer next() {
		this.findNext();
		
		Integer nextInt = list.get(next_index);
		next_index++;
		return nextInt;
	}
	
	private void findNext() {
		while (next_index < list.size() && list.get(next_index) < 0) {
			next_index++;
		}
	}
	
	void ourRemove() {
		this.findNext();
		list.remove(next_index);
	}
	
}