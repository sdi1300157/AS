package androidexample.myapplication;

/**
 * Created by Vaggelis on 26-Oct-16.
 */
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
//import androidexample.myapplication.MainActivity.Light_interval;

public class seekbar1 {
    //settings
    public  SeekBar seekBar;
    protected TextView textView;

    public static int Progress;
    public Toast toast;

    public seekbar1( Toast toast,SeekBar seekBar, TextView textView){
        //this.Progress=a;
        this.seekBar=seekBar;
        this.textView=textView;
        //this.seekBar.setProgress(MainActivity.Light_Interval);
        this.toast=toast;
        toast.setText("Covered: " + seekBar.getProgress() + "/" +seekBar.getMax());

    }


    public void exec(){
        //seekBar.setProgress(Progress);
        //this.seekBar.setProgress(MainActivity.ret());
        // Initialize the textview with '0'.
        toast.setText("Covered: " + seekBar.getProgress() + "/" +seekBar.getMax());


        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {




            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                Progress = progresValue;
                //Progress=seekBar.getProgress();
                MainActivity.Proximity_Interval=Progress;
                toast.setText(String.valueOf(Progress));
                toast.show();

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                toast.setText("Started tracking seekbar");
                toast.show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbar1.this.textView.setText("Covered: " + Progress + "/" + seekBar.getMax());

                toast.setText("Stopped tracking seekbar");
                toast.show();
            }
        });
    }
    public void set_pr(int a){
        Progress=a;
    }
    public int pr(){return this.seekBar.getProgress();}


    // A private method to help us initialize our variables.

}