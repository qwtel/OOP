import java.util.ArrayList;
import java.util.List;

/**
 * GigsFilter.java
 * 
 * @author Johannes Deml
 * @since 1.2
 */

public class GigsFilter implements Filter{

	public List<Billable> filter(List<Billable> list) {
		List<Billable> gigs = new ArrayList<Billable>();
		for(Billable e: list) {
			if(e instanceof Gig) {
				gigs.add(e);
			}
		}
		return gigs;
	}
}
