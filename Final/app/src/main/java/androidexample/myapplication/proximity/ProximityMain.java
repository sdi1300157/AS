package androidexample.myapplication.proximity;

//import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
//import android.os.Bundle;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.Toast;

//import com.ebakyt.androidsensors.R;
import androidexample.myapplication.seekbar1;

//public class ProximityMain extends  Activity  implements SensorEventListener {
public class ProximityMain extends seekbar1 implements SensorEventListener{


	private SensorManager mSensorManager;
    public Sensor mProximity;
	// private Vibrator v;
	//private Toast toast = null;
   	public SensorManager mSensorManager2;
	public Vibrator v;
    public Toast toast = null;
	public static int Proximity_Interval=0;
    private static Context aContext=  null;
	TextView tvX1;

    public static Boolean supported;
		//private int progress=seekbar::pr();
	public ProximityMain (SensorManager mSensorManager,Vibrator v,Toast toast,TextView tvX1,int a) {
		//seekbar=this.Proximity_Interval;
		this.Proximity_Interval=a;
		this.mSensorManager=mSensorManager;
		this.v=v;
		this.toast=toast;
		this.tvX1=tvX1;
		mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_FASTEST);
	}


        //@Override
        //final public void onCreate (Bundle savedInstanceState){


		//super.onCreate(savedInstanceState);
		//setContentView(R.layout.proximity);
		//Intent intent = new Intent(this, MainActivity.class);
        // v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		//mSensorManager1 = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		//toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
		//mProximity = mSensorManager1.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        //mSensorManager1.registerListener(this, mProximity , SensorManager.SENSOR_DELAY_FASTEST);


	//}
    
    protected void onResume() {
        //super.onResume();
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_FASTEST);
    }
	public void change(int a){
		Proximity_Interval=a;
	}
    protected void onPause() {
        //super.onPause();
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

		//TextView tvX1= (TextView)findViewById(R.id.textViewX);
		float x = event.values[0];

        //v.vibrate(500);

       if(x < 5) {//ringtone();
           //Toast.makeText(getBaseContext(),"inserted",Toast.LENGTH_SHORT).show();
		  // Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
		  // toast.setText("inserted!");
		   //toast.show();


       };
        if(v.hasVibrator()) {
            //ringtone();

        };
		tvX1.setText(Float.toString(x));
	}
}
