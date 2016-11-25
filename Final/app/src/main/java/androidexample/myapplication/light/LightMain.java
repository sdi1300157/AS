package androidexample.myapplication.light;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.Toast;

public class LightMain  implements SensorEventListener {



    private SensorManager mSensorManager;
    public Sensor mLight;
    //private Vibrator v;
    //private Toast toast = null;
    public SensorManager mSensorManager1;
    public Sensor mProximity;
    public Vibrator v;
    public Toast toast = null;
    public static Context aContext = null;
    TextView tvX;
    //public static int Light_Interval=0;
  
    public static Boolean supported;
    //seekbar=this.Light_Interval;

    public LightMain(SensorManager mSensorManager,Vibrator v,Toast toast,TextView tvX) {
        //super.onCreate(savedInstanceState);
        //seekbar=this.Light_Interval;
        //setContentView(R.layout.light);
        //this.Light_Interval=a;
        this.mSensorManager=mSensorManager;
        this.v=v;
        this.toast=toast;
        this.tvX=tvX;
        //mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
        //v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);


    }

    protected void onResume() {
        //super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);


    }


    protected void onPause() {
        //super.onPause();
        mSensorManager.unregisterListener(this);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        ///
    }

    @Override
    public void onSensorChanged(SensorEvent event) {


        float x = event.values[0];
        tvX.setText(Float.toString(x));


        if (x < 5) {//ringtone();
            //v.vibrate(500);
            //Toast.makeText(getBaseContext(),"inserted",Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
            //toast.setText(String.valueOf(Light_Interval));

            //toast.setText(String.valueOf(Light_Interval)+"inserted Light!");
            //toast.show();
        }
        ;


    }
}
//}
