import java.util.Scanner;

/**
 * create By  on 2020/11/9.
 */
public class ThreadTest extends Thread {
    private int index;
    private int x;
    static long ans=0;
    public ThreadTest(int index,int x) {
        this.index = index;this.x=x;
    }

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        for (int i = 0; i < 10; i++) {
            Thread t= new ThreadTest(i,x);
            t.start();
        }
        while(Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(ans);
        long endTime=System.currentTimeMillis();
        System.out.println("Time:"+(endTime-startTime));
    }
    public synchronized void run(){//100000000
        for(long  i=index*100000000;i<(index+1)*100000000;i++){
            if(contain(i,x)){
                ans+=i;
            }
        }
    }
    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
}
