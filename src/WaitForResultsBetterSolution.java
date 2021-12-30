import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class WaitForResultsBetterSolution {

    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        CompletionService<Character> cs =
                new ExecutorCompletionService<>(pool);

        for (char c : alphabet) {
            cs.submit(new UpperCaseTask(c));
        }

        pool.shutdown();

        for (int i = alphabet.length; i > 0; i--) {
            try {
                Character c = cs.take().get();
                System.out.println(c);
            } catch (InterruptedException | ExecutionException ignored) {
            }
        }
    }
}
