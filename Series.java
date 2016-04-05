import java.math.BigDecimal;
import java.math.MathContext;

/**
 * A naive implementation of a Series, as characterized
 * by an equation for its nth term.
 */
public interface Series {
	
	/**
	 * Computes the nth value of the series.
	 *
	 * @param n The nth term.
	 */
	public BigDecimal computeValue(int n);
	
	/*
	 * Sum from 0 -> Infinity = 2. This will be slower than the PI Series below due to the call to pow().
	 *
	 * f(n) = 1/2^n
	 */
	public static final Series TWO = new Series(){
		@Override
		public BigDecimal computeValue(final int n){
			return BigDecimal.ONE.divide(new BigDecimal(2).pow(n));
		}
	};
	
	/*
	 * Value from 0 -> Infinity = PI.
	 *
	 * f(n) = 1/(2n+1)
	 */
	public static final Series PI = new Series(){
		private final BigDecimal FOUR = new BigDecimal(4);
		@Override
		public BigDecimal computeValue(final int n){
			if (n % 2 == 0){
				return FOUR.divide(new BigDecimal(2*n+1),MathContext.DECIMAL128);
			}
			else {
				return FOUR.divide(new BigDecimal(2*n+1),MathContext.DECIMAL128).negate();
			}
		}
	};
}