package androidexample.myapplication.accelerometer;

//import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
//import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

//import com.ebakyt.androidsensors.R;
import androidexample.myapplication.seekbar;

//public class AcceleroMain extends Activity implements SensorEventListener {
public class AcceleroMain extends seekbar implements SensorEventListener{

	private SensorManager mSensorManager;
	public Sensor mAccelerometer;
	public SensorManager mSensorManager3;
    //private Sensor mAccelerometer;
	public Toast toast = null;
	//private Toast toast = null;
	TextView tvX;
	TextView tvY;
	TextView tvZ;


	public AcceleroMain(SensorManager mSensorManager,Toast toast,TextView tvX,TextView tvY,TextView tvZ){
		//seekbar=this.Accelero_Interval;
		this.mSensorManager=mSensorManager;
		this.toast=toast;
		this.tvX=tvX;
		this.tvY=tvY;
		this.tvZ=tvZ;
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mSensorManager.registerListener(this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
	}
    //@Override
	//protected void onCreate(Bundle savedInstanceState) {
		//super.onCreate(savedInstanceState);
		//setContentView(R.layout.accelero);


		//mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
       // mSensorManager.registerListener(this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);


	//}
	
	protected void onResume() {
        //super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
       // super.onPause();
        mSensorManager.unregisterListener(this);
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		///
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		
		//TextView tvX= (TextView)findViewById(R.id.textViewXX);
		//TextView tvY= (TextView)findViewById(R.id.textViewY);
		//TextView tvZ= (TextView)findViewById(R.id.textViewZ);
		
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];

		//Toast.makeText(getApplicationContext(), String.valueOf(progress), Toast.LENGTH_SHORT).show();
		tvX.setText(Float.toString(x));
		tvY.setText(Float.toString(y));
		tvZ.setText(Float.toString(z));
	}
}
