import java.util.ArrayList;
import java.util.List;

/**
 * RehearsalsFilter.java
 * 
 * @author Johannes Deml
 * @since 1.2
 */

public class RehearsalsFilter implements Filter{

	public List<Billable> filter(List<Billable> list) {
		List<Billable> rehearsals = new ArrayList<Billable>();
		for(Billable e: list) {
			if(e instanceof Rehearsal) {
				rehearsals.add(e);
			}
		}
		return rehearsals;
	}
}
