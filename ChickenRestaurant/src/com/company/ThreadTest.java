import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * create By  on 2020/11/9.
 */
public class ThreadTest {
    static int x;
    static long ans=0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            TaskThread t= new TaskThread(i*100000000,(i+1)*100000000);
            FutureTask futureTask=new FutureTask(t);
            new Thread(futureTask).start();
            ans+=(long)futureTask.get();
        }
        System.out.println(ans);
        long endTime=System.currentTimeMillis();
        System.out.println("Time:"+(endTime-startTime));
    }
    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
    static class TaskThread implements Callable {
        private long s, e;
        public TaskThread(long s, long e) {
            this.s = s;
            this.e = e;
        }
        @Override
        public Object call(){
            long result = 0;
            for (long i = s; i <e; i++) {
                if (contain(i,x)) {
                    result += i;
                }
            }
            return result;
        }
    }

}
