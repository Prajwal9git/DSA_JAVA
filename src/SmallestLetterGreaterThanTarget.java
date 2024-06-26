class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'c';
        char result = nextGreatestLetter(letters, target);
        System.out.println(result);
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length;
        int mid;
        while(start <= end){
            mid = start + (end - start)/2;
            if(target < letters[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return letters[start%letters.length];
    }
}
