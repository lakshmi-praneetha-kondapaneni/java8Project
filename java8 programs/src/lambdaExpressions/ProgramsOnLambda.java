package lambdaExpressions;

import java.util.function.BiFunction;
@FunctionalInterface
interface Arithmetic
{
    int operation(int n1,int n2);
}
public class ProgramsOnLambda {
    public static void main(String[] args) {
        Integer num1=10,num2=20;
        /* Arithmetic operations using In-built Functional Interface */
        BiFunction<Integer,Integer,Integer> add=(n1,n2)->n1+n2;
        BiFunction<Integer,Integer,Integer> subtract=(n1,n2)->n1-n2;
        BiFunction<Integer,Integer,Integer> multiply=(n1,n2)->n1*n2;
        BiFunction<Integer,Integer,Double> divide=(n1,n2)-> (double) (n1/n2);
        System.out.println(add.apply(num1,num2));
        System.out.println(subtract.apply(num1,num2));
        System.out.println(multiply.apply(num1,num2));
        System.out.println(divide.apply(num1,num2));

        /* Arithmetic operations using custom Functional Interface */
        Arithmetic addition=(n1,n2)->n1+n2;
        Arithmetic subtraction=(n1,n2)->n1-n2;
        Arithmetic multiplication=(n1,n2)->n1*n2;
        Arithmetic division=(n1,n2)->n1/n2;
        Arithmetic moduloDivision=(n1,n2)->n1%n2;
        System.out.println(addition.operation(num1,num2));
        System.out.println(subtraction.operation(num1,num2));
        System.out.println(multiplication.operation(num1,num2));
        System.out.println((double) division.operation(num1,num2));
        System.out.println(moduloDivision.operation(num1,num2));

    }
}
