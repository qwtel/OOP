import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Field {
	private List<Car> list;

	public Field() {
		list = new ArrayList<Car>();
		//list = Collections.synchronizedList(list);
	}
	
	public int add(Car car) {
		int score = 0;

		for(Car attackedCar : list) {
			score += attackedCar.collision(car);
		}

		list.add(car);

		return score;
	}
	
	public void remove(Car car) {
		list.remove(car);
	}
}
