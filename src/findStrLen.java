public class findStrLen {
    static int k;
    public static void main(String[] args) {
        String name = "Abcdefghijklmnopqrstuvwxyz";
        char[] ch = name.toCharArray();
        int i=0;
        for (char c:ch){
            i++;
        }
        System.out.println(i);
        int j=0;
        try {
            for (int k=0;;k++){
                j = k;
                name.charAt(k);
            }
        }
        catch (Exception e){
            System.out.println(j);
        }


        System.out.println(k);
    }
}
