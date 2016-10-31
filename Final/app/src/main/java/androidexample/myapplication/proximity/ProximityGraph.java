package androidexample.myapplication.proximity;

import com.ebakyt.androidsensors.R;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;

import org.achartengine.GraphicalView;

public class ProximityGraph extends Activity implements SensorEventListener {
	
	private static GraphicalView view;
	private LineGraph line1 = new LineGraph();
	private static Thread thread;
	
	private SensorManager mSensorManager;
    private Sensor mProximity;
    static float xx;
    static float yy; 
    static float zz;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.proximitygraph);
		
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensorManager.registerListener(this, mProximity , SensorManager.SENSOR_DELAY_NORMAL);

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
					line1.addNewPoints(p1); // Add it to our graph
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
		setContentView(view);
	}
	
	protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
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
	}
}
