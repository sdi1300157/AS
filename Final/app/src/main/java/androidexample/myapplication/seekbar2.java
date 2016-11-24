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

public class seekbar2 extends Activity {

    //settings
    private SeekBar seekBar2;
    private TextView textView_A;

    public int Accelero_Interval=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        initializeVariables();


        textView_A.setText("Covered: " + seekBar2.getProgress() + "/" + seekBar2.getMax());

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                Accelero_Interval = progresValue;
                Toast.makeText(getApplicationContext(), String.valueOf(Accelero_Interval), Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView_A.setText("Covered: " + Accelero_Interval + "/" + seekBar.getMax());
                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public int pr(){
        return Accelero_Interval;
    }
    // A private method to help us initialize our variables.
    private void initializeVariables() {

        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);

        textView_A = (TextView) findViewById(R.id.textView16);
    }
}
