package lesson10.homework13.list;

import java.util.ArrayList;
import java.util.Objects;

public class OccurrencesMethods {
    private String name;
    private Integer occurrence;

    public void countOccurrence(ArrayList<String> arrayList, String newString) {
        int counter = 0;
        for (String s : arrayList) {
            if (s.equals(newString)) {
                counter++;
            }
        }
        System.out.println("newString is found " + counter + " times in ArrayList");
    }

    public void calcOccurrence(ArrayList<String> arrayList) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            int counter = 0;
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j))) {
                    counter++;
                }
                if (j == arrayList.size() - 1 && !result.contains(arrayList.get(i) + ":" + counter)) {
                    result.add(arrayList.get(i) + ":" + counter);
                    System.out.println(arrayList.get(i) + ":" + counter);
                }
            }
        }
    }

    public ArrayList<OccurrencesMethods> findOccurrence(ArrayList<String> arrayList) {
        ArrayList<OccurrencesMethods> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            int counter = 0;
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j))) {
                    counter++;
                }
                if (j == arrayList.size() - 1 && !result.contains(new OccurrencesMethods(arrayList.get(i), counter))) {
                    result.add(new OccurrencesMethods(arrayList.get(i), counter));
                }
            }
        }
        return result;
    }

    public OccurrencesMethods(String name, Integer occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public OccurrencesMethods() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OccurrencesMethods that = (OccurrencesMethods) o;
        return Objects.equals(name, that.name) && Objects.equals(occurrence, that.occurrence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, occurrence);
    }

    @Override
    public String toString() {
        return "{name:\"" + name +
                "\", occurrence:" + occurrence +
                '}';
    }
}
