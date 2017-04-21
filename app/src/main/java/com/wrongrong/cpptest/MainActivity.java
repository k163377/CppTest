package com.wrongrong.cpptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        JavaForTest jft = new JavaForTest();
        int i,j;
        long jftS,jftE,cppS,cppE;

        jftS = System.currentTimeMillis();
        i = jft.javaForTest();
        jftE = System.currentTimeMillis();

        cppS = System.currentTimeMillis();
        j = cppForTest();
        cppE = System.currentTimeMillis();

        tv.setText(String.valueOf(i - j) + ",java-cpp:" + String.valueOf((double)((jftE - jftS) - (cppE - cppS))/1000));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();
    //public native int cppRint(int i);
    //public native double cppDouble();]
    public native int cppForTest();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
