


import java.math.BigDecimal;

public class SeriesTester{
	public static void main(String[] args){
		Series series = Series.TWO;
	//		private BigDecimal computeSum(final Series series, final int a, final int b, final int threads){
		SeriesSolver s = new SeriesSolver();
		BigDecimal sum = s.computeSum(series, 3, 24, 3);
		System.out.println(sum.toString());
		
	}
}
