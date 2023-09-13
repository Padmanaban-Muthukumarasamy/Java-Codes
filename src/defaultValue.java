import java.util.Arrays;
import java.util.List;

public class defaultValue {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3","4","5","6");

        list.stream().forEach(i->{
            if(Integer.parseInt(i)%2==0){
                System.out.println("Even Number"+i);
            }
            else {
                System.out.println("Odd Number"+i);
            }
        });

    }
}
