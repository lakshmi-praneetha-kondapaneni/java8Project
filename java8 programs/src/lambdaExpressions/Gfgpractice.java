package lambdaExpressions;

import java.util.Arrays;
import java.util.OptionalInt;

public class Gfgpractice {
    /* 1. Find Missing number given a array on n consecutive elenets where one numebr is missing*/
    public void missingNumber(int[] array, int n)
    {
        OptionalInt sum= Arrays.stream(array).reduce((a, b)->a+b);
        System.out.println(n*(n+1)/2-sum.getAsInt());
    }

}
