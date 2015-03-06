package collection;

public class Animal implements Comparable {
	String especie;

	public Animal() {
	}

	public Animal(String e) {
		this.especie = e;
	}

	public void eat() {
		System.out.println(especie + " is eating.");
	}

	@Override
	public String toString() {
		return "Animal [especie=" + especie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((especie == null) ? 0 : especie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (especie == null) {
			if (other.especie != null)
				return false;
		} else if (!especie.equals(other.especie))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Animal))
			return -1;
		else
			return this.especie.compareTo(((Animal) o).especie);
	}

}
