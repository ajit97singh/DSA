package src.src.ztmCourse;

public class ReverseAString {

    public static String reverse(String str){
        if(str.length() <= 1){
            return str;
        }
        return str.substring(str.length()-1) +reverse(str.substring(0, str.length()-1));
    }

    public static String reverseIterative(String str){
        StringBuilder result = new StringBuilder();
        for(int i = str.length() -1; i>=0; i--){
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseIterative("afqwefqwefb"));
    }
}
