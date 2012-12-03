import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Field {
	private List<Car> list;

	public Field() {
		list = new ArrayList<Car>();
		//list = Collections.synchronizedList(list);
	}
	
	public synchronized int add(Car car) {
		int score = list.size();

		for(Car attackedCar : list) {
			attackedCar.collision(car);
		}

		list.add(car);

		return score;
	}
	
	public synchronized void remove(Car car) {
		list.remove(car);
	}
}
