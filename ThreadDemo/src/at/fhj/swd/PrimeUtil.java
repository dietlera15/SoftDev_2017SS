package at.fhj.swd;

public class PrimeUtil {

    public static boolean isPrime(long number){
        if (number == 1)
            return false;
        if (number == 2)
            return true;
        if(number % 2 == 0)
            return false;
        for (int i = 3; i <= number/2; i++)
            if (number % i == 0)
                return false;
        return true;
    }

    public static long countPrimes(long from, long to){
        if(from > to) throw new IllegalArgumentException("must be from  > to");
        long count = 0;
        for(long i = from; i <= to;i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;

    }


}
