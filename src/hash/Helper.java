package hash;

class Helper {
    public static int nextPrime(int i) {
        for (i += 2; true; i += 2)
            if (isPrime(i))
                return i;
    }

    public static boolean isPrime(int p) {
        for (int i = 3; (long) i * i <= p; i += 2)
            if (p % i == 0)
                return false;
        return true;
    }
}
