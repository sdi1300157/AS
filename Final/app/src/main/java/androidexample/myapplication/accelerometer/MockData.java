package androidexample.myapplication.accelerometer;

public class MockData {

	public static Point getDataFromReceiverXX(long x)
	{
		return new Point(x, AcceleroGraph.xx);
	}
	
	public static Point getDataFromReceiverYY(long x)
	{
		return new Point(x, AcceleroGraph.yy);
	}
	
	public static Point getDataFromReceiverZZ(long x)
	{
		return new Point(x, AcceleroGraph.zz);
	}
}
