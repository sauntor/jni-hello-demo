package lc;

public class Hello
{
    static {
        System.loadLibrary("hello");
    }
    public native String greetTo(String name);
}
