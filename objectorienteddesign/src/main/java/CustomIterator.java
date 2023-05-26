import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomIterator implements Iterator<String> {

    /**
     * I got and Iterator that returns string like "ab", "ac"
     * if the next value is equal to previous
     * I need to return new Iterator with "ab" with 2
     * or else I return like "string" with 1
     */
    private final Iterator<String> originalIterator;
    private Pair current;
    private boolean isLast;

    public CustomIterator(Iterator<String> iterator) {
        this.originalIterator = iterator;

        if (originalIterator.hasNext()) {
            current = new Pair(originalIterator.next(), 1);
        }
        isLast = !originalIterator.hasNext();
    }

    @Override
    public boolean hasNext() {
        return originalIterator.hasNext() || isLast;
    }

    @Override
    public String next() {

        if (originalIterator.hasNext()) {
            Pair nextVal = new Pair(originalIterator.next(), 1);


            // Check for consecutive equal values
            while (originalIterator.hasNext() && current.key.equals(nextVal.key)) {
                nextVal = new Pair(originalIterator.next(), 1);
                current.value++;
            }

            if (!originalIterator.hasNext()) {

                if (nextVal.key.equals(current.key)) {
                    current.value++;
                } else {
                    isLast = true;
                }
            }
            Pair tmp = current;
            current = nextVal;


            return tmp.key + " with " + tmp.value;
        }

        if (isLast) {
            isLast = false;
            return current.key + " with " + current.value;
        }

        throw new NoSuchElementException(); // Or throw NoSuchElementException as per Iterator contract
    }

    class Pair {
        String key;
        int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ab", "ac", "ac", "ab", "ab", "ab", "ad", "ad", "ad");
        Iterator<String> iterator = new CustomIterator(strings.iterator());

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
