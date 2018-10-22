package simpleSimulationConcurrency;


/**
 * 场景：java简单模拟并发场景
 * 1.开启n个线程，加上闭锁，开启其他线程
 * 2.待所有线程都准备好后，打开闭锁，释放所有线程
 *
 * @author Wang
 */
public class Main {

    public static void main(String[] args) {
        Runnable taskTemp = new Runnable() {
            //注意：此变量是非线程安全的
            private int iCounter;

            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                int cycleIndex = 10;
                for (int i = 0; i < cycleIndex; i++) {
                    iCounter++;
                    System.out.println(System.nanoTime() + "[" + Thread.currentThread().getName() + "] iCounter = "
                            + iCounter);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}
