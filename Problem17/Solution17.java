import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This problem was asked by Google.
 * <p>
 * Example String : dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext
 * <p>
 * Given a string representing the file system in the above format,
 * return the length of the longest absolute path to a file in the abstracted file system.
 * If there is no file in the system, return 0.
 * Note:
 * The name of a file contains at least a period and an extension.
 * The name of a directory or sub-directory will not contain a period.
 */
public class Solution17 {

    private static int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
            while (lev + 1 < stack.size()) stack.pop(); // find parent
            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if (s.contains(".")) maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String filePath = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(lengthLongestPath(filePath));
    }
}