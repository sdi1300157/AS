package androidexample.myapplication.magnetometer;

public class MockData {

	public static Point getDataFromReceiverXX(long x)
	{
		return new Point(x, MagnetoGraph.xx);
	}
	
	public static Point getDataFromReceiverYY(long x)
	{
		return new Point(x, MagnetoGraph.yy);
	}
	
	public static Point getDataFromReceiverZZ(long x)
	{
		return new Point(x, MagnetoGraph.zz);
	}
}
