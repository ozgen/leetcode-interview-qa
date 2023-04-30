import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = List.of("aa","bb", "cc");

        EncodeDecodeString encodeDecodeString = new EncodeDecodeString();
        String encode = encodeDecodeString.encode(list);
        System.out.println(encode);
        List<String> decode = encodeDecodeString.decode(encode);
        decode.forEach(System.out::println);
    }
}
