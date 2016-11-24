package androidexample.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ebakyt.androidsensors.R;

/**
 * Created by Vaggelis on 24-Nov-16.
 */

public class seekbar1 extends Activity {

    //settings
    private SeekBar seekBar1;
    private TextView textView_P;


    public  int Proximity_Interval=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        initializeVariables();

        // Initialize the textview with '0'.

        textView_P.setText("Covered: " + seekBar1.getProgress() + "/" + seekBar1.getMax());


        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar1, int progresValue, boolean fromUser) {
                Proximity_Interval = progresValue;
                Toast.makeText(getApplicationContext(), String.valueOf(Proximity_Interval), Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar1) {
                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar1) {
                textView_P.setText("Covered: " + Proximity_Interval + "/" + seekBar1.getMax());
                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public  int pr(){
        return Proximity_Interval;
    }
    // A private method to help us initialize our variables.
    private void initializeVariables() {

        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);

        textView_P = (TextView) findViewById(R.id.textView13);

    }
}
