import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class WaitForResultsExample {

    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        ArrayList<Future<Character>> results = new ArrayList<>(alphabet.length);

        for (char c : alphabet) {
            Future<Character> future = pool.submit(new UpperCaseTask(c));
            results.add(future);
        }

        pool.shutdown();

        for (Future<Character> result : results) {
            try {
                Character c = result.get();
                System.out.println(c);
            } catch (InterruptedException | ExecutionException ignored) {
            }
        }
    }
}
