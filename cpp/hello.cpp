//#include <linux/jni_md.h>
#include <jni.h>
//#include <jvmti.h>
#include <lc_Hello.h>
#include <cstdlib>
#include <cstring>
#include <string>

JNIEXPORT jstring JNICALL Java_lc_Hello_greetTo
  (JNIEnv *env, jobject obj, jstring str)
{
    std::string* s = new std::string();
    //jsize size = s->size();
    const char* word = env->GetStringUTFChars(str, 0);
    s->append(word);
    s->append(", 欢迎您来到神奇的地球！");
    str = env->NewStringUTF(s->c_str());
    return str;
}
