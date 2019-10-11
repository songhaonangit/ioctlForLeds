package com.getcharmsmart.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
      //  Log.d("MainActivity","------open():"+open());
        Log.d("MainActivity","------ioctl():"+ioctl(1,1));
        Log.d("MainActivity","------ioctl():"+ioctl(2,0));
        Log.d("MainActivity","------ioctl():"+ioctl(3,1));
      //  Log.d("MainActivity","------close():"+close());

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native int open();
    public native int close();
    public native int ioctl(int cmd ,int flag);
}
