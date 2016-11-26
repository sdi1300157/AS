package androidexample.myapplication.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.Toast;

import androidexample.myapplication.MainActivity;

public class AcceleroMain implements SensorEventListener {

    public Sensor mAccelerometer;
    public Toast toast = null;
    public Vibrator v;
    TextView tvX;
    TextView tvY;
    TextView tvZ;
    private SensorManager mSensorManager;
    private int Accelerometer_Interval = 0;

    public AcceleroMain(SensorManager mSensorManager, Vibrator v, Toast toast, TextView tvX, TextView tvY, TextView tvZ, int a) {

        this.Accelerometer_Interval = a;
        this.mSensorManager = mSensorManager;
        this.v = v;
        this.toast = toast;
        this.tvX = tvX;
        this.tvY = tvY;
        this.tvZ = tvZ;
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onResume() {

        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
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
        float y = event.values[1];
        float z = event.values[2];
        tvX.setText(Float.toString(x));
        tvY.setText(Float.toString(y));
        tvZ.setText(Float.toString(z));
        if (z > MainActivity.Accelero_Interval || z < (-1 * MainActivity.Accelero_Interval)) {
            MainActivity.ringtone();
            if (v.hasVibrator()) {
                v.vibrate(500);
            }
            toast.setText("Accelerometer Sensor --> \n Hold your phone to the right Angle");
            toast.show();
        }
    }
}