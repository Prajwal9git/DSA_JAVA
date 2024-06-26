class InvertImage{
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println("Array");
        int[][] new_arr = new int[arr.length][arr[0].length];
        new_arr = flipAndInvertImage(arr);

        System.out.println("Flipped");
        for(int i = 0; i<3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(new_arr[i][j]);
            System.out.println();
        }
     }
    public static int[][] flipAndInvertImage(int[][] image) {
        for(int i = 0; i<image.length; i++){
            int low = 0;
            int high = (image[i].length)-1;
            while(low<high){
                int temp = image[i][low];
                image[i][low] = image[i][high];
                image[i][high] = temp;
                low++;
                high--;
            }


            for(int j = 0; j<image[i].length; j++){
                image[i][j] = image[i][j]==0?1:0;
            }
        }
        return image;
    }
}