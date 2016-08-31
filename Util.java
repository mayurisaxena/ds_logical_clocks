import java.util.*;
public class Util {
    public static int max(int a, int b) {
        if (a > b) return a;
        return b;
    }
   
       public static int maxArray(int A[]) {
        int v = A[0];
        for (int i=0; i<A.length; i++)
            if (A[i] > v) v = A[i];
        return v;
    }
    public static String writeArray(int A[]){
        StringBuffer s = new StringBuffer();
        for (int j = 0; j < A.length; j++)
            s.append(String.valueOf(A[j]) + " ");
        return new String(s.toString());
    }
  
   
    }
