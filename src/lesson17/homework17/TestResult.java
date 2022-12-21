package lesson17.homework17;

import java.util.Date;

public class TestResult {
    private int testsQuantity;
    private int passedTests;
    private int failedTests;
    private Date testsStartTime;

    public TestResult(int testsQuantity, int passedTests, int failedTests, Date testsStartTime) {
        this.testsQuantity = testsQuantity;
        this.passedTests = passedTests;
        this.failedTests = failedTests;
        this.testsStartTime = testsStartTime;
    }

    public int getTestsQuantity() {
        return testsQuantity;
    }

    public int getPassedTests() {
        return passedTests;
    }

    public int getFailedTests() {
        return failedTests;
    }

    public Date getTestsStartTime() {
        return testsStartTime;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "testsQuantity=" + testsQuantity +
                ", passedTests=" + passedTests +
                ", failedTests=" + failedTests +
                ", testsStartTime=" + testsStartTime +
                '}';
    }
}
