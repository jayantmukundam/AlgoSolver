import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int nextPowerOf2(int n) {
        int count = 0;

        // First n in the below
        // condition is for the
        // case where n is 0
        if (n > 0 && (n & (n - 1)) == 0)
            return n;

        while (n != 0) {
            n >>= 1;
            count += 1;
        }

        return 1 << count;
    }

    static int leftRotate(int n, int d) {

        /*
         * In n<<d, last d bits are 0.
         * To put first 3 bits of n at
         * last, do bitwise or of n<<d with
         * n >>(INT_BITS - d)
         */
        return (n << d) | (n >> (32 - d));
    }

    /* Function to right rotate n by d bits */
    static int rightRotate(int n, int d) {

        /*
         * In n>>d, first d bits are 0.
         * To put last 3 bits of at
         * first, do bitwise or of n>>d
         * with n <<(INT_BITS - d)
         */
        return (n >> d) | (n << (32 - d));
    }

    // Count total set bits in all numbers from 1 to n

    static int countSetBits(int n) {

        // write test case for this
        int i = 0;
        // ans store sum of set bits from 0 to n
        int ans = 0;
        // while n greater than equal to 2^i
        while ((1 << i) <= n) {

            // This k will get flipped after
            // 2^i iterations
            boolean k = false;

            // change is iterator from 2^i to 1
            int change = 1 << i;

            // This will loop from 0 to n for
            // every bit position
            for (int j = 0; j <= n; j++) {

                if (k == true)
                    ans += 1;
                else
                    ans += 0;

                if (change == 1) {

                    // When change = 1 flip the bit
                    k = !k;

                    // again set change to 2^i
                    change = 1 << i;
                } else {
                    change--;
                }
            }
            // increment the position
            i++;
        }
        return ans;
    }

    static int isPowerOfFour(int n) {
        int count = 0;

        /*
         * Check if there is
         * only one bit set in n
         */
        int x = n & (n - 1);

        if (n > 0 && x == 0) {
            /*
             * count 0 bits
             * before set bit
             */
            while (n > 1) {
                n >>= 1;
                count += 1;
            }

            /*
             * If count is even
             * then return true
             * else false
             */
            return (count % 2 == 0) ? 1 : 0;
        }

        /*
         * If there are more than
         * 1 bit set then n is not a
         * power of 4
         */
        return 0;
    }

    public void printCharWithFreq(String str) {
        // size of the string 'str'
        int n = str.length();

        // 'freq[]' implemented as hash table
        int[] freq = new int[26];

        // accumulate frequency of each character
        // in 'str'
        for (int i = 0; i < n; i++)
            freq[str.charAt(i) - 'a']++;

        // traverse 'str' from left to right
        for (int i = 0; i < n; i++) {

            // if frequency of character str.charAt(i)
            // is not equal to 0
            if (freq[str.charAt(i) - 'a'] != 0) {

                // print the character along with its
                // frequency
                System.out.print(str.charAt(i));
                System.out.print(freq[str.charAt(i) - 'a'] + " ");

                // update frequency of str.charAt(i) to
                // 0 so that the same character is not
                // printed again
                freq[str.charAt(i) - 'a'] = 0;
            }
        }
    }

    public void printOdd(ArrayList<Integer> a) {
        System.out.println("Odd Numbers:");
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) % 2 != 0) {
                System.out.println(a.get(i));
            }
        }
    }

    public void printEven(ArrayList<Integer> a) {
        System.out.println("Even Numbers:");
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) % 2 == 0) {
                System.out.println(a.get(i));
            }
        }
    }

    public int sumArray(ArrayList<Integer> arr) {
        int sum = 0; // initialize sum
        int i;

        // Iterate through all elements and add them to sum
        for (i = 0; i < arr.size(); i++)
            sum += arr.get(i);

        return sum;
    }

    public boolean isPrime(int n) {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    public double findMean(ArrayList<Integer> a) {
        int n = a.size();
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += a.get(i);

        return (double) sum / (double) n;
    }

    public double findMedian(ArrayList<Integer> a) {
        int n = a.size();
        // First we sort the array
        Collections.sort(a);

        // check for even case
        if (n % 2 != 0)
            return (double) a.get(n / 2);

        return (double) (a.get(((n - 1) / 2) + a.get(n / 2))) / 2.0;
    }

    public void countVowelsConsonants(String str) {
        int vow = 0, con = 0;
        String ref = "aeiouAEIOU";

        for (int i = 0; i < str.length(); i++) {

            if ((str.charAt(i) >= 'A'
                    && str.charAt(i) <= 'Z')
                    || (str.charAt(i) >= 'a'
                            && str.charAt(i) <= 'z')) {
                if (ref.indexOf(str.charAt(i)) != -1)
                    vow++;
                else
                    con++;
            }
        }

        System.out.println("Number of Vowels = " + vow
                + "\nNumber of Consonants = "
                + con);
    }

    public boolean Anagram(String s1, String s2) {
        char str1[] = s1.toCharArray();
        char str2[] = s2.toCharArray();
        int n1 = str1.length;
        int n2 = str2.length;
        if (n1 != n2)
            return false;

        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }

    public void countPunctuation(String str) {
        int countPuncMarks = 0;
        for (int i = 0; i < str.length(); i++) {
            // Checks whether given character is punctuation mark
            if (str.charAt(i) == '!' || str.charAt(i) == ',' || str.charAt(i) == ';' || str.charAt(i) == '.'
                    || str.charAt(i) == '?' || str.charAt(i) == '-' ||
                    str.charAt(i) == '\'' || str.charAt(i) == '\"' || str.charAt(i) == ':') {
                countPuncMarks++;
            }
        }
        System.out.println("Total number of punctuation characters exists in string: " + countPuncMarks);
    }

    public char getMaxOccuringChar(String str) {
        int count[] = new int[256];

        int len = str.length();
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;

        int max = -1; // Initialize max count
        char result = ' '; // Initialize result

        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        return result;
    }

    ArrayList<Integer> SelectionSort(ArrayList<Integer> arr) {
        int n = arr.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr.get(min_idx);
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
        }

        for (int i = 0; i < n; ++i)
            System.out.print(arr.get(i) + " ");
        System.out.println();
        return arr;
    }

    ArrayList<Integer> BubbleSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr.get(j) > arr.get(j + 1)) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
        for (int i = 0; i < n; ++i)
            System.out.print(arr.get(i) + " ");
        System.out.println();
        return arr;
    }

    ArrayList<Integer> Insertionsort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            int key = arr.get(i);
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
        for (int i = 0; i < n; ++i)
            System.out.print(arr.get(i) + " ");
        System.out.println();
        return arr;
    }

    public int linearSearch(ArrayList<Integer> arr, int key) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == key) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(ArrayList<Integer> arr, int x) {
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr.get(m) == x)
                return m;

            // If x greater, ignore left half
            if (arr.get(m) < x)
                l = m + 1;

            // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was not present
        return -1;
    }

    public boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }

    public int max(ArrayList<Integer> array) {
        int max = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        return max;
    }

    public int min(ArrayList<Integer> array) {
        int min = Integer.MAX_VALUE;
        if (array.size() == 0)
            return Integer.MAX_VALUE;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        return min;
    }

    public int lower_bound(ArrayList<Integer> array, int key) {
        int low = 0, high = array.size();
        int mid;

        while (low < high) {
            mid = low + (high - low) / 2;
            if (key <= array.get(mid)) {
                high = mid;
            }

            else {

                low = mid + 1;
            }
        }
        if (low < array.size() && array.get(low) < key) {
            low++;
        }

        // Returning the lower_bound index
        return low;
    }

    public int upper_bound(ArrayList<Integer> arr, int key) {
        int mid, N = arr.size();
        int low = 0;
        int high = N;
        while (low < high && low != N) {
            mid = low + (high - low) / 2;

            if (key >= arr.get(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (low == N) {
            return -1;
        }

        return low;
    }

    public void findCommon(int ar1[], int ar2[], int ar3[]) {
        // Initialize starting indexes for ar1[], ar2[] and ar3[]
        int i = 0, j = 0, k = 0;
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        Arrays.sort(ar3);
        int f = 0;
        // Iterate through three arrays while all arrays have elements
        while (i < ar1.length && j < ar2.length && k < ar3.length) {
            // If x = y and y = z, print any of them and move ahead
            // in all arrays
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                f = 1;
                System.out.print("Common elements are" + ar1[i] + " ");
                i++;
                j++;
                k++;
            }

            // x < y
            else if (ar1[i] < ar2[j])
                i++;

            // y < z
            else if (ar2[j] < ar3[k])
                j++;

            // We reach here when x > y and z < y, i.e., z is smallest
            else
                k++;
        }
        if (f == 0) {
            System.out.println("No common elements found\n");
        }
    }

    public void search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int i = 0;

        while (i <= N - M) {
            int j;

            /* For current index i, check for pattern match */
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            {
                System.out.println("Pattern found at index " + i);
                i = i + M;
            } else if (j == 0)
                i = i + 1;
            else
                i = i + j; // slide the pattern by j
        }
    }

    public int power(int x, int y) {
        int result = 1;

        while (y > 0) {

            // y is even
            if (y % 2 == 0) {
                x = x * x;
                y = y / 2;
            }

            // y isn't even
            else {
                result = result * x;
                y = y - 1;
            }
        }
        return result;
    }

    public int getMedian(int ar1[], int ar2[],
            int n, int m) {

        // Current index of input array ar1[]
        int i = 0;

        // Current index of input array ar2[]
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;

        // Since there are (n+m) elements,
        // There are following two cases
        // if n+m is odd then the middle
        // index is median i.e. (m+n)/2
        if ((m + n) % 2 == 1) {
            for (count = 0; count <= (n + m) / 2; count++) {
                if (i != n && j != m) {
                    m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++];
                } else if (i < n) {
                    m1 = ar1[i++];
                }

                // for case when j<m,
                else {
                    m1 = ar2[j++];
                }
            }
            return m1;
        }

        // median will be average of elements
        // at index ((m+n)/2 - 1) and (m+n)/2
        // in the array obtained after merging
        // ar1 and ar2
        else {
            for (count = 0; count <= (n + m) / 2; count++) {
                m2 = m1;
                if (i != n && j != m) {
                    m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++];
                } else if (i < n) {
                    m1 = ar1[i++];
                }

                // for case when j<m,
                else {
                    m1 = ar2[j++];
                }
            }
            return (m1 + m2) / 2;
        }
    }

    public int getInvCount(ArrayList<Integer> arr, int n) {
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (arr.get(i) > arr.get(j))
                    inv_count++;

        return inv_count;
    }

    static int fib(int n) {
        int F[][] = new int[][] { { 1, 1 }, { 1, 0 } };
        if (n == 0)
            return 0;
        power(F, n - 1);

        return F[0][0];
    }

    static void multiply(int F[][], int M[][]) {
        int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    /* Optimized version of power() in method 4 */
    static void power(int F[][], int n) {
        if (n == 0 || n == 1)
            return;
        int M[][] = new int[][] { { 1, 1 }, { 1, 0 } };

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0)
            multiply(F, M);
    }

    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static Object countSort(int arr[], int n, int exp) {

        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        return null;
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(ArrayList<Integer> al, int n) {
        int[] arr = al.stream().mapToInt(Integer::intValue).toArray();
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
        print(arr, n);
    }

    // A utility function to print an array
    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to DSA Util CLI");
        while (true) {
            System.out.println("Enter the choice");
            System.out.println("1 Sorting \n" +
                    "2 Searching\n" +
                    "3 String operations\n" +
                    "4 Array operations\n" +
                    "5 Bit operations\n" +
                    "6 Other operations\n" +
                    "7 Exit\n");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            Main mn = new Main();
            if (ch == 1) {
                System.out.println("This is sorting utility");
                System.out.println("Enter the Size of the array");
                int n = sc.nextInt();
                ArrayList<Integer> array = new ArrayList<Integer>(n);
                System.out.println("Enter the array for sorting");
                for (int i = 0; i < n; i++) {
                    int ele = sc.nextInt();
                    array.add(ele);
                }
                System.out.println("1 Selection sort\n" +
                        "2 Bubble Sort\n" +
                        "3 Insertion sort\n" +
                        "4 Radix sort\n" +
                        "5 count sort\n");
                int chs = sc.nextInt();
                if (chs == 1) {
                    mn.SelectionSort(array);
                } else if (chs == 2) {
                    mn.BubbleSort(array);
                } else if (chs == 3) {
                    mn.Insertionsort(array);
                } else if (chs == 4) {
                    radixsort(array, n);
                } else if (chs == 5) {
                    System.out.println("Enter the exp\n");
                    int exp = sc.nextInt();
                    int arr2[] = array.stream().mapToInt(Integer::intValue).toArray();
                    countSort(arr2, n, exp);
                }
            } else if (ch == 2) {
                System.out.println("This is search utility");
                System.out.println("1 Linear Search\n" +
                        "2 Binary Search \n" +
                        "3 Find min element\n" +
                        "4 Find max element\n" +
                        "5 Lower bound\n" +
                        "6 Upper bound\n");
                int ch2 = sc.nextInt();
                System.out.println("Enter the Size of the array");
                int n = sc.nextInt();
                ArrayList<Integer> array = new ArrayList<Integer>(n);
                System.out.println("Enter the array for searching");
                for (int i = 0; i < n; i++) {
                    int ele = sc.nextInt();
                    array.add(ele);
                }
                if (ch2 == 1) {
                    System.out.println("Enter the element you want to find");
                    int x = sc.nextInt();
                    int pos = mn.linearSearch(array, x);
                    if (pos != -1) {
                        System.out.println("Element found at  " + pos);
                    } else {
                        System.out.println("Element not found");
                    }
                }
                if (ch2 == 2) {
                    System.out.println("Enter the element you want to find");
                    int x = sc.nextInt();
                    int pos = mn.binarySearch(array, x);
                    if (pos != -1) {
                        System.out.println("Element found at " + pos);
                    } else {
                        System.out.println("Element not found");
                    }
                }
                if (ch2 == 3) {
                    int min = mn.min(array);
                    System.out.println("MIN element in array is " + min);
                }
                if (ch2 == 4) {
                    int max = mn.max(array);

                    System.out.println("MAX element in array is " + max);
                }
                if (ch2 == 5) {
                    System.out.println("Enter the element you want to find Lower bound of");
                    int x = sc.nextInt();
                    System.out.println("Lower bound of" + x + "is=" + mn.lower_bound(array, x));
                }
                if (ch2 == 6) {
                    System.out.println("Enter the element you want to find upper bound of");
                    int x = sc.nextInt();
                    System.out.println("Upper bound of" + x + "is=" + mn.upper_bound(array, x));
                }

            } else if (ch == 3) {
                System.out.println("This is string utility");
                // Sysx`tem.out.println("Enter the string you want to perform operations on");
                // String s=sc.nextLine();
                System.out.println("1 Count Vowels and consonants\n" +
                        "2 Check anagram\n" +
                        "3 Count punctuations\n" +
                        "4 Get max occuring Character\n" +
                        "5 Get frequency of all characters\n" +
                        "6 check a string is palindrome or not\n" +
                        "7 Pattern search");
                int ch3 = sc.nextInt();
                if (ch3 == 1) {
                    System.out.println("Enter the string you want to perform operations on");
                    String s = sc.nextLine();

                    mn.countVowelsConsonants(s);
                } else if (ch3 == 2) {
                    System.out.println("Enter the strings");
                    String s1 = sc.nextLine();
                    String s2 = sc.nextLine();

                    if (mn.Anagram(s1, s2)) {
                        System.out.println("Given strings are anagram\n");
                    } else {
                        System.out.println("Given strings are not anagram\n");
                    }
                } else if (ch3 == 3) {
                    System.out.println("Enter the string");
                    String s = sc.nextLine();

                    mn.countPunctuation(s);
                } else if (ch3 == 4) {

                    System.out.println("Enter the string you want to perform operations on");
                    String s = sc.nextLine();

                    System.out.println("Max occuring character is = " + mn.getMaxOccuringChar(s));

                } else if (ch3 == 5) {
                    System.out.println("Enter the string you want to perform operations on");
                    String s = sc.nextLine();
                    mn.printCharWithFreq(s);
                } else if (ch3 == 6) {
                    System.out.println("Enter the string you want to perform operations on");
                    String s = sc.nextLine();
                    boolean isit = mn.isPalindrome(s);

                    if (isit) {
                        System.out.println("string " + s + " " + "is a palindrome");
                    } else {
                        System.out.println("string " + s + " " + "is not a palindrome");
                    }
                } else if (ch3 == 7) {
                    System.out.println("Enter the strings");
                    System.out.println("pattern =");
                    String s1 = sc.nextLine();
                    System.out.println("Text= ");
                    String s2 = sc.nextLine();
                    mn.search(s1, s2);
                }

            } else if (ch == 4) {
                System.out.println("This is array operations utility");
                System.out.println("1 print all odd numbers in array\n" +
                        "2 Print all even numbers \n" +
                        "3 sum of array \n" +
                        "4 Find mean \n" +
                        "5 Find median\n" +
                        "6 Find median of two sorted arrays\n" +
                        "7 Find inversion count\n" +
                        "8 Find common in three arrays\n");
                int ch4 = sc.nextInt();
                System.out.println("Enter the Size of the array");
                int n = sc.nextInt();
                ArrayList<Integer> array = new ArrayList<Integer>(n);
                System.out.println("Enter the array \n");
                for (int i = 0; i < n; i++) {
                    int ele = sc.nextInt();
                    array.add(ele);
                }
                if (ch4 == 1) {
                    mn.printOdd(array);
                } else if (ch4 == 2) {
                    mn.printEven(array);
                } else if (ch4 == 3) {
                    System.out.println("Sum of given array =" + mn.sumArray(array));
                } else if (ch4 == 4) {
                    System.out.println("Mean of given array =" + mn.findMean(array));
                } else if (ch4 == 5) {
                    System.out.println("Median of given array =" + mn.findMedian(array));
                } else if (ch4 == 6) {
                    System.out.println("Enter the Size of second array\n");
                    int m = sc.nextInt();
                    ArrayList<Integer> array2 = new ArrayList<Integer>(m);
                    System.out.println("Enter the array \n");
                    for (int i = 0; i < m; i++) {
                        int ele = sc.nextInt();
                        array2.add(ele);
                    }
                    int[] arr1 = array.stream().mapToInt(Integer::intValue).toArray();
                    int[] arr2 = array2.stream().mapToInt(Integer::intValue).toArray();
                    System.out.println("Median of the given arrays= " + mn.getMedian(arr1, arr2, n, m));

                } else if (ch4 == 7) {
                    System.out.println("Inversion count of given array is= " + mn.getInvCount(array, n));
                } else if (ch4 == 8) {
                    System.out.println("Enter the Size of second array");
                    int n2 = sc.nextInt();
                    ArrayList<Integer> array2 = new ArrayList<Integer>(n2);
                    System.out.println("Enter the array \n");
                    for (int i = 0; i < n2; i++) {
                        int ele = sc.nextInt();
                        array2.add(ele);
                    }
                    System.out.println("Enter the Size of third array");
                    int n3 = sc.nextInt();
                    ArrayList<Integer> array3 = new ArrayList<Integer>(n3);
                    System.out.println("Enter the array \n");
                    for (int i = 0; i < n3; i++) {
                        int ele = sc.nextInt();
                        array3.add(ele);
                    }
                    int[] arr1 = array.stream().mapToInt(Integer::intValue).toArray();
                    int[] arr2 = array2.stream().mapToInt(Integer::intValue).toArray();
                    int[] arr3 = array3.stream().mapToInt(Integer::intValue).toArray();
                    mn.findCommon(arr1, arr2, arr3);
                }
            } else if (ch == 5) {
                System.out.println("This bit manipulation menu");
                System.out.println("1 Next power of 2\n" +
                        "2 Left rotate\n" +
                        "3 Right rotate\n" +
                        "4 Count set bits\n" +
                        "5 Check if it is power of 4\n");
                int ch5 = sc.nextInt();
                System.out.println("Enter the number");
                int n = sc.nextInt();

                if (ch5 == 1) {
                    System.out.println("Next power of n is" + nextPowerOf2(n));
                } else if (ch5 == 2) {
                    System.out.println("by how much bits you want to rotate n");
                    int x = sc.nextInt();
                    System.out.println("Left rotate n by x" + leftRotate(n, x));
                } else if (ch5 == 3) {
                    System.out.println("by how much bits you want to rotate n");
                    int x = sc.nextInt();
                    System.out.println("Right rotate n by x" + rightRotate(n, x));
                } else if (ch5 == 4) {
                    System.out.println("Set bits in n " + countSetBits(n));
                } else if (ch5 == 5) {
                    int ret = isPowerOfFour(n);
                    if (ret == 1) {
                        System.out.println("N is power of four");
                    } else {
                        System.out.println("N is not a power of four");
                    }
                }
            } else if (ch == 6) {
                System.out.println("Other operations Menu\n");
                System.out.println("1: Fibonacci of number\n" +
                        "2: Power function(x raised to the power y)");
                int ch6 = sc.nextInt();
                if (ch6 == 1) {
                    System.out.println("Enter the number\n");
                    int n = sc.nextInt();
                    System.out.println("Fibonacci of number " + n + "is= " + fib(n));
                }
                if (ch6 == 2) {
                    System.out.println("Enter the number x\n");
                    int x = sc.nextInt();
                    System.out.println("raised to the power y\n");
                    int y = sc.nextInt();
                    System.out.println("Power(" + x + "," + y + ")" + "= " + mn.power(x, y));
                }
            } else if (ch == 7) {
                System.out.println("Thank you\n Bye! Have a Good day!\n");
                break;
            }
        }
    }
}