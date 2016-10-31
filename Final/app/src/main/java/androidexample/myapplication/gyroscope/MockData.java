package androidexample.myapplication.gyroscope;

public class MockData {

	public static Point getDataFromReceiverXX(long x)
	{
		return new Point(x, GyroGraph.xx);
	}
	
	public static Point getDataFromReceiverYY(long x)
	{
		return new Point(x, GyroGraph.yy);
	}
	
	public static Point getDataFromReceiverZZ(long x)
	{
		return new Point(x, GyroGraph.zz);
	}
}
