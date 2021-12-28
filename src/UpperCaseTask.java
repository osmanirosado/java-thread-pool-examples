import java.util.concurrent.Callable;

public class UpperCaseTask implements Callable<Character> {
    private final char taskName;

    public UpperCaseTask(char taskName) {
        this.taskName = taskName;
    }

    @Override
    public Character call() {
        return Character.toUpperCase(taskName);
    }
}
