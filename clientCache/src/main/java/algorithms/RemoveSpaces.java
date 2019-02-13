package algorithms;

public class RemoveSpaces {
    // Null terminating strings are not used in Java.
    // For this question, assume that you are passed a
    // null terminated string (array of characters).
    static boolean is_white_char(char c) {
        // there can be more white space characters
        // but for simplicity lets assume that we have
        // only two white space character
        // i.e. space and tab
        if (c == ' ' || c == '\t') {
            return true;
        }
        return false;
    }

    static void remove_white_spaces (char[] s) {
        if (s == null ||
                s.length == 0 ||
                s[0] == '\0') {
            return;
        }

        // We will use read, write pointers here.
        // Write pointer will follow the read pointer
        // and only write characters read that are neither
        // a space (' ') nor a tab ('\t').

        int read_ptr = 0;
        int write_ptr = 0;
        while (read_ptr < s.length &&
                s[read_ptr] != '\0') {
            // Lets assume there are only two white
            // space characters: space and tab.
            if (!is_white_char(s[read_ptr])) {
                s[write_ptr] = s[read_ptr];
                ++write_ptr;
            }
            ++read_ptr;
        }

        // Let's mark the end of string.
        s[write_ptr]= '\0';
    }
}  