import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Strategy
 *
 * A strategy by which a cars moves.
 */
public abstract class Strategy {
	private int width;
	private int height;
	
	public Strategy (Grid grid) {
		this.width = grid.width;
		this.height = grid.height;
	}
	
	/**
	 * The next move for a car
	 * @return For FlexCar, a number between -1 and 1. 
	 *         -1 forward-left, 0 forward, 1 forward-right
	 *         For FastCar, a number between -2 and 2. 
	 *         -2 left, -1 forward-left, 0 forward, 1 forward-right, 2 right
	 */
	public synchronized int nextMove(Car car) {
		Map<Integer, Direction> next = new ConcurrentHashMap<Integer, Direction>();
		next.put(1, car.getDirection().rotate45(1));
		next.put(0, car.getDirection().rotate45(0));
		next.put(-1, car.getDirection().rotate45(-1));
		
		if(car instanceof FlexCar) {
			next.put(2, car.getDirection().rotate45(2));
			next.put(-2, car.getDirection().rotate45(-2));
			//remove direction which would result in out-of-bounds
			Iterator<Entry<Integer, Direction>> it = next.entrySet().iterator();
			while(it.hasNext()) {
				Entry<Integer, Direction> temp = it.next();
				
				int x = car.getX() + temp.getValue().x;
				int y = car.getY() + temp.getValue().y;
				if(x >= width || y >= height || x < 0 || y < 0)
					next.remove(temp.getKey());
			}
			
			int[] possible = new int[next.size()];
			int counter = 0;
			it = next.entrySet().iterator();
			while(it.hasNext()) {
				possible[counter++] = it.next().getKey();
			}
			return calcNextMove(possible);
			
		}
		else if(car instanceof FastCar) {
			//remove direction which would result in out-of-bounds
			Iterator<Entry<Integer, Direction>> it = next.entrySet().iterator();
			while(it.hasNext()) {
				Entry<Integer, Direction> temp = it.next();
				
				int x = car.getX() + temp.getValue().x;
				int y = car.getY() + temp.getValue().y;
				
				if(x >= width || y >= height || x < 0 || y < 0) {
					next.remove(temp.getKey());
				} else {
					Direction carDir = car.getDirection().rotate90((int) Math.signum(temp.getKey()));
					if(x >= width-1) {
						Direction xMax = new Direction(-1, 0);
						if(xMax.isOpposite(carDir)) {
							next.remove(temp.getKey());
						}
					}
					if(x <= 1) {
						Direction xMin = new Direction(1, 0);
						if(xMin.isOpposite(carDir)) {
							next.remove(temp.getKey());
						}
					}
					if(y >= height-1) {
						Direction yMax = new Direction(0, -1);
						if(yMax.isOpposite(carDir)) {
							next.remove(temp.getKey());
						}
					}
					if(y <= 1) {
						Direction yMin = new Direction(0, 1);
						if(yMin.isOpposite(carDir)) {
							next.remove(temp.getKey());
						}
					}
				}
					
			}
			
			int[] possible = new int[next.size()];
			int counter = 0;
			it = next.entrySet().iterator();
			while(it.hasNext()) {
				possible[counter++] = it.next().getKey();
			}
			return calcNextMove(possible);
			
		}
		return 0;
	}
	
	public abstract int calcNextMove(int[] possible);
	
}
