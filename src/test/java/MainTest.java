import org.junit.Test;
import javax.swing.event.MouseInputAdapter;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {
    Main obj = new Main();

    @Test
    public void countSetBits() {
        // du path 1-2-13 for variable n
        assertEquals(0, Main.countSetBits(0));
        // du path 1-2-3-4-5-6-8-9-11-4-12-2-13 for variable i
        assertEquals(7, Main.countSetBits(5));
        // du path 1-2-3-4-5-7-8-10-11-4-12-2-13 for variable j
        assertEquals(32, Main.countSetBits(15));
        // du path 1-2-3-4-5-6-8-10-11-4-12-2-13 variable for variable change
        assertNotEquals(13, Main.countSetBits(7));
        // du path 1-2-3-4-5-7-8-9-11-4-12-2-13 for variable k
        assertEquals(2, Main.countSetBits(2));
        // du path 1-2-3-4-12-2-13 for variable n,i,j
        assertEquals(1, Main.countSetBits(1));
        System.out.println("Testing Completed : countSetBits");
    }

    @Test
    public void isPrime() {
        // du path 1-2-3 for variable n
        assertEquals(false, obj.isPrime(1));
        assertNotEquals(true, obj.isPrime(-5));
        // du path 1-2-4-5 for variable n
        assertNotEquals(false, obj.isPrime(3));
        assertEquals(true, obj.isPrime(2));
        // du path 1-2-4-6-7 for variable n
        assertEquals(false, obj.isPrime(10));
        assertNotEquals(true, obj.isPrime(15));
        // du path 1-2-4-6-8-9-10 for variable i
        assertEquals(true, obj.isPrime(5));
        // du path 1-2-4-6-8-9-11-13-9-11-12 for variable i
        assertEquals(false, obj.isPrime(1000000005));
        System.out.println("Testing Completed : isPrime");

    }

    @Test
    public void isPalindrome() {
        // du path 1-2-6 for variable i,j
        assertEquals(true, obj.isPalindrome(""));
        // du path 1-2-3-4 for str
        assertEquals(false, obj.isPalindrome("abaa"));

        // du path 1-2-3-5-2-6 for variable j
        assertEquals(true, obj.isPalindrome("aaabaaa"));

        // du path 1-2-3-5-2-6 for variable i
        assertNotEquals(true, "abab");
        System.out.println("Testing Completed : isPalindrome");
    }

    @Test
    public void min() {
        // du path 1-2-3-7 for variable i,min,arr
        ArrayList arr1 = new ArrayList<>(Arrays.asList());
        assertEquals(Integer.MAX_VALUE, obj.min(arr1));
        // du path 1-2-3-4-5-6-3-7 variable min
        ArrayList arr2 = new ArrayList<>(Arrays.asList(7, 1, 2, 5, 0, 8));
        assertEquals(0, obj.min(arr2));
        // du path 1-2-3-4-6-3-7 for variable i
        ArrayList arr3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(1, obj.min(arr3));
        System.out.println("Testing Completed : min");
    }

    @Test
    public void countSort() {
        // du path 1-2-5-6-9-10-13-14-17 for variable n,arr,exp
        int arr1[] = {};
        int exp1[] = {};
        assertEquals(null, Main.countSort(arr1, 0, 1));

        // du path 1-2-5-6-9-10-11-12-10-11-12-10-13-14-17 for variable i,count,output
        int arr2[] = { 11, 2, 5, 7, 3, 10, 27, 57 };
        int exp2[] = { 10, 11, 2, 3, 5, 7, 27, 57 };
        Main.countSort(arr2, 8, 1);
        assertArrayEquals(exp2, arr2);

        // du path 1-2-5-6-9-10-11-12-10-13-14-17 for variable count,output
        int arr3[] = { 5, 11, 2, 6, 22, 19 };
        int exp3[] = { 2, 22, 5, 6, 11, 19 };
        Main.countSort(arr3, 6, 2);
        assertArrayEquals(exp3, arr3);
        System.out.println("Testing Completed : countSort");
    }

    @Test
    public void getMedian() {
        // du path 1-2-3-4-5-7-9-10-4-11 for variable m,m1,m2,n,count
        int arr1[] = { 1, 4, 6 };
        int arr2[] = { 2, 3, 5, 8 };
        assertEquals(4, obj.getMedian(arr1, arr2, arr1.length, arr2.length));

        // du path 1-2-3-4-5-6-22-10-4-5-6-21-10-4-11 for variable i,j,ar1,ar2
        int arr3[] = { 8, 11, 12, 24 };
        int arr4[] = { 10, 13, 15 };
        assertEquals(12, obj.getMedian(arr3, arr4, arr3.length, arr4.length));

        // du path 1-2-12-13-15-16-24-20-13-15-16-24-20-13-14 for variable m1,count,m
        int arr5[] = { 2, 4, 7, 9, 15 };
        int arr6[] = { 3, 5, 6, 8, 10 };
        assertEquals(6, obj.getMedian(arr5, arr6, arr5.length, arr6.length));
        System.out.println("Testing Completed : getMedian");

    }
}
