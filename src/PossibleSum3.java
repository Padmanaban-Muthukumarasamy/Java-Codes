import java.util.*;
import java.util.stream.Collectors;

public class PossibleSum3 {
    public static int getPossible(int A[]) {
        long sum = 0;
        long[] a = Arrays.stream(A).asLongStream().toArray();
        List<Long> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        Set<List<Long>> set=new HashSet<>();
        long min = Long.MAX_VALUE;
        for (int i = 0;i< a.length-1;i++)
            min =Math.min(min, Math.abs(list.get(i)-list.get(i+1)));
        for (int i = 0;i< a.length-1;i++){
            List<Long> list1 = new ArrayList<>();
            if(Math.abs(list.get(i)-list.get(i+1)) == min){
                list1.add(Math.min(list.get(i), list.get(i+1)));
                list1.add(Math.max(list.get(i),list.get(i+1)));
                set.add(list1);

            }
        }

        return set.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N= sc.nextInt();
        int A[]=new int[N];
        for(int j=0;j<N;j++){
            A[j]=sc.nextInt();
        }
        int result;
        result= getPossible(A);
        System.out.print(result);
    }
}
