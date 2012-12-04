import java.util.ArrayList;
import java.util.List;

public class Field {
	private List<Car> list;

	public Field() {
		list = new ArrayList<Car>();
		//list = Collections.synchronizedList(list);
	}
	
	/**
	 * Adds a car on this field, checks collisions for all 
	 * existing cars on this field and returns the number of hit cars.
	 */
	public synchronized int add(Car car) {
		int score = list.size();

		for(Car attackedCar : list) {
			attackedCar.collision(car);
		}

		list.add(car);

		return score;
	}
	
	/**
	 * Removes a car on this field.
	 */
	public synchronized void remove(Car car) {
		list.remove(car);
	}
}
