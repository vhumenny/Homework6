package lesson10.homework13.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
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
        if (getEntries().containsKey(name)) {
            newEntry = new Entry(name, getEntries().get(name).get(0));
        }
        return newEntry;
    }


    public ArrayList<Entry> findAll(String name) {
        ArrayList<Entry> newListOfEntries = new ArrayList<>();
        if (getEntries().containsKey(name)) {
            for (int i = 0; i < getEntries().get(name).size(); i++) {
                newListOfEntries.add(new Entry(name, getEntries().get(name).get(i)));
            }
        }
        return newListOfEntries;
    }

    public TelephoneBook(HashMap<String, ArrayList<Integer>> entries) {
        this.entries = entries;
    }

    public HashMap<String, ArrayList<Integer>> getEntries() {
        return entries;
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
