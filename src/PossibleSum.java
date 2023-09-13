import java.util.*;
import java.util.stream.Collectors;

public class PossibleSum {
    public static int getPossible(int A[]){
        long sum=0;
        long[] a=Arrays.stream(A).asLongStream().toArray();
        List<Long> list= Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.sort(list);
         long b = list.get(list.size()-1);
         long frst = list.get(0);
        for(int i=0;i<list.size();i++){
            if(list.size()>2) {
                for (int j = i + 1; j < list.size(); j++) {
                    sum = list.get(i) - list.get(j);
                    sum = Math.abs(sum);
                    list.add(sum);
                    // Collections.sort(list);
                    if (b == list.get(j)) {
                        break;
                    }
                }
            }
            else{
                for (int j = i + 1; j < list.size(); j++) {
                    sum = list.get(i) - list.get(j);
                    sum = Math.abs(sum);
                    list.add(sum);
                    // Collections.sort(list);
                    if (sum == list.get(i)) {
                        break;
                    }
                }
            }
            break;
        }
        Collections.sort(list);
        if(list.get(0).equals(0)) {
            list = Collections.singletonList(list.remove(0));
        }
        Set<Long> set = new HashSet<>(list);
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
