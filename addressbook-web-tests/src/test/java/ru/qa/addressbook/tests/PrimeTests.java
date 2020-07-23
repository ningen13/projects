package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.sandbox.Primes;

public class PrimeTests {

    @Test(enabled = false)
    public void testPrimes() {
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }


    @Test(enabled = false)
    public void testNonPrimes() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE -2));
    }

    @Test(enabled = false)
    public void testPrimeLong() {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }
}
