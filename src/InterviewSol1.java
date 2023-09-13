import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewSol1 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(9,2,3,1,11,8,10);
        int n = 3;
        integers.set(0,integers.get(0)-1);
        integers = integers.stream().sorted().collect(Collectors.toList());
        //long min = 0;
        List<Integer> finalIntegers = integers;
        if (finalIntegers.size()<n){
            System.out.println(n);
        }
        else {
            try {
                IntStream.range(1, finalIntegers.size()).forEach(i -> {
                    if (i == n) {
                        System.out.println(finalIntegers.get(i));
                        throw new RuntimeException();
                    }
                });
            }
            catch (Exception e){

            }
        }

    }
}
