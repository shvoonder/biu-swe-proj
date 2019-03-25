package Model;

public class StockCalc {

	private String name;
	private double[] values = new double[11];
	
	public StockCalc (String name, double a, double b, double c,double d, double e,double f,double g,double h, double i,double j,double k) {
		this.name = name;
		this.values[0] = a;
		this.values[1] = b;
		this.values[2] = c;
		this.values[3] = d;
		this.values[4] = e;
		this.values[5] = f;
		this.values[6] = g;
		this.values[7] = h;
		this.values[8] = i;
		this.values[9] = j;
		this.values[10] = k;
	}
	
	
	public double getValues(int index) {
		return values[index];
	}
	public String getName() {
		return name;
	}
	
}
