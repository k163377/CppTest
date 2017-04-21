#include <jni.h>
#include <string>

/*extern "C"
JNIEXPORT jstring JNICALL
Java_com_wrongrong_cpptest_MainActivity_stringFromJNI(JNIEnv* env, jobject) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_wrongrong_cpptest_MainActivity_cppRint(JNIEnv* env, jobject obj,jint v){
    int i = 6;
    return v + i;
}

extern "C"
JNIEXPORT jdouble JNICALL Java_com_wrongrong_cpptest_MainActivity_cppDouble(JNIEnv* env, jobject obj){
    double d = 0.5;
    return d;
}*/

extern "C"
JNIEXPORT jint JNICALL Java_com_wrongrong_cpptest_MainActivity_cppForTest(JNIEnv* env, jobject obj){
    int i,j;
    j = 0;

    for(i = 0;i < 200000000;i++){
        if(i&1 == 1)j++;
    }
    return j;
}