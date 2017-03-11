package lc;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;

public class Launcher {
    public static void main(String[] args) throws Throwable {
        addLibraryPath();
        Hello hello = new Hello();
        String msg = hello.greetTo("适然");
        System.out.println("Greeting message from \"hello\":\n" + msg);
    }

    static void addLibraryPath() throws Throwable {
        Class<ClassLoader> cl = ClassLoader.class;
        Field lpath;
        try {
            URL url = Launcher.class.getResource("Launcher.class");
            String s = url.toString();
            s = s.substring("jar:file:".length(), s.indexOf("!"));
            File file = new File(new File(s).getParentFile(), "./lib64");
            String path = file.getCanonicalPath();
            lpath = cl.getDeclaredField("sys_paths");
            if (!lpath.isAccessible()) {
                lpath.setAccessible(true);
            }
            String[] paths = (String[])lpath.get(cl);
            String[] modified = new String[paths.length + 1];
            System.arraycopy(paths, 0, modified, 0, paths.length);
            modified[paths.length] = path;
            lpath.set(cl, modified);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
