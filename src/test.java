import java.util.*;

public class test {
    static void main() {
//        System.out.println("aaa".indexOf("a"));
//        ArrayList<String> res = new ArrayList<>();
//        helper(new StringBuilder(),res, 0, new String [] {"a","b", "c"});
//        System.out.println(res.size());
//        System.out.println(res.toString());
//        System.out.println((1/3) * 3);
//        System.out.println(5 & 1);
//        System.out.println(Arrays.toString("abbacaacda".split("a")));

       List<Integer> list = new ArrayList<>();
       list.add(1);
       Map<Integer, List<Integer>> map = new HashMap<>();
       map.put(1,list);
       list.add(2);
       System.out.println(map.get(1));
    }



    public static void helper(StringBuilder s, ArrayList<String> resList, int index, String [] strings) {
        if (index == strings.length) {
            resList.add(s.toString());
            return;
        }

//        for (int i = 0; i < strings.length; i++) {
//            if (s.indexOf(strings[i]) == -1) {
//                s.append(strings[i]);
//                helper(s, resList, count+1, strings);
//                s.deleteCharAt(s.length()-1);
//            }
//        }

        String str = strings[index];
        s.append(str);
        helper(s,resList,index+1,strings);
        s.deleteCharAt(index);
    }


//public static void dfs(String[] arr, int index) {
//    if (index == arr.length) {
//        System.out.println(String.join("", arr));
//        return;
//    }
//
//    for (int i = index; i < arr.length; i++) {
//        swap(arr, index, i);
//        dfs(arr, index + 1);
//        swap(arr, index, i); // backtrack
//    }
//}
//
//    private static void swap(String[] arr, int i, int j) {
//        String temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    public static void main(String[] args) {
//        String[] arr = {"a", "b"};
//        dfs(arr, 0);
//    }
}
