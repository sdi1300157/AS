package androidexample.myapplication.magnetometer;

import com.ebakyt.androidsensors.R;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MagnetoMain extends Activity implements SensorEventListener{

	private SensorManager mSensorManager;
    private Sensor mMagnetic;
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.magneto);

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mMagnetic = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mSensorManager.registerListener(this, mMagnetic , SensorManager.SENSOR_DELAY_NORMAL);

        Button btMagnetoGraph = (Button) findViewById(R.id.btnMagnetoGraph);
        btMagnetoGraph.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MagnetoMain.this, MagnetoGraph.class));
			}
		});
	}
	
	protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mMagnetic, SensorManager.SENSOR_DELAY_NORMAL);
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
		TextView tvY= (TextView)findViewById(R.id.textViewY);
		TextView tvZ= (TextView)findViewById(R.id.textViewZ);
		
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];
		
		tvX.setText(Float.toString(x));
		tvY.setText(Float.toString(y));
		tvZ.setText(Float.toString(z));
	}
}
