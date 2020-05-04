import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

class PrintStackTraceDemo {
    public static void x() {
        try {
            a();
        } catch (IOException ioe) {//this way of stack trace output is workaround for moodle
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(byteArrayOutputStream);
            ioe.printStackTrace(ps);
            System.out.println(byteArrayOutputStream);
        }
    }

    static void t() throws IOException {

        throw new IOException();
    }

    public static void a() throws IOException {
        m();

    }
    static void m() throws IOException {
               t();
    }
}
