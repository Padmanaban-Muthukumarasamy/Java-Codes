import java.util.*;
import java.util.stream.Collectors;

public class PossibleSum2 {
    public static int getPossible(int A[]) {
        long sum = 0;
        long[] a = Arrays.stream(A).asLongStream().toArray();
        List<Long> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        Set<Long> set=null;
       /* long b = list.get(list.size()-1);
        long frst = list.get(0);*/
        for(int i=0;i<list.size();i++){
            for (int j = i + 1; j < list.size(); j++) {
                sum = Math.abs(list.get(i) - list.get(j));
                list.add(sum);
                set = new TreeSet<>(list);
                if(list.get(i)<2 && sum == set.stream().findFirst().get()){
                    break;
                }
                else if(list.get(j) == set.stream().reduce((one, two)->two).get()){
                    break;
                }
            }
            break;
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
