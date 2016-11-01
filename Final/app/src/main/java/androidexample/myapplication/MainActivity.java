package androidexample.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ebakyt.androidsensors.R;


import androidexample.myapplication.accelerometer.AcceleroMain;

import androidexample.myapplication.light.LightMain;

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
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
