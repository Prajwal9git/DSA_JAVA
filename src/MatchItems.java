import java.util.*;
class MatchItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<String>> items = new ArrayList<>();
        System.out.println("Enter elements: ");
        for(int i = 0; i<3; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(sc.next());
            }
            items.add(row);
        }
        countMatches(items,"color","silver");
    }
    public static void countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        switch(ruleKey){
            case "type":
                for(List<String> row: items)
                        if(row.get(0) == ruleValue)
                            System.out.println(1);
                        else System.out.println(0);
                break;

            case "color":
                for(List<String> row: items)
                        if(row.get(1) == ruleValue)
                            System.out.println(1);
                        else System.out.println(0);
                break;

            case "name":
                for(List<String> row: items)
                        if(row.get(2) == ruleValue)
                            System.out.println(1);
                        else System.out.println(0);
                break;

            default: System.out.println(0);
                break;
        }
    }
}
