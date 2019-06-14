import java.util.*;

public class MallComparator implements Comparator<Mall> {
    @Override
    public int compare(Mall a, Mall b) {
        return a.name.compareToIgnoreCase(b.name);
    }
}