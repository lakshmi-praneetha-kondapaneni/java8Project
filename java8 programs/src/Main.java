import lambdaExpressions.Gfgpractice;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
       Java8Programs java8Programs=new Java8Programs();
       String s="ilovejava8";
       java8Programs.countOccurrence(s);
       java8Programs.findDuplicates(s);
       java8Programs.findUniqueElements(s);
       java8Programs.firstNonRepeatElement(s);
       int nums[]={5,9,11,2,8,21,1};
       java8Programs.secondHighestNumber(nums);
       String[] strArray={"java","java8","springboot","microservices","aws","kubernetes","sql","mongodb"};
       java8Programs.largestStringInArray(strArray);
       java8Programs.numbersStartWith1(nums);
       System.out.println(java8Programs.isPalindrome("madam"));
       System.out.println(java8Programs.isPalindrome("paaps"));
       java8Programs.factorial(5);
       System.out.println(java8Programs.isPrime(5));
       System.out.println(java8Programs.isPrime(122));
       System.out.println(java8Programs.isPrime(1350));
       java8Programs.primesUpToN(100);
       java8Programs.largestNumInArray(nums);
       java8Programs.stringArrayToUpper(strArray);
       java8Programs.sortArray(strArray);
       int[] array={1,2,4,5};
       Gfgpractice gfgpractice=new Gfgpractice();
       gfgpractice.missingNumber(array,5);

    }
}