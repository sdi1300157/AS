package androidexample.myapplication.light;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.Toast;

import androidexample.myapplication.MainActivity;

public class LightMain extends Activity implements SensorEventListener {

    public Sensor mLight;
    public Vibrator v;
    public Toast toast = null;
    TextView tvX;
    private SensorManager mSensorManager;

    public LightMain(SensorManager mSensorManager, Vibrator v, Toast toast, TextView tvX) {

        this.mSensorManager = mSensorManager;
        this.v = v;
        this.toast = toast;
        this.tvX = tvX;
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onResume() {

        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
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
        tvX.setText(Float.toString(x));

        if (x < MainActivity.Light_Interval) {//ringtone();
            MainActivity.ringtone();
            if (v.hasVibrator()) {
                v.vibrate(500);
            }
            toast.setText("Light Sensor");
            toast.show();
        }
    }
}