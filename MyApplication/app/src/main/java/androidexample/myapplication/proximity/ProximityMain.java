package androidexample.myapplication.proximity;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.Toast;

import androidexample.myapplication.MainActivity;

public class ProximityMain extends Activity implements SensorEventListener {

    public static int Proximity_Interval = 0;
    public static Boolean supported;
    public Sensor mProximity;
    public Vibrator v;
    public Toast toast = null;
    TextView tvX1;
    private SensorManager mSensorManager;

    public ProximityMain(SensorManager mSensorManager, Vibrator v, Toast toast, TextView tvX1, int a) {

        this.Proximity_Interval = a;
        this.mSensorManager = mSensorManager;
        this.v = v;
        this.toast = toast;
        this.tvX1 = tvX1;
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_FASTEST);
    }

    protected void onResume() {

        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_FASTEST);
    }

    protected void onPause() {

        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

        if (accuracy >= 5) MainActivity.ringtone();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float x = event.values[0];
        if (x < MainActivity.Proximity_Interval) {
            MainActivity.ringtone();
            if (v.hasVibrator()) {
                v.vibrate(500);
            }
            toast.setText("Proximity Sensor");
            toast.show();
        }
        ;
        tvX1.setText(Float.toString(x));
    }
}