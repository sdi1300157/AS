package androidexample.myapplication.proximity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.Toast;

import com.ebakyt.androidsensors.R;

public class ProximityMain extends  Activity  implements SensorEventListener {


	private SensorManager mSensorManager1;
    private Sensor mProximity;
    private Vibrator v;
	private Toast toast = null;
    private static Context aContext=null;
    private static Boolean supported;
		//private int progress=seekbar::pr();


        @Override
        final public void onCreate (Bundle savedInstanceState){


		super.onCreate(savedInstanceState);
		setContentView(R.layout.proximity);
		//Intent intent = new Intent(this, MainActivity.class);
         v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		mSensorManager1 = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
		mProximity = mSensorManager1.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensorManager1.registerListener(this, mProximity , SensorManager.SENSOR_DELAY_FASTEST);


	}
    
    protected void onResume() {
        super.onResume();
        mSensorManager1.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_FASTEST);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager1.unregisterListener(this);
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		///

		if (accuracy>=5) ringtone();
	}
	public void ringtone() {
		try {
			Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
			r.play();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(getBaseContext(), "No ring tone",Toast.LENGTH_SHORT).show();
		}
	}
	@Override
	public void onSensorChanged(SensorEvent event) {

		TextView tvX= (TextView)findViewById(R.id.textViewX);
		float x = event.values[0];

        v.vibrate(500);

       if(x<5) {//ringtone();
           //Toast.makeText(getBaseContext(),"inserted",Toast.LENGTH_SHORT).show();
		  // Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
		   toast.setText("inserted!");
		   toast.show();


       };
        if(v.hasVibrator()) {
            //ringtone();

        };
		tvX.setText(Float.toString(x));
	}
}
