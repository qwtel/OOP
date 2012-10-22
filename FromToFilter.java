import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * FromToFilter.java
 * 
 * @author Johannes Deml
 * @since 1.2
 */

public class FromToFilter implements Filter {
	private Date from;
	private Date to;
	
	public FromToFilter(Date from, Date to) {
		this.from =from;
		this.to= to;
	}
	
	public List<Billable> filter(List<Billable> list) {
		List<Billable> res = new ArrayList<Billable>();
		if( from == null && to == null)
			return list;
		for(Billable u : list){
			if(from == null){
				if(to.after(u.getDate()))
					res.add(u);
			}
			else if(to == null){
				if(from.before(u.getDate()))
					res.add(u);
			}
			else if(from.before(u.getDate()) && to.after(u.getDate()))
				res.add(u);		
		}
		return res;
	}
}
