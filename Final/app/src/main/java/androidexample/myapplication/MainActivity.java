package androidexample.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.ebakyt.androidsensors.R;

import androidexample.myapplication.light.LightMain;
import androidexample.myapplication.proximity.ProximityMain;
//test comment
public class MainActivity extends Activity {

public ProximityMain prox;
    public LightMain ligh;
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_1);
//prox=new ProximityMain();
       // ligh= new LightMain();
		Button btsettings = (Button) findViewById(R.id.btnsettings);
		btsettings.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//startActivity(new Intent(MainActivity.this, seekbar.class));
                //startActivity(new Intent(MainActivity.this, AcceleroMain.class));
                startActivity(new Intent(MainActivity.this, ProximityMain.class));
                startActivity(new Intent(MainActivity.this, LightMain.class));

                //ligh=new LightMain();
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
                Toast.makeText(getBaseContext(),"Exit app",Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
