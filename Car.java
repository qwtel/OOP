/**
 * Car
 *
 * Represents a car.
 */
public abstract class Car extends Thread {

	/**
	 * 0 top, 1 left, 2 bottom, 3 right
	 */
	protected int dir;

	public Car() {
		this.dir = 1 + (int)(4*Math.random());
	}

	public Car(int dir) {
		this.dir = dir;
	}

	/**
	 * Turns the car.
	 *
	 * Turns the car left n times if n is negative.
	 * Turns the car right n times if n is positive.
	 *
	 * @param n The number of turns to the left if positive or to the right if
	 *          negative.
	 */
	public void turn(int n) {
		dir = (dir+n)%4;
	}

	@Override
	abstract public void start();
}
