package androidexample.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ebakyt.androidsensors.R;

import androidexample.myapplication.accelerometer.AcceleroMain;
import androidexample.myapplication.light.LightMain;
import androidexample.myapplication.proximity.ProximityMain;

public class MainActivity extends Activity {

    public ProximityMain prox;
    private SensorManager mSensorManager,mSensorManager_P,mSensorManager_A;
    public LightMain ligh;
    public AcceleroMain accel;
    public Vibrator v;
    public  int Proximity_Interval=0;
    public int Accelero_Interval=0;
    public int Light_Interval=0;
    public Toast toast = null;
    public Toast toast1 = null;
    public ImageView imageView;
    public SeekBar seekBar,seekBar1,seekBar2;
    public seekbar toy,toy1,toy2;
    public TextView textView,textView1,textView2;
    //TextView tvX;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_1);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

        //toast1 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
         seekBar = (SeekBar) findViewById(R.id.seekBar);
         textView = (TextView) findViewById(R.id.textView1);
         toy=new seekbar(toast,seekBar,textView);
         seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
         textView1 = (TextView) findViewById(R.id.textView13);
         toy1=new seekbar(toast,seekBar1,textView1);
         seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
         textView2 = (TextView) findViewById(R.id.textView16);
         toy2=new seekbar(toast,seekBar2,textView2);

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

//prox=new ProximityMain();
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
        ligh= new LightMain(mSensorManager,v,toast,tvX,Light_Interval);
        prox= new ProximityMain(mSensorManager_P,v,toast,tvX1,Proximity_Interval);
        accel= new AcceleroMain(mSensorManager,toast,tvXX,tvY,tvZ,Accelero_Interval);

	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getBaseContext(),"Settings selected", Toast.LENGTH_SHORT).show();

                setContentView(R.layout.settings);


                toy.exec(seekBar);
                Light_Interval=toy.pr();
                ligh.change(Light_Interval);


                //toy1.exec();
                Proximity_Interval=toy1.pr();
                prox.change(Proximity_Interval);


               // toy2.exec();
                Accelero_Interval=toy2.pr();
                accel.change(Accelero_Interval);
                return true;
            case R.id.menu_exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setMessage("Do you want to Exit?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if user pressed "yes", then he is allowed to exit from application
                        finish();
                        Toast.makeText(getBaseContext(),"Exit app",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if user select "No", just cancel this dialog and continue with app
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
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
