package androidexample.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ebakyt.androidsensors.R;

import androidexample.myapplication.accelerometer.AcceleroMain;
import androidexample.myapplication.light.LightMain;
import androidexample.myapplication.proximity.ProximityMain;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends Activity {

    public ProximityMain prox;
    private SensorManager mSensorManager;
    public LightMain ligh;
    public AcceleroMain accel;
    public Vibrator v;
    public Toast toast = null;
    public ImageView imageView;
    TextView tvX;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_1);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

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
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
        TextView tvX = (TextView) findViewById(R.id.textViewX);
        TextView tvY = (TextView) findViewById(R.id.textViewX);
        TextView tvZ = (TextView) findViewById(R.id.textViewX);
        ligh= new LightMain(mSensorManager,v,toast,tvX);
        prox= new ProximityMain(mSensorManager,v,toast,tvX);
        accel= new AcceleroMain(mSensorManager,toast,tvX,tvY,tvZ);
		Button btsettings = (Button) findViewById(R.id.btnsettings);
		btsettings.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//startActivity(new Intent(MainActivity.this, seekbar.class));
                //startActivity(new Intent(MainActivity.this, AcceleroMain.class));
                //startActivity(new Intent(MainActivity.this, ProximityMain.class));
               // startActivity(new Intent(MainActivity.this, LightMain.class));

               // ligh=new LightMain();
                //ligh.onCreate(savedInstanceState);

                //ligh= new LightMain(LightMain.this);





			}
		});
		/*Button btAccelo = (Button) findViewById(R.id.btnAccelerometer);
		btAccelo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, AcceleroMain.class));

			}
		});



        Button btLight = (Button) findViewById(R.id.btnLight);
        btLight.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, LightMain.class));
			}
		});


        Button btProxi = (Button) findViewById(R.id.btnProximity);
        btProxi.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, ProximityMain.class));
			}

		});*/




	}
    /*
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		switch (id) {
			case R.id.action_settings:
				Intent toy = new Intent(MainActivity.this, seekbar.class);
				startActivity(toy);
				break;
			case R.id.menu_exit:
				//onBackPressed();
				finish();
				break;
		}

		return super.onOptionsItemSelected(item);

	}*/
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_settings);
        item.setOnMenuItemClickListener(new OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                MainActivity.this.someFunctionInYourActivity();
                return true;
            }
        });
        return true;
    }*/
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
                Intent toy = new Intent(MainActivity.this, seekbar.class);
                startActivity(toy);
                //break;
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
