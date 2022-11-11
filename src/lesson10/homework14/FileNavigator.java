package lesson10.homework14;

import java.util.*;

public class FileNavigator {
    private HashMap<String, ArrayList<FileData>> filesList = new HashMap<>();

    public void add(String filePath, FileData fileData, HashMap<String, ArrayList<FileData>> filesList) {
        if (!fileData.getFilePath().equals(filePath)) {
            throw new IllegalArgumentException("Path-Key and filePath don't match!");
        } else {
            if (filesList.containsKey(filePath)) {
                filesList.get(filePath).add(fileData);
            } else {
                ArrayList<FileData> newList = new ArrayList<>();
                newList.add(fileData);
                filesList.put(filePath, newList);
            }
        }
    }

    public ArrayList<FileData> find(String filePath, FileNavigator fileNavigator) {
        ArrayList<FileData> newList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<FileData>> entry : fileNavigator.getFilesList().entrySet()) {
            if (entry.getKey().contains(filePath)) {
                newList = entry.getValue();
            }
        }
        return newList;
    }

    public ArrayList<FileData> filterBySize(byte size, FileNavigator fileNavigator) {
        ArrayList<FileData> filteredFiles = new ArrayList<>();
        for (Map.Entry<String, ArrayList<FileData>> entry : fileNavigator.getFilesList().entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i).getCapacity() <= size) {
                    filteredFiles.add(entry.getValue().get(i));
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String filePath, FileNavigator fileNavigator) {
        fileNavigator.getFilesList().remove(filePath);
    }

    public ArrayList<FileData> sortBySize(FileNavigator fileNavigator) {
        ArrayList<FileData> sortedFiles = new ArrayList<>();
        for (Map.Entry<String, ArrayList<FileData>> entry : fileNavigator.getFilesList().entrySet()) {
            sortedFiles.addAll(entry.getValue());
        }
        sortedFiles.sort(Comparator.comparingInt(FileData::getCapacity));
        return sortedFiles;
    }

    public HashMap<String, ArrayList<FileData>> getFilesList() {
        return filesList;
    }

}
