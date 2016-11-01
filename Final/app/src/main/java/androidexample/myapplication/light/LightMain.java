package androidexample.myapplication.light;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.Toast;

import com.ebakyt.androidsensors.R;

public class LightMain extends Activity implements SensorEventListener {

	private SensorManager mSensorManager;
    private Sensor mLight;
	private Vibrator v;
	private Toast toast = null;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.light);

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener(this, mLight , SensorManager.SENSOR_DELAY_NORMAL);


	}
    
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
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
		
		TextView tvX= (TextView)findViewById(R.id.textViewX);
		float x = event.values[0];
		tvX.setText(Float.toString(x));

//toast.cancel();

		if(x<5) {//ringtone();
			v.vibrate(500);
			//Toast.makeText(getBaseContext(),"inserted",Toast.LENGTH_SHORT).show();
			//Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
			toast.setText("inserted!");
			toast.show();



		};

	}
}
