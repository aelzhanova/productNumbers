package main;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ProductNumbers {

    public int productOfNumbers(int N)
    {
        String k = "";
        do {
            for (int i = 2; i <= N; i++) {
                if (N % i == 0) {
                    if (Integer.toString(i).length() > 1)
                        return -1;
                    else {
                        k = k + Integer.toString(i);
                        N = N / i;
                        break;
                    }
                }
            }
        }
        while (N!=1);
        return alghoritm(k);
    }

    private void writeToFile(String text, String outputFilePath)
    {
        try(FileWriter writer = new FileWriter(outputFilePath, false))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    private int alghoritm(String s)
    {
        Integer [] array = new Integer[s.length()];
        int l = 0;
        for (char c: s.toCharArray())
        {
            array[l] = Character.getNumericValue(c);
            l = l + 1;
        }
        Arrays.sort(array, Collections.reverseOrder());
        String k = "";
        for (int i=0; i<array.length; i++)
        {
            if (i+2< array.length) {
                if (array[i] * array[i + 1] * array[i + 2] < 10) {
                    k = k + Integer.toString(array[i] * array[i + 1] * array[i + 2]);
                    i = i + 2;
                }
                else if (array[i] * array[i + 1] < 10)
                {
                    k = k + Integer.toString(array[i] * array[i + 1]);
                    i = i + 1;
                } else
                {
                    k = k + Integer.toString(array[i]);
                }
            }
            else if (i+1< array.length)
            {
                if (array[i] * array[i + 1] < 10)
                {
                    k = k + Integer.toString(array[i] * array[i + 1]);
                    i = i + 1;
                } else
                {
                    k = k + Integer.toString(array[i]);
                }
            }
            else
            {
                k = k + Integer.toString(array[i]);
            }

        }
        k = sort(k);
        return Integer.parseInt(k);
    }

    private String sort(String s)
    {
        int [] array2 = new int[s.length()];
        int l = 0;
        for (char c: s.toCharArray())
        {
            array2[l] = Character.getNumericValue(c);
            l = l + 1;
        }
        Arrays.sort(array2);
        String k="";
        for (int i=0; i<array2.length; i++)
        {
            k = k + array2[i];
        }
        return k;
    }
}
