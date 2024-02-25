import java.util.Objects;

public class Employee {

	private String name;
	private int ID;
	
	public Employee(String name, int id) {
		this.name = name;
		this.ID = id;
	}

	public int getId() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ID, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		return ID == other.ID && Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "" + this.getName();
	}
}
