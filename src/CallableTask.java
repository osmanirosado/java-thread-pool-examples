import java.util.concurrent.Callable;

public class CallableTask implements Callable<Character> {
    private final char taskName;

    public CallableTask(char taskName) {
        this.taskName = taskName;
    }

    @Override
    public Character call() {
        return Character.toUpperCase(taskName);
    }
}
