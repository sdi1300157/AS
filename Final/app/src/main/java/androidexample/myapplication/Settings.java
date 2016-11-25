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

public class Settings extends Activity {
    //public static int Proximity_Interval=0;
    //public int Accelero_Interval=0;
    //public   static int Light_Interval;
    public Toast toast1;

    public SeekBar seekBar,seekBar1,seekBar2;
    public seekbar toy;
    public seekbar1 toy1;
    public seekbar2 toy2;
    public TextView textView,textView1,textView2;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        toast1 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setProgress(MainActivity.ret());
        textView = (TextView) findViewById(R.id.textView1);
        toy=new seekbar(toast1,seekBar,textView);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        textView1 = (TextView) findViewById(R.id.textView13);
        seekBar1.setProgress(MainActivity.Proximity_Interval);
        toy1=new seekbar1(toast1,seekBar1,textView1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        textView2 = (TextView) findViewById(R.id.textView16);
        seekBar2.setProgress(MainActivity.Accelero_Interval);
        toy2=new seekbar2(toast1,seekBar2,textView2);

        //toy.set_pr(Light_Interval);
        toy.exec();
        //MainActivity.set(toy.pr());
        //toast1.setText(String.valueOf(MainActivity.ret())+" <------");
        //toast1.show();
        //toy.set_pr(Light_Interval);


        toy1.exec();
        //Proximity_Interval=toy1.pr();



        toy2.exec();
        //Accelero_Interval=toy2.pr();










    }

   /* public static void Set_Light_Var(int a){
        Light_Interval=a;
    }
    public static int  Read_Light_Var(){return Light_Interval;}*/







}
