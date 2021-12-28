class PrintTask implements Runnable {

    private final char taskName;

    public PrintTask(char taskName) {
        this.taskName = taskName;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        String msg = String.format(
                "Task '%s' is running on thread '%s'",
                taskName, threadName);
        System.out.println(msg);
    }
}