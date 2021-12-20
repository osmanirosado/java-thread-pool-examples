import java.util.concurrent.*;


public class FixedThreadPoolExample {
    private static final char[] alphabet =
            "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        int numThreads = 4;

        ExecutorService pool =
                Executors.newFixedThreadPool(numThreads);

        for (char c : alphabet) {
            pool.execute(new Task(c));
        }

        pool.shutdown();
    }
}
