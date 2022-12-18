import java.util.ArrayList;

public class StringToArrayParser {
    public static ArrayList<Object> extractArrayFromString(String line, Integer start) {
        int index = start + 1;
        ArrayList<Object> list = new ArrayList<>();
        String number = "";
        while (index < line.length()) {
            if (line.charAt(index) == '[') {
                index = addNewArray(line, index, list);
            } else if (line.charAt(index) == ',') {
                number = addNewNumber(list, number);
            } else if (line.charAt(index) == ']') {
                return returnFinishedList(list, number);
            } else {
                number += line.charAt(index);
            }
            index++;
        }
        return list;
    }

    private static ArrayList<Object> returnFinishedList(ArrayList<Object> list, String number) {
        if (!number.isEmpty()) {
            list.add(Integer.valueOf(number));
        }
        return list;
    }

    private static String addNewNumber(ArrayList<Object> list, String number) {
        if (!number.isEmpty()) {
            list.add(Integer.valueOf(number));
            number = "";
        }
        return number;
    }

    private static int addNewArray(String line, int index, ArrayList<Object> list) {
        ArrayList<Object> extractedList = extractArrayFromString(line, index);
        list.add(extractedList);
        index += extractedList.toString().replace(" ", "").length() - 1;
        return index;
    }
}
