import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PacketsChecker {
    public static final String FIRST_DIVISION_PACKET = "[[2]]";
    public static final String SECOND_DIVISION_PACKET = "[[6]]";

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\Kinga\\Downloads\\input13.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        Integer index = 1;
        Integer indices = 0;
        ArrayList<ArrayList<Object>> arrayOfArrays = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            ArrayList<Object> first = StringToArrayParser.extractArrayFromString(line, 0);
            line = br.readLine();
            ArrayList<Object> second = StringToArrayParser.extractArrayFromString(line, 0);
            line = br.readLine();

            addToArray(arrayOfArrays, first, second);

            indices = addIfGoodOrder(index, indices, first, second);
            index++;
        }

        System.out.println(indices);

        addToArray(arrayOfArrays, StringToArrayParser.extractArrayFromString(FIRST_DIVISION_PACKET, 0), StringToArrayParser.extractArrayFromString(SECOND_DIVISION_PACKET, 0));
        Collections.sort(arrayOfArrays, new PacketComparator());
        Integer multiplicationOfDividers = multiplyDividersPositions(arrayOfArrays);
        System.out.println(multiplicationOfDividers);

    }

    private static Integer multiplyDividersPositions(ArrayList<ArrayList<Object>> arrayOfArrays) {
        Integer multiplicationOfDividers = 1;
        Integer sortedIndex = 1;
        for (ArrayList<Object> array : arrayOfArrays) {
            if (array.toString().replace(" ", "").equals(FIRST_DIVISION_PACKET) || array.toString().replace(" ", "").equals(SECOND_DIVISION_PACKET)) {
                multiplicationOfDividers *= sortedIndex;
            }
            sortedIndex++;
        }
        return multiplicationOfDividers;
    }

    private static Integer addIfGoodOrder(Integer index, Integer indices, ArrayList<Object> first, ArrayList<Object> second) {
        Boolean goodOrder = new PacketComparator().compare(first, second) ==  -1 ? true: false ;
        if (goodOrder) {
            indices += index;
        }
        return indices;
    }

    private static void addToArray(ArrayList<ArrayList<Object>> arrayOfArrays, ArrayList<Object> first, ArrayList<Object> second) {
        arrayOfArrays.add(first);
        arrayOfArrays.add(second);
    }
}
