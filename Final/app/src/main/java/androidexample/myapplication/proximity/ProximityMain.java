package androidexample.myapplication.proximity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ebakyt.androidsensors.R;

public class ProximityMain extends Activity implements SensorEventListener {

	private SensorManager mSensorManager;
    private Sensor mProximity;
    private Vibrator v;
    private static Context aContext=null;
    private static Boolean supported;
		//private int progress=seekbar::pr();
    @Override
	protected void onCreate(Bundle savedInstanceState) {


		super.onCreate(savedInstanceState);
		setContentView(R.layout.proximity);
         v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensorManager.registerListener(this, mProximity , SensorManager.SENSOR_DELAY_GAME);

        Button btProxiGraph = (Button) findViewById(R.id.btnProximityGraph);
        btProxiGraph.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(ProximityMain.this, ProximityGraph.class));
			}
		});
	}
    
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_GAME);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
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
           Toast.makeText(getBaseContext(),"inserted",Toast.LENGTH_SHORT).show();
		   //Toast.makeText(getApplicationContext(), String.valueOf(progress), Toast.LENGTH_SHORT).show();



       };
        if(v.hasVibrator()) {
            //ringtone();

        };
		tvX.setText(Float.toString(x));
	}
}
