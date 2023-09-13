import java.util.*;
import java.util.stream.Collectors;

public class possiblesum6 {
    public static int getPossible(int A[]) {
        int sum = 0;
        long[] a = Arrays.stream(A).asLongStream().toArray();
        List<Long> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.sort(list);
        List<Long> arr = getValue(list);

        for(long b:arr){
            if(b>=10 && b<=99)
                sum = Math.toIntExact(sum + b);
        }
        return sum;
    }
    private static List<Long> getValue(List<Long> list){
        long sml = list.get(0);
        long rpl=0;
        if(sml>=10&&sml<=89){
            String al = String.valueOf(sml);
            String l = al.substring(0,1);
            al = al.replace(l,"9");
            rpl = Long.valueOf(al);
            list.set(0,rpl);
        }
        return list;
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
