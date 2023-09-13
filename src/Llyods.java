import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Llyods {

        public static void main(String[] argv) {
            String[][] events = {
                    {"CONNECT","Alice","Bob"},
                    {"DISCONNECT","Bob","Alice"},
                    {"CONNECT","Alice","Charlie"},
                    {"CONNECT","Dennis","Bob"},
                    {"CONNECT","Pam","Dennis"},
                    {"DISCONNECT","Pam","Dennis"},
                    {"CONNECT","Pam","Dennis"},
                    {"CONNECT","Edward","Bob"},
                    {"CONNECT","Dennis","Charlie"},
                    {"CONNECT","Alice","Nicole"},
                    {"CONNECT","Pam","Edward"},
                    {"DISCONNECT","Dennis","Charlie"},
                    {"CONNECT","Dennis","Edward"},
                    {"CONNECT","Charlie","Bob"}
            };
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            List<List<String>> sList = Arrays.stream(events).map(Arrays::asList).collect(Collectors.toList());

            List<String> connectedList = new ArrayList<>();
            List<String> disconnectedList = new ArrayList<>();
            for(List<String> a : sList) {
                if(a.get(0).equalsIgnoreCase("connect")){
                    connectedList.add(a.get(1));
                    connectedList.add(a.get(2));
                }
                else {
                    disconnectedList.add(a.get(1));
                    disconnectedList.add(a.get(2));
                }

            }
            Map<String, Long> disconnectMap  = disconnectedList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            Map<String, Long> connectMap = connectedList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            disconnectMap.forEach((key, value) -> {
                if (connectMap.containsKey(key)) {
                    connectMap.put(key, connectMap.get(key) - disconnectMap.get(key));
                }
            });
            List<List<String>> lists = new ArrayList<>();
            List<String> list1= new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            connectMap.forEach((key, value) -> {
                if (value < n) {
                    list1.add(key);
                } else {
                    list2.add(key);
                }
            });
            lists.add(list1);
            lists.add(list2);
            System.out.println(lists);
        }
}
