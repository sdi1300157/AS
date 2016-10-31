package androidexample.myapplication.accelerometer;

import com.ebakyt.androidsensors.R;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;

import org.achartengine.GraphicalView;


public class AcceleroGraph extends Activity implements SensorEventListener {
	
	private static GraphicalView view;
	private LineGraph line1 = new LineGraph();
	private LineGraph line2 = new LineGraph();
	private LineGraph line3 = new LineGraph();
	private static Thread thread;
	
	private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    static float xx;
    static float yy; 
    static float zz;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accelerograph);
		
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);

		thread = new Thread() {
			public void run()
			{
				for (int i = 0; i < 999; i++) 
				{
					try {
						Thread.sleep(200);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					long ttime = System.currentTimeMillis();
					Point p1 = MockData.getDataFromReceiverXX(ttime); // new data!
					Point p2 = MockData.getDataFromReceiverYY(ttime);
					Point p3 = MockData.getDataFromReceiverZZ(ttime);
					line1.addNewPoints(p1); // Add it to our graph
					line2.addNewPoints(p2);
					line3.addNewPoints(p3);
					view.repaint();
				}
			}
		};
		thread.start();	
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		view = line1.getView(this);
		view = line2.getView(this);
		view = line3.getView(this);
		setContentView(view);
	}
	
	protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		///
	}

	@Override
	public void onSensorChanged(SensorEvent event) {

		xx = event.values[0];
		yy = event.values[1];
		zz = event.values[2];
	}
}
