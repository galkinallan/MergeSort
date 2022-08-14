package ru.galkinallan.sorter;



import java.util.ArrayList;
import java.util.List;

public class Sorter {


    public List<Integer> sortInt(List<Integer> list1, List<Integer> list2) {
        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList<>();

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }
        while (i < list1.size()) {
            result.add(list1.get(i++));
        }
        while (j < list2.size()) {
            result.add(list2.get(j++));
        }

        return result;
    }

    public List<String> sortString(List<String> list1, List<String> list2) {
        int i = 0;
        int j = 0;

        List<String> result = new ArrayList<>();

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).compareTo(list2.get(j)) == -1) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }
        while (i < list1.size()) {
            result.add(list1.get(i++));
        }
        while (j < list2.size()) {
            result.add(list2.get(j++));
        }

        return result;
    }



}
