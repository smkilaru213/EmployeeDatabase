import java.util.Arrays;

public class EmployeeDatabase {

    private Employee[] set;
    private int size = 0;

	public EmployeeDatabase() {
		set = new Employee[11];
	}
	
	public EmployeeDatabase(int initialCapacity) {
		set = new Employee[initialCapacity];
	}

	public boolean add(Employee key) {
		if (key == null) {
			return false;
		}
		if (contains(key) == true) {
			return false;
		} else {
			int index = key.getId() % set.length;
			int quad = 0;
			//for (int i = index; i < set.length; i++) {
			for (int i = index; i < set.length; i = (int) (index + Math.pow(quad, 2))) {
				if (set[i] == null) {
					set[i] = key;
					size++;
					return true;
				}
				quad++;
			}
			return false;
		}
	}

	public boolean contains(Employee key) {
		int index = key.getId() % set.length;
		int quad = 0;
		//for (int i = index; i < set.length; i++) {
		for (int i = index; i < set.length; i = (int) (index + Math.pow(quad, 2))) {
			if (set[i] != null && set[i].equals(key)) {
				return true;
			}
			quad++;
		}
		return false;
	}

	public boolean remove(Employee key) {
		boolean rem = false;
		int index = key.getId() % set.length;
		int quad = 0;
		//for (int i = index; i < set.length; i++) {
		for (int i = index; i < set.length; i = (int) (index + Math.pow(quad, 2))) {
			if (set[i] != null && set[i].equals(key)) {
				set[i] = null;
				size--;
				rem = true;
				break;
			}
			quad++;
		}
		int quad2 = 0;
		if (rem == true) {
			Employee[] set2 = new Employee[size];
			//for (int i = 0; i < set.length; i++) {
			for (int i = index; i < set.length; i = (int) (index + Math.pow(quad2, 2))) {
				if (set[i] != null) {
					Employee key2 = set[i];
					int index2 = key2.getId() % set2.length;
					set2[index2] = key2;
					set[i] = null;
				}
				quad2++;
			}
			for (int i = 0; i < set2.length; i++) {
				set[i] = set2[i];
			}
		}
		return rem;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return "" + Arrays.toString(set);
	}
}
