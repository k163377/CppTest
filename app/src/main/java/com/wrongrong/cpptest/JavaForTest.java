package com.wrongrong.cpptest;

/**
 * Created by bntwng on 2017/04/22.
 */

public class JavaForTest {
    public int javaForTest(){
        int i,j;
        j = 0;

        for(i = 0; i < 200000000; i++){
            if((i&1) == 1)j++;
        }

        return j;
    }
}
