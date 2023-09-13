import java.util.*;
import java.util.stream.Collectors;

public class possiblesum4 {
        public static int getPossible(int A[]) {
            long sum = 0;
            long[] a = Arrays.stream(A).asLongStream().toArray();
            List<Long> list = Arrays.stream(a).boxed().collect(Collectors.toList());
            Set<Long> set=null;
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                for (int j = i + 1; j < list.size() && list.get(j) > list.get(i); j++) {
                    sum = Math.abs(list.get(i) - list.get(j));
                    list.add(sum);
                    set = new TreeSet<>(list);
                    /*if( set.stream().findFirst().get() == list.get(j)){
                        break;
                    }*/
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
