import java.util.*;
import java.util.stream.Collectors;

public class print100 {
    static int i=0;
    public static void main(String[] args) {
        String a = "A bird A fly bird big";
        String[] b = a.toLowerCase().split(" ");
        LinkedHashMap<String, Long> stringLongMap = new LinkedHashMap<>();
        for(String c:b){
            long count=0;
            if (stringLongMap.containsKey(c)){
                Long d = stringLongMap.get(c);
                d = d+1;
                stringLongMap.replace(c,d);
            }
            else {
                count++;
                stringLongMap.put(c, count);
            }
        }

        List<String> strings = stringLongMap.entrySet().stream().filter(i->i.getValue()<2).map(Map.Entry::getKey).collect(Collectors.toList());
        String finalElement = strings.get(strings.size()-1);
        strings.forEach(i->{
            System.out.print(i.equals(finalElement)?i:i+" ");
        });
        System.out.println();
       /* if (i<=100){
            System.out.printf("%d"+"%n",i++);
            main(null);
        }*/
    }
}
