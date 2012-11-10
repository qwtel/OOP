/**
 * AbstractPictArray
 * 
 * @author mihi
 */
public abstract class AbstractPictArray<P> implements Pict {
	private final P[][] content;
	double factor = 1.0;

	public AbstractPictArray(P[][] content) {
		this.content = content;			
	}
	
	@Override
	public void scale(double factor) {
		this.factor *= factor; 
	}
			
	@Override
	public String toString() {
	 	return new String();
	}

	@Override
	public boolean equals(Object o) {
	 	return false;
	}
}
