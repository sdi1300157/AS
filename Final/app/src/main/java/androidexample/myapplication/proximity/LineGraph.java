package androidexample.myapplication.proximity;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint.Align;

public class LineGraph {

	private GraphicalView view;
	
	private TimeSeries series1 = new TimeSeries(" Proximity data"); 
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	private XYSeriesRenderer renderer1 = new XYSeriesRenderer(); // customize line 1
	
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer(); // Holds a collection of XYSeriesRenderer and customizes the graph
	
	public LineGraph()
	{
		// Add single dataset to multiple dataset
		mDataset.addSeries(series1);
		
		// Customization time for line 1!
		renderer1.setColor(Color.RED);
		//renderer1.setPointStyle(PointStyle.SQUARE);
		//renderer1.setFillPoints(true);
		renderer1.setLineWidth(2);
		
		// disable Zoom
		mRenderer.setZoomButtonsVisible(false);
		mRenderer.setXTitle("\nTime (ms)");
		mRenderer.setYTitle("   Proximity values (cm)");
		mRenderer.setShowGrid(false);
		//mRenderer.setGridColor(Color.LTGRAY);
		mRenderer.setZoomEnabled(false);
		mRenderer.setYAxisMin(-1.0);
		mRenderer.setYAxisMax(9.0);
		//mRenderer.setXAxisMin(0.0);
		//mRenderer.setXAxisMax(20.0);
		mRenderer.setInScroll(false);
		mRenderer.setClickEnabled(false);
		mRenderer.setPanEnabled(false, false);
		mRenderer.setZoomEnabled(false, false);
		
		mRenderer.setLabelsTextSize((float) 13.0);
		mRenderer.setLabelsColor(Color.LTGRAY);
		
		mRenderer.setXLabelsAlign(Align.CENTER);
		mRenderer.setYLabelsAlign(Align.RIGHT);
		//mRenderer.setAxesColor(Color.YELLOW);
		mRenderer.setChartTitle("\nProximity Monitor");
		mRenderer.setChartTitleTextSize((float) 30.0);
		mRenderer.setApplyBackgroundColor(true);
		mRenderer.setBackgroundColor(Color.BLACK);
		mRenderer.setMarginsColor(Color.BLACK);
		mRenderer.setMargins(new int[] {140, 50, 100, 10});
		mRenderer.setAxisTitleTextSize((float) 20.0);
		mRenderer.setLegendTextSize((float) 17.0);
		
		// Add 3 renderers to multiple renderer
		mRenderer.addSeriesRenderer(renderer1);
	}
	
	public GraphicalView getView(Context context) 
	{
		view =  ChartFactory.getLineChartView(context, mDataset, mRenderer);
		return view;
	}
	
	public void addNewPoints(Point p)
	{
		series1.add(p.getX(), ProximityGraph.xx);
		
		/* for removing  */
		if(series1.getItemCount() > 49){
			series1.remove(0);
		}
	}
}
