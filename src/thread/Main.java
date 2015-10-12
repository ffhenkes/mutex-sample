package thread;

import java.util.Random;

/**
 * Java Mutex example
 */
class Mutex extends Thread {

    private static final Random rand = new Random();

    private static final int[] mutation = new int[100];

    private int orbital = -1;

    private int threadId;

    /* Construct a Mutex and gives an identifier */
    public Mutex(int i) {
        threadId = i;
    }

    /* The array manipulation itself */
    private void busy() {
        try {
            sleep(rand.nextInt(500));

            orbital++;

            if (mutation[orbital] == 0) {
                mutation[orbital] = rand.nextInt();
            }

            System.out.println("Mutation gene is " + mutation[orbital] + " in orbital " + orbital + " with threadId " + threadId);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* Control the mutex */
    private synchronized void critical() {

        System.out
                .println("Thread " + threadId + " is entering the critical section");
        busy();
        System.out.println("Thread " + threadId + " is leaving the critical section");

    }

    /* Call critical with a lock modifier */
    public void run() {
        for (int i = 0; i < 100; ++i) {
            critical();
        }
    }

    /* Start and array of processes (threads) */
    public static void main(String[] args) {
        int N = 2;
        Mutex[] processes = new Mutex[N];

        for (int i = 0; i < N; i++) {
            processes[i] = new Mutex(i);
            processes[i].start();
        }
    }
}