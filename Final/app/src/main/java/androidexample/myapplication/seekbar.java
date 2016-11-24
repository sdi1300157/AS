package androidexample.myapplication;

/**
 * Created by Vaggelis on 26-Oct-16.
 */
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class seekbar {
//settings
    public  SeekBar seekBar;
    protected TextView textView;

    public static int Progress;
    public Toast toast;

public seekbar( Toast toast,SeekBar seekBar, TextView textView){
    //this.Progress=a;
    this.seekBar=seekBar;
    this.textView=textView;
    this.toast=toast;}


    public void exec(){
        //seekBar.setProgress(Progress);

        // Initialize the textview with '0'.
       toast.setText("Covered: " + seekBar.getProgress() + "/" +seekBar.getMax());


        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {




            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                Progress = progresValue;
                //Progress=seekBar.getProgress();
                toast.setText(String.valueOf(Progress));
                toast.show();

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
                toast.setText("Started tracking seekbar");
                toast.show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbar.this.textView.setText("Covered: " + Progress + "/" + seekBar.getMax());
                //Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
                toast.setText("Stopped tracking seekbar");
                toast.show();
            }
        });
    }
public void set_pr(int a){
    Progress=a;
}
    public int pr(){return seekBar.getProgress();}
    // A private method to help us initialize our variables.
    private void initializeVariables() {


    }
}