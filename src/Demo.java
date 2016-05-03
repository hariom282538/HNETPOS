import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.*;
import java.util.Scanner;
import java.util.regex.*;

public class Demo {
    
    static int[] manipulateArray(int[] inputArray) {
        int swap;
        int n=inputArray.length;
for (int i = 0; i < ( n - 1 ); i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (inputArray[j] > inputArray[j+1]) /* For descending order use < */
        {
          swap       = inputArray[j];
          inputArray[j]   = inputArray[j+1];
          inputArray[j+1] = swap;
        }
      }
    }
   return inputArray;
   
    }
public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;
        
        int _inputArray_size = Integer.parseInt(in.nextLine());
        int[] _inputArray = new int[_inputArray_size];
        int _inputArray_item;
        for(int _inputArray_i = 0; _inputArray_i < _inputArray_size; _inputArray_i++) {
            _inputArray_item = Integer.parseInt(in.nextLine());
            _inputArray[_inputArray_i] = _inputArray_item;
        }
        
        res = manipulateArray(_inputArray);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        
        bw.close();
    }
}