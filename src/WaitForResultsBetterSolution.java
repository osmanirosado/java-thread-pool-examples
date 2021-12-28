import java.util.concurrent.*;


public class WaitForResultsBetterSolution {

    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        int numThreads = 4;

        ExecutorService pool = Executors.newFixedThreadPool(numThreads);
        CompletionService<Character> cs = new ExecutorCompletionService<>(pool);

        for (char c : alphabet) {
            cs.submit(new UpperCaseTask(c));
        }

        for (int i = alphabet.length; i > 0; i--) {
            try {
                Character result = cs.take().get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();
    }
}
