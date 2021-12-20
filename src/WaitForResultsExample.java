import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class WaitForResultsExample {

    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        int numThreads = 4;
        ArrayList<Future<Character>> results = new ArrayList<>(alphabet.length);

        ExecutorService pool = Executors.newFixedThreadPool(numThreads);

        for (char c : alphabet) {
            results.add(pool.submit(new CallableTask(c)));
        }

        for (Future<Character> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();
    }
}
