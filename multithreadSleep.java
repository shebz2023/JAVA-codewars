import java.util.*;

class myRunnable implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 5; i++) {
                Thread.sleep(1000);
            }
            System.out.println("time ends");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("=====error===" + e);
        }
    }

}

public class multithreadSleep {
    public static void main(String[] args) {
        System.out.println("Enter your name in 5 seconds");
        Thread z = new Thread(new myRunnable());
        z.setDaemon(true);
        z.start();
        Scanner x = new Scanner(System.in);
        x.nextLine();
        x.close();
    }
}
