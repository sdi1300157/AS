package androidexample.myapplication.magnetometer;

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
	
	private TimeSeries series1 = new TimeSeries("X data    "); 
	private TimeSeries series2 = new TimeSeries("Y data    ");
	private TimeSeries series3 = new TimeSeries("Z data");
	
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	
	private XYSeriesRenderer renderer1 = new XYSeriesRenderer(); // customize line 1
	private XYSeriesRenderer renderer2 = new XYSeriesRenderer(); // customize line 2
	private XYSeriesRenderer renderer3 = new XYSeriesRenderer(); // customize line 3
	
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer(); // Holds a collection of XYSeriesRenderer and customizes the graph
	
	public LineGraph()
	{
		// Add single dataset to multiple dataset
		mDataset.addSeries(series1);
		mDataset.addSeries(series2);
		mDataset.addSeries(series3);
		
		// Customization time for line 1!
		renderer1.setColor(Color.RED);
		//renderer1.setPointStyle(PointStyle.SQUARE);
		//renderer1.setFillPoints(true);
		renderer1.setLineWidth(2);
		
		// Customization time for line 2!
		renderer2.setColor(Color.GREEN);
		//renderer2.setPointStyle(PointStyle.CIRCLE);
		//renderer2.setFillPoints(true);
		renderer2.setLineWidth(2);
		
		// Customization time for line 3!
		renderer3.setColor(Color.CYAN);
		//renderer3.setPointStyle(PointStyle.CIRCLE);
		//renderer3.setFillPoints(true);
		renderer3.setLineWidth(2);
		
		// disable Zoom
		mRenderer.setZoomButtonsVisible(false);
		mRenderer.setXTitle("\nTime (ms)");
		mRenderer.setYTitle("   X-Y-Z axes values (uT)");
		mRenderer.setShowGrid(false);
		//mRenderer.setGridColor(Color.LTGRAY);
		mRenderer.setZoomEnabled(false);
		mRenderer.setYAxisMin(-50.0);
		mRenderer.setYAxisMax(50.0);
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
		mRenderer.setChartTitle("\nAmbient Magnetic Field Monitor");
		mRenderer.setChartTitleTextSize((float) 30.0);
		mRenderer.setApplyBackgroundColor(true);
		mRenderer.setBackgroundColor(Color.BLACK);
		mRenderer.setMarginsColor(Color.BLACK);
		mRenderer.setMargins(new int[] {140, 45, 100, 10});
		mRenderer.setAxisTitleTextSize((float) 20.0);
		mRenderer.setLegendTextSize((float) 17.0);
		
		// Add 3 renderers to multiple renderer
		mRenderer.addSeriesRenderer(renderer1);
		mRenderer.addSeriesRenderer(renderer2);
		mRenderer.addSeriesRenderer(renderer3);
	}
	
	public GraphicalView getView(Context context) 
	{
		view =  ChartFactory.getLineChartView(context, mDataset, mRenderer);
		return view;
	}
	
	public void addNewPoints(Point p)
	{
		series1.add(p.getX(), MagnetoGraph.xx);
		series2.add(p.getX(), MagnetoGraph.yy);
		series3.add(p.getX(), MagnetoGraph.zz);
		
		/* for removing  */
		if(series1.getItemCount() > 49){
			series1.remove(0);
		}
		
		if(series2.getItemCount() > 49){
			series2.remove(0);
		}
		
		if(series3.getItemCount() > 49){
			series3.remove(0);
		}
	}
}
