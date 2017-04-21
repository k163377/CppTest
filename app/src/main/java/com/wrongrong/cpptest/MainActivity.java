package com.wrongrong.cpptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.sample_text);
        String ln = System.lineSeparator();
        JavaForTest jft = new JavaForTest();
        int i,j=0;
        long jftS,jftE,cppS,cppE;

        for(i = 0;i < 200000000;i++)j += i;

        jftS = System.currentTimeMillis();
        i = jft.javaForTest();
        jftE = System.currentTimeMillis();

        cppS = System.currentTimeMillis();
        j = cppForTest();
        cppE = System.currentTimeMillis();

        //出力の整形
        StringBuilder sb = new StringBuilder(String.valueOf(i - j)); sb.append(ln);
        sb.append("Java:"); sb.append(String.valueOf(jftE - jftS)); sb.append(ln);
        sb.append("C++:"); sb.append(String.valueOf(cppE - cppS)); sb.append(ln);
        sb.append("Java/C++:"); sb.append(String.valueOf((double)(jftE - jftS) / (double)(cppE - cppS)));

        tv.setText(sb.toString());
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
