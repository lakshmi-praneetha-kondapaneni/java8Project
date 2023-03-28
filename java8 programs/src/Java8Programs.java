import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.*;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;

public class Java8Programs {
    /* 1) java Program to count the occurence of each character in a string */
    void countOccurrence(String s)
    {
        Map<String,Long>map= stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);
    }
    /* 2) java program to find all duplicate elements from a given string */
    void findDuplicates(String s)
    {

        List list= stream(s.split("")).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().filter(x->x.getValue()>1)
                .map(x->x.getKey())
                .toList();
        System.out.println(list);
    }
    /* 3) java program to find all unique elements from a given string */
    void findUniqueElements(String s)
    {

        List list= stream(s.split("")).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().filter(x->x.getValue()==1)
                .map(x->x.getKey())
                .toList();
        System.out.println(list);
    }
    /* 4) java program to find first non-repeat element from a given string */
    void firstNonRepeatElement(String s)
    {
        String ans= stream(s.split("")).
                collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream().filter(x->x.getValue()==1)
                .map(x->x.getKey()).findFirst().orElse(null);
        System.out.println(ans);
    }
    /* 5) java program to find second highest number from given array */
    void  secondHighestNumber(int[] nums)
    {
        Integer secondHighestElement=Arrays.stream(nums).boxed()
                        .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElse(null);
        System.out.println(secondHighestElement);
    }
    /* 6) java program to find largest string from given array */
    void largestStringInArray(String[] stringArray)
    {
        String longestString=Arrays.stream(stringArray)
                .reduce((str1,str2)->str1.length()>str2.length()?str1:str2)
                .orElse(null);
        System.out.println(longestString);
    }
    /* 7) java program to find all elements from array which start with 1 */
    void numbersStartWith1(int[] nums)
    {
        List<String> stringList=Arrays.stream(nums).boxed().
        map(s -> s + "").
                filter(s->s.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(stringList);
    }
    /* 8) Check if string is palindrome */
    boolean isPalindrome(String s)
    {
        int n=s.length();
        return IntStream.range(0, n/ 2)
                .noneMatch(index -> s.charAt(index) != s.charAt(n-index-1));

    }
    /* 9) To find factorial of n */
    void factorial(int n)
    {
       int fact= IntStream.rangeClosed(1,n).boxed().reduce((a,b)->a*b).get();
       System.out.println(fact);
    }
    /*10) To check if a number is prime */
    boolean isPrime(int n)
    {

        if(n<=1) return false;
        return IntStream.rangeClosed(2,n/2).boxed().noneMatch(i->n%i==0);
    }
    /* 11) primes up to n*/
    void primesUpToN(int n)
    {
        List<Integer> primesList=IntStream.rangeClosed(2,n).boxed()
                .filter(i->isPrime(i)).collect(Collectors.toList());
        System.out.println(primesList);
    }
   /* 12) Largest number in an array */
    void largestNumInArray(int[] nums)
    {
        Integer largestNum=Arrays.stream(nums).boxed().reduce((a,b)->a>b?a:b).get();
        System.out.println(largestNum);
    }
    /* 13) Convert each string of array to uppercase */
     void stringArrayToUpper(String [] arr)
     {
        List<String> upperCaseArray=Arrays.stream(arr).map(x->x.toUpperCase()).collect(Collectors.toList());
       System.out.println(upperCaseArray);
     }
     /* 14) sort string array in ascending order and descending order */
    void sortArray(String[] arr)
    {
        Arrays.stream(arr).sorted().forEach(x->System.out.println(x));
        Arrays.stream(arr).sorted(Comparator.reverseOrder()).forEach(System.out::println);

    }
    int majority(int[] nums)
    {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(hm.containsKey(nums[i]))
                hm.put(nums[i],hm.get(nums[i])+1);
            else
                hm.put(nums[i],1);
        }

        return hm.entrySet().stream().filter(a->a.getValue()>n/2).findAny().map(k->k.getKey()).get();
        //System.out.println();
    }
}
