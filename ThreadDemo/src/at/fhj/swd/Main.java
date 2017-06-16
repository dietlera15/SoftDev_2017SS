package at.fhj.swd;

public class Main {

    public static void main(String[] args) {
        int from = 1;
        int to = 150000;


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long count1 = PrimeUtil.countPrimes(from,to/2);
                System.out.println("Number of primes (1):  " + count1);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long count2 = PrimeUtil.countPrimes(to/2, to);
                System.out.println("Number of primes (2):  " + count2);
            }
        });


        System.out.println("Starting Thread 1");
        //t1.start();
        System.out.println("Starting Thread 2");
        t2.start();


        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){

        }
        System.out.println("Calculation finished");


    }
}
