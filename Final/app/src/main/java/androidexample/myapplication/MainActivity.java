package androidexample.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ebakyt.androidsensors.R;

import androidexample.myapplication.acceleration.LinAcceleroMain;
import androidexample.myapplication.accelerometer.AcceleroMain;
import androidexample.myapplication.gyroscope.GyroMain;
import androidexample.myapplication.light.LightMain;
import androidexample.myapplication.magnetometer.MagnetoMain;
import androidexample.myapplication.pressure.PressureMain;
import androidexample.myapplication.proximity.ProximityMain;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btsettings = (Button) findViewById(R.id.btnsettings);
		btsettings.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, seekbar.class));

			}
		});
		Button btAccelo = (Button) findViewById(R.id.btnAccelerometer);
		btAccelo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {				
				startActivity(new Intent(MainActivity.this, AcceleroMain.class));
				//startActivity(new Intent(MainActivity.this, GyroMain.class));
				startActivity(new Intent(MainActivity.this, ProximityMain.class));
			}
		});
        
        Button btGyro = (Button) findViewById(R.id.btnGyroscope);
        btGyro.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, GyroMain.class));
			}
		});
        
        Button btLight = (Button) findViewById(R.id.btnLight);
        btLight.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, LightMain.class));
			}
		});
        
        Button btLinAccelo = (Button) findViewById(R.id.btnLinearAcceleration);
        btLinAccelo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {				
				startActivity(new Intent(MainActivity.this, LinAcceleroMain.class));
			}
		});
        
        Button btMagneto = (Button) findViewById(R.id.btnMagnetometer);
        btMagneto.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {				
				startActivity(new Intent(MainActivity.this, MagnetoMain.class));
			}
		});
        
        Button btPress = (Button) findViewById(R.id.btnPressure);
        btPress.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {				
				startActivity(new Intent(MainActivity.this, PressureMain.class));
			}
		});
        
        Button btProxi = (Button) findViewById(R.id.btnProximity);
        btProxi.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {				
				startActivity(new Intent(MainActivity.this, ProximityMain.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
