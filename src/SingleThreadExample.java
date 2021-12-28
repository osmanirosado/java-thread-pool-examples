import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExample {
    private static final char[] alphabet =
            "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        for (char c : alphabet) {
            pool.execute(new PrintTask(c));
        }

        pool.shutdown();
    }
}
