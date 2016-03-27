// Uncomment the following line AFTER you have generated the Javadocs,
// when you are ready to do problem 1, part B (JUnit testing) and you 
// have moved this file to the countertest folder.

package countertest;
/** A class that implements a counter.
 * @author Zhiyu Mao
 * @version 1.0
 */
public class Counter {

	private int count = 0;
	private int step = 1;
	
	/** Constructor 
	 * Create a counter initialized to zero, step increment of 1
	 */
	public Counter()
	{
		// Nothing to do here
	}
	/** Constructor Create a counter initialized to 0, step
	 * increment specified by the parameter
	 * @param theStep The size of the step increment. Must 
	 * be positive
	 */
	public Counter(int theStep)
	{
		int s;
		if ( (s = Math.abs(theStep)) >  0)
			step = s; 
	}
	/** Retrive the current value of the counter
	 * @return The value of the counter 
	 */
	public int getCount() {
		return count;
	}
	/** Increment the counter by its step
	 */
	public void increment() {
		count += step;
	}
	/** Decrement the counter by its step
	 */
	public void decrement() {
		if (count > step ) 
			count -= step;
		else
			count = 0;
	}
	/** Reset the counter to 0
	 */
	public void reset() {
		count = 1;
	}
}
