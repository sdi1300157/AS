package androidexample.myapplication.acceleration;

public class MockData {

	public static Point getDataFromReceiverXX(long x)
	{
		return new Point(x, LinAcceleroGraph.xx);
	}
	
	public static Point getDataFromReceiverYY(long x)
	{
		return new Point(x, LinAcceleroGraph.yy);
	}
	
	public static Point getDataFromReceiverZZ(long x)
	{
		return new Point(x, LinAcceleroGraph.zz);
	}
}
