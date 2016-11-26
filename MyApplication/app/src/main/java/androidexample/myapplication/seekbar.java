package androidexample.myapplication;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;


public class seekbar {

    public static int Progress;
    public SeekBar seekBar;
    public Toast toast;
    protected TextView textView;

    public seekbar(Toast toast, SeekBar seekBar, TextView textView) {

        this.seekBar = seekBar;
        this.seekBar.setMax(18);
        this.textView = textView;
        this.seekBar.setProgress(MainActivity.Light_Interval);
        this.toast = toast;
        toast.setText("Covered: " + seekBar.getProgress() + "/" + seekBar.getMax());
    }


    public void exec() {

        toast.setText("Covered: " + seekBar.getProgress() + "/" + seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                Progress = progresValue;
                MainActivity.set(Progress);
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

                seekbar.this.textView.setText("Covered: " + Progress + "/" + seekBar.getMax());
                toast.setText("Stopped tracking seekbar");
                toast.show();
            }
        });
    }

    public void set_pr(int a) {
        Progress = a;
    }

    public int pr() {
        return this.seekBar.getProgress();
    }
    // A private method to help us initialize our variables.
}