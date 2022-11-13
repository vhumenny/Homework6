package lesson10.homework13.list;

import java.util.*;

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
        ArrayList<String> result = new ArrayList<>(new LinkedHashSet<>(arrayList));
        for (String s : result) {
            int counter = Collections.frequency(arrayList, s);
            System.out.println(s + ":" + counter);
        }
    }

    public ArrayList<OccurrencesMethods> findOccurrence(ArrayList<String> arrayList) {
        ArrayList<String> result = new ArrayList<>(new LinkedHashSet<>(arrayList));
        ArrayList<OccurrencesMethods> occurrencesMethods = new ArrayList<>();
        for (String s : result) {
            int counter = Collections.frequency(arrayList, s);
            occurrencesMethods.add(new OccurrencesMethods(s, counter));
        }
        return occurrencesMethods;
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
