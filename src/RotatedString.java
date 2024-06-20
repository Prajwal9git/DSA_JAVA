public class RotatedString {
    public static void main(String[] args) {
        String s = "gcmbf";
        String goal = "fgcmb";
        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal) {
        int pivot = findPivot(s, goal);
        if(pivot == -1) return false;
        System.out.println("s.substring(0, pivot) : " + s.substring(0,pivot));
        System.out.println("goal.substring(pivot + 1, goal.length()) : " + goal.substring(pivot + 1, goal.length()));

        if(s.substring(0,pivot).equals(goal.substring(pivot + 1, goal.length()))){
            if(s.substring(pivot, s.length()).equals(goal.substring(0, pivot + 1)))
                return true;
        }
        return false;
    }

    public static int findPivot(String s, String goal){
        int start = 0;
        int end = s.length() - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(goal.charAt(mid) > goal.charAt(mid + 1)) return mid;
            if(goal.charAt(mid) < goal.charAt(mid - 1)) return mid - 1;

            if(goal.charAt(mid) < start) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
