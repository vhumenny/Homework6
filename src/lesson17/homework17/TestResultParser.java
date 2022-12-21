package lesson17.homework17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestResultParser {
    public static void main(String[] args) throws IOException, NoSuchFieldException {
        TestResultParser testResultParser = new TestResultParser();
        File file = new File("src/lesson17/homework17/test.txt");
        Path path = Paths.get("src/lesson17/homework17/test.txt");

        System.out.println(testResultParser.parse("src/lesson17/homework17/test.txt"));
        System.out.println(testResultParser.parse(file));
        System.out.println(testResultParser.parse(path));
    }

    public TestResult parse(String path) throws FileNotFoundException, NoSuchFieldException {
        Scanner fileReader = new Scanner(new File(path));
        List<String> testResultsArrayList = new ArrayList<>();
        TestResult testResult;
        while (fileReader.hasNext()) {
            String line = fileReader.nextLine();
            testResultsArrayList.add(line);
        }
        if (testResultsArrayList.stream().anyMatch(s -> s.contains("tests started")) &&
                testResultsArrayList.stream().anyMatch(s -> s.contains("tests successful"))) {
            String testsQuantityString = testResultsArrayList.stream().filter(s -> s.contains("tests started")).
                    collect(Collectors.joining());
            int testsQuantity = Integer.parseInt(testsQuantityString.replaceAll("\\D", ""));
            String passedTestsString = testResultsArrayList.stream().filter(s -> s.contains("tests successful")).
                    collect(Collectors.joining());
            int passedTests = Integer.parseInt(passedTestsString.replaceAll("\\D", ""));
            String failedTestsString = testResultsArrayList.stream().filter(s -> s.contains("tests failed")).
                    collect(Collectors.joining());
            int failedTests = Integer.parseInt(failedTestsString.replaceAll("\\D", ""));
            testResult = new TestResult(testsQuantity, passedTests, failedTests, new Date());
        } else {
            throw new NoSuchFieldException("File doesn't contain test report");
        }
        return testResult;
    }

    public TestResult parse(File file) throws FileNotFoundException, NoSuchFieldException {
        Scanner fileReader = new Scanner(file);
        List<String> testResultsArrayList = new ArrayList<>();
        TestResult testResult;
        while (fileReader.hasNext()) {
            String line = fileReader.nextLine();
            testResultsArrayList.add(line);
        }
        if (testResultsArrayList.stream().anyMatch(s -> s.contains("tests started")) &&
                testResultsArrayList.stream().anyMatch(s -> s.contains("tests successful"))) {
            String testsQuantityString = testResultsArrayList.stream().filter(s -> s.contains("tests started")).
                    collect(Collectors.joining());
            int testsQuantity = Integer.parseInt(testsQuantityString.replaceAll("\\D", ""));
            String passedTestsString = testResultsArrayList.stream().filter(s -> s.contains("tests successful")).
                    collect(Collectors.joining());
            int passedTests = Integer.parseInt(passedTestsString.replaceAll("\\D", ""));
            String failedTestsString = testResultsArrayList.stream().filter(s -> s.contains("tests failed")).
                    collect(Collectors.joining());
            int failedTests = Integer.parseInt(failedTestsString.replaceAll("\\D", ""));
            testResult = new TestResult(testsQuantity, passedTests, failedTests, new Date());
        } else {
            throw new NoSuchFieldException("File doesn't contain test report");
        }
        return testResult;
    }

    public TestResult parse(Path path) throws IOException, NoSuchFieldException {
        Scanner fileReader = new Scanner(path);
        List<String> testResultsArrayList = new ArrayList<>();
        TestResult testResult;
        while (fileReader.hasNext()) {
            String line = fileReader.nextLine();
            testResultsArrayList.add(line);
        }
        if (testResultsArrayList.stream().anyMatch(s -> s.contains("tests started")) &&
                testResultsArrayList.stream().anyMatch(s -> s.contains("tests successful"))) {
            String testsQuantityString = testResultsArrayList.stream().filter(s -> s.contains("tests started")).
                    collect(Collectors.joining());
            int testsQuantity = Integer.parseInt(testsQuantityString.replaceAll("\\D", ""));
            String passedTestsString = testResultsArrayList.stream().filter(s -> s.contains("tests successful")).
                    collect(Collectors.joining());
            int passedTests = Integer.parseInt(passedTestsString.replaceAll("\\D", ""));
            String failedTestsString = testResultsArrayList.stream().filter(s -> s.contains("tests failed")).
                    collect(Collectors.joining());
            int failedTests = Integer.parseInt(failedTestsString.replaceAll("\\D", ""));
            testResult = new TestResult(testsQuantity, passedTests, failedTests, new Date());
        } else {
            throw new NoSuchFieldException("File doesn't contain test report");
        }
        return testResult;
    }
}
