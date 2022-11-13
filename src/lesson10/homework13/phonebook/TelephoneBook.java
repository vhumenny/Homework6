package lesson10.homework13.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TelephoneBook {

    private HashMap<String, ArrayList<Integer>> entries;

    public void add(String name, Integer telephone) {
        if (getEntries().containsKey(name)) {
            getEntries().get(name).add(telephone);
        } else {
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(telephone);
            entries.put(name, newList);
        }
    }

    public Entry find(String name) {
        Entry newEntry = null;
        for (Map.Entry<String, ArrayList<Integer>> entry : getEntries().entrySet()) {
            if (entry.getKey().equals(name)) {
                newEntry = new Entry(entry.getKey(), entry.getValue().get(0));
                break;
            }
        }
        return newEntry;
    }

    public String findAll(String name) {
        String result = null;
        for (Map.Entry<String, ArrayList<Integer>> entry : getEntries().entrySet()) {
            if (entry.getKey().equals(name)) {
                result = "Name: " + entry.getKey() + ": Telephones: " + entry.getValue() + "\n";
            }
        }
        return result;
    }

    public TelephoneBook(HashMap<String, ArrayList<Integer>> entries) {
        this.entries = entries;
    }

    public HashMap<String, ArrayList<Integer>> getEntries() {
        return entries;
    }

    public void setEntries(HashMap<String, ArrayList<Integer>> entries) {
        this.entries = entries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneBook that = (TelephoneBook) o;
        return Objects.equals(entries, that.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entries);
    }
}
