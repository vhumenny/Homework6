package lesson10.homework14;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        FileData fileData1 = new FileData("file1.txt", (byte) 20, "C:\\Users\\Admin\\dev\\Homework6");
        FileData fileData2 = new FileData("file2.txt", (byte) 30, "C:\\Users\\Admin\\dev\\Homework6");
        FileData fileData3 = new FileData("file3.txt", (byte) 40, "C:\\Users\\Admin\\dev\\Homework6");
        FileData fileData4 = new FileData("file4.txt", (byte) 20, "C:\\Users\\Admin\\Desktop\\A");
        FileData fileData5 = new FileData("file5.txt", (byte) 50, "C:\\Users\\Admin\\Desktop\\A");

        fileNavigator.add("C:\\Users\\Admin\\dev\\Homework6", fileData1);
        fileNavigator.add("C:\\Users\\Admin\\dev\\Homework6", fileData2);
        fileNavigator.add("C:\\Users\\Admin\\dev\\Homework6", fileData3);
        fileNavigator.add("C:\\Users\\Admin\\Desktop\\A", fileData4);
        fileNavigator.add("C:\\Users\\Admin\\Desktop\\A", fileData5);
        System.out.println("Result after using method add = " + fileNavigator.getFilesList());
        System.out.println("Result after using method find = " +
                fileNavigator.find("C:\\Users\\Admin\\dev\\Homework6"));
        System.out.println("Result after using method filterBySize = " + fileNavigator.filterBySize((byte) 30));
        fileNavigator.remove("C:\\Users\\Admin\\dev\\Homework6");
        System.out.println("Result after using method remove = " + fileNavigator.getFilesList());
        System.out.println("Result after using method sortBySize = " + fileNavigator.sortBySize());
    }
}
