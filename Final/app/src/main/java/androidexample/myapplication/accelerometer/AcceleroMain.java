package androidexample.myapplication.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
import android.widget.Toast;

public class AcceleroMain  implements SensorEventListener{

	private SensorManager mSensorManager;
	private int Accelerometer_Interval=0;
	public Sensor mAccelerometer;
	public Toast toast = null;
	TextView tvX;
	TextView tvY;
	TextView tvZ;

	public AcceleroMain(SensorManager mSensorManager,Toast toast,TextView tvX,TextView tvY,TextView tvZ,int a){

		this.Accelerometer_Interval=a;
		this.mSensorManager=mSensorManager;
		this.toast=toast;
		this.tvX=tvX;
		this.tvY=tvY;
		this.tvZ=tvZ;
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mSensorManager.registerListener(this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
	}

	protected void onResume() {

        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {

        mSensorManager.unregisterListener(this);
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	@Override
	public void onSensorChanged(SensorEvent event) {

		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];
		tvX.setText(Float.toString(x));
		tvY.setText(Float.toString(y));
		tvZ.setText(Float.toString(z));
	}
}