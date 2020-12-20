package com.company;

import java.util.*;

//PECS
public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? super T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List limit(List<? super T> source, int size) {
        return source.subList(0, size);
    }

    public static <T> void add(List<? super T> source, T value) {
        source.add(value);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        if (containsAll(removeFrom, c2)) {
            int fstIndex = 0;
            int counter = 0;

            for (int i = 0; i < removeFrom.size(); i++) {
                if (c2.get(0).equals(removeFrom.get(i)) && c2.get(c2.size() - 1).equals(removeFrom.get(i + c2.size() - 1))) {
                    for (int j = 0; j < c2.size(); j++) {
                        if (c2.get(j).equals(removeFrom.get(j + i))) {
                            if (counter == c2.size() - 1) {
                                fstIndex = i;
                            }
                            counter++;
                        } else {
                            counter = 0;
                            break;
                        }
                    }
                }
            }
            removeFrom.subList(fstIndex, fstIndex + c2.size()).clear();
        }
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        if (Collections.indexOfSubList(c1, c2) != -1) {
            return true;
        }
        return false;
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        return c1.stream().anyMatch(c2::contains);
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<? super T>> List range(List<? extends T> list, T min, T max) {
        if (list.isEmpty()) return null;

        //  Comparator<T> objectComparator = new Comparator<T>() {
        //      @Override
        //     public int compare(T o1, T o2) {
        //         return Integer.compare(o1.hashCode(), o2.hashCode());
        //      }
        //};

        Comparator<T> cmp = Comparator.naturalOrder();
        list.sort(cmp);

        List<? super T> newList = newArrayList();
        Boolean flag = false;
        for (T entry : list) {
            if (entry.equals(min)) {
                flag = true;
            }
            if (flag) {
                newList.add(entry);
            }
            if (entry.equals(max)) {
                flag = false;
            }
        }
        return newList;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    public static <T> List range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        list.sort(comparator);
        List<? super T> newList = newArrayList();
        Boolean flag = false;
        for (T entry : list) {
            if (entry.equals(min)) {
                flag = true;
            }
            if (flag) {
                newList.add(entry);
            }
            if (entry.equals(max)) {
                flag = false;
            }
        }
        return newList;
    }


    public static void main(String[] args) {

        List<String> numbers1 = newArrayList();
        numbers1.add("A");
        numbers1.add("F");
        numbers1.add("C");
        numbers1.add("B");
        numbers1.add("E");
        numbers1.add("D");

/*
        List<String> numbers2 = newArrayList();

        numbers2.add("B");
        numbers2.add("C");

        List<String> number3= limit(numbers1,2);
        for (String entry : number3) {
            System.out.println(entry);
        }
        System.out.println(indexOf(numbers1,"C"));
*/
        Comparator<Integer> natural = Comparator.naturalOrder();

        for (Object entry : range(numbers1, "A", "D")) {
            System.out.println(entry);
        }
    }


}
