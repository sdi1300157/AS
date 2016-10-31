package androidexample.myapplication.acceleration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.ebakyt.androidsensors.R;

public class LinAcceleroMain extends Activity implements SensorEventListener{

	private SensorManager mSensorManager;
    private Sensor mLinAcceleration;
	
    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linaccelero);

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mLinAcceleration = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        mSensorManager.registerListener(this, mLinAcceleration , SensorManager.SENSOR_DELAY_GAME);

        Button btLinAcceloGraph = (Button) findViewById(R.id.btnLinAcceleroGraph);
        btLinAcceloGraph.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(LinAcceleroMain.this, LinAcceleroGraph.class));
			}
		});
	}
	
	protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLinAcceleration, SensorManager.SENSOR_DELAY_NORMAL);
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
		
		float x = event.values[SensorManager.AXIS_X];
		float y = event.values[SensorManager.AXIS_Y];
		float z = event.values[2];
		
		tvX.setText(Float.toString(x));
		tvY.setText(Float.toString(y));
		tvZ.setText(Float.toString(z));
	}
}
