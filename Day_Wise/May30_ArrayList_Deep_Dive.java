

public class May30_ArrayList_Deep_Dive {
    public static void main(String[] args) {
        // ! it is a Utility Class was in java.util.ArrayList
        // ! Syntax
        // @ ArrayList<Object_Type> lis = new ArrayList<>();
        // @ Below are the Three Syntaxes of Creating ArrayList
        // ArrayList<Integer> nums1 = new ArrayList<>();
        // ArrayList<Integer> nums2 = new ArrayList<>(10);
        // ArrayList<Integer> nums3 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));

        // ! > List.of(E e1,E e2,....) --> it is a static method which will gives An
        // ! immutable Collection
        // ! > Which we can't change but we can use them to pass to an ArrayList

        // ArrayList<Integer> nums4 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        // nums4.add(10);

        // ArrayList<Integer> nums5 = (ArrayList<Integer>) nums4.clone();
        // ArrayList<Integer> nums5 = new ArrayList<>(nums4.subList(0, 3));
        // System.out.println(nums5);

        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        // for(int i = 0; i<5; i++){

        // }

        // ArrayList<Integer> nums = new ArrayList<>(List.of(
        // 2, 0, 52, 65, 63, 2, 4, 8, 3, 52, 859, 1, 4, 11, 1, 2));

        // Integer[] nums = new Integer[] { 1, 8, 5, 6, 6, 3, 1, 1, 2, 3 };
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(nums));

    }
}
