package lesson10.homework14;

import java.util.Objects;

public class FileData {
    private String fileName;
    private byte capacity;
    private String filePath;

    public FileData(String fileName, byte capacity, String filePath) {
        this.fileName = fileName;
        this.capacity = capacity;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public byte getCapacity() {
        return capacity;
    }

    public String getFilePath() {
        return filePath;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return capacity == fileData.capacity && Objects.equals(fileName, fileData.fileName) && Objects.equals(filePath, fileData.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, capacity, filePath);
    }

    @Override
    public String toString() {
        return "FileData{" +
                "fileName='" + fileName + '\'' +
                ", capacity=" + capacity +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
