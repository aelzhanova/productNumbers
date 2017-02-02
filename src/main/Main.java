package main;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static int N = 11;

    public static void main(String[] args) {
        ProductNumbers productNumbers = new ProductNumbers();
        int k = productNumbers.productOfNumbers(N);
        System.out.println(k);
    }
}
