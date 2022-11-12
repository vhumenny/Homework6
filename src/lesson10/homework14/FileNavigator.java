package lesson10.homework14;

import java.util.*;

public class FileNavigator {
    private HashMap<String, ArrayList<FileData>> filesList = new HashMap<>();

    public void add(String filePath, FileData fileData) {
        if (!fileData.getFilePath().equals(filePath)) {
            throw new IllegalArgumentException("Path-Key and filePath don't match for " + fileData.getFileName());
        }
        if (filesList.containsKey(filePath)) {
            filesList.get(filePath).add(fileData);
        } else {
            ArrayList<FileData> newList = new ArrayList<>();
            newList.add(fileData);
            filesList.put(filePath, newList);
        }
    }

    public ArrayList<FileData> find(String filePath) {
        ArrayList<FileData> newList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<FileData>> entry : getFilesList().entrySet()) {
            if (entry.getKey().contains(filePath)) {
                newList = entry.getValue();
            }
        }
        return newList;
    }

    public ArrayList<FileData> filterBySize(byte size) {
        ArrayList<FileData> filteredFiles = new ArrayList<>();
        for (Map.Entry<String, ArrayList<FileData>> entry : getFilesList().entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i).getCapacity() <= size) {
                    filteredFiles.add(entry.getValue().get(i));
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String filePath) {
        getFilesList().remove(filePath);
    }

    public ArrayList<FileData> sortBySize() {
        ArrayList<FileData> sortedFiles = new ArrayList<>();
        for (Map.Entry<String, ArrayList<FileData>> entry : getFilesList().entrySet()) {
            sortedFiles.addAll(entry.getValue());
        }
        sortedFiles.sort(Comparator.comparingInt(FileData::getCapacity));
        return sortedFiles;
    }

    public HashMap<String, ArrayList<FileData>> getFilesList() {
        return filesList;
    }

}
