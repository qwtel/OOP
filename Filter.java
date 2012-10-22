import java.util.List;

/**
 * Filter.java
 * 
 * @author Johannes Deml
 * @since 1.2
 */
public interface Filter {
	
	public List<Billable> filter(List<Billable> list);
}