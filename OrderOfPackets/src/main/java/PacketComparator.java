import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PacketComparator implements Comparator<ArrayList<Object>> {

    @Override
    public int compare(ArrayList<Object> first, ArrayList<Object> second) {
        for (int i = 0; i < first.size(); i++) {
            if (second.size() <= i) {
                return 1;
            }
            Object firstValue = first.get(i);
            Object secondValue = second.get(i);
            if (firstValue instanceof Integer && secondValue instanceof Integer) {
                if ((Integer) firstValue < (Integer) secondValue) {
                    return -1;
                } else if ((Integer) firstValue > (Integer) secondValue) {
                    return 1;
                }
            } else if (firstValue instanceof ArrayList && secondValue instanceof ArrayList) {
                Integer result = compare((ArrayList<Object>) firstValue, (ArrayList<Object>) secondValue);
                if (result != 0) {
                    return result;
                }
            } else {
                if (firstValue instanceof Integer) {
                    Integer result = compare(new ArrayList<>(Arrays.asList(firstValue)), (ArrayList<Object>) secondValue);
                    if (result != 0) {
                        return result;
                    }
                } else if (second.get(i) instanceof Integer) {
                    Integer result = compare((ArrayList<Object>) firstValue, new ArrayList<>(Arrays.asList(secondValue)));
                    if (result != 0) {
                        return result;
                    }
                }
            }
        }
        if (second.size() > first.size()) {
            return -1;
        } else {
            return 0;
        }
    }
}
