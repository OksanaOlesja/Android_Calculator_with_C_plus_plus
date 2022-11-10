
#include <iostream>
#include <jni.h>
#include <string>

extern "C"
JNIEXPORT void JNICALL
Java_com_example_calculator_JNIHelloWorld_printHelloWorld(JNIEnv *env, jobject thiz) {
    std::cout << "Hello world!";
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_calculator_JNIHelloWorld_printHelloFromCNumber(JNIEnv *env, jobject thiz) {
    return 101010;
}