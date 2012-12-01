import java.util.ArrayList;
import java.util.List;

public class Field {
    	private List<Car> list;
    	private boolean locked;
    	public Field() {
    		//list = Collections.synchronizedList(new ArrayList<Car>());
    		list = new ArrayList<Car>();
    		locked = false;
    	}
    	
    	public synchronized int add(Car car, int dir) {
    		int score = list.size();
    		for (Car attackedCar : list) {
				attackedCar.collision(dir);
			}
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
    	public boolean isLocked() {
    		return locked;
    	}
    }