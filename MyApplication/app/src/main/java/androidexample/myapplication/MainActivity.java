package androidexample.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidexample.myapplication.accelerometer.AcceleroMain;
import androidexample.myapplication.light.LightMain;
import androidexample.myapplication.proximity.ProximityMain;

public class MainActivity extends Activity {

    public ProximityMain prox;
    private SensorManager mSensorManager,mSensorManager_P,mSensorManager_A;
    public LightMain ligh;
    public AcceleroMain accel;
    public Vibrator v;
    public static int Proximity_Interval=10;
    public static int Accelero_Interval=10;
    public static int  Light_Interval=10;
    public Toast toast = null;
    public static Ringtone r;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        r = RingtoneManager.getRingtone(getApplicationContext(), notification);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayOptions(actionBar.DISPLAY_USE_LOGO | ActionBar.DISPLAY_SHOW_CUSTOM);
        ImageView imageView = new ImageView(actionBar.getThemedContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.mipmap.ic_launcher);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        layoutParams.rightMargin = 40;
        imageView.setLayoutParams(layoutParams);
        actionBar.setCustomView(imageView);
        actionBar.setDisplayShowTitleEnabled(true);


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager_P= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager_A= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);

        TextView tvX = (TextView) findViewById(R.id.textViewX);
        TextView tvX1 = (TextView) findViewById(R.id.textViewX1);
        TextView tvXX = (TextView) findViewById(R.id.textViewXX);
        TextView tvY = (TextView) findViewById(R.id.textViewY);
        TextView tvZ = (TextView) findViewById(R.id.textViewZ);
        ligh= new LightMain(mSensorManager,v,toast,tvX);
        prox= new ProximityMain(mSensorManager_P,v,toast,tvX1,Proximity_Interval);
        accel= new AcceleroMain(mSensorManager_A,toast,tvXX,tvY,tvZ,Accelero_Interval);

    }

    public static void ringtone() {
        try {
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public static int ret(){
        return Light_Interval;
    }
    public static void set(int a){
        Light_Interval=a;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getBaseContext(),"Settings selected", Toast.LENGTH_SHORT).show();

                Intent cla = new Intent(MainActivity.this,Settings.class);
                startActivity(cla);

                toast.setText(String.valueOf(Light_Interval));
                toast.show();

                return true;

            case R.id.menu_exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setMessage("Do you want to Exit?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                        Toast.makeText(getBaseContext(),"Exit app",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}