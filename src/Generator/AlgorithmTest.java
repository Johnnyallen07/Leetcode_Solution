package Generator;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmTest {
    public static void main(String[] args) {

        List<Object> c1 = new ArrayList<>();
        List<Object> c2 = new ArrayList<>();
        c1 = c2;
        System.out.println(c1);
    }
}
