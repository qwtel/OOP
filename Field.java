import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Field {
	private List<Car> list;
	private boolean locked;

	public Field() {
		list = new ArrayList<Car>();
		//list = Collections.synchronizedList(list);
		locked = false;
	}
	
	public synchronized int add(Car car) {
		int score = list.size();
		//for (Car attackedCar : list) {
		//	attackedCar.collision(car.dir);
		//}
		list.add(car);
		
		return score;
	}
	
	public synchronized void remove(Car car) {
		list.remove(car);
	}

	public synchronized void lockedOnOff() {
		locked = !locked;
		if(!locked) {
			notifyAll();
		}
	}

	public synchronized boolean isLocked() {
		return locked;
	}
}
