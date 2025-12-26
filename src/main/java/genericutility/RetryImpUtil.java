package genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpUtil implements IRetryAnalyzer {

    int count = 0;
    int retrylimit = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < retrylimit) {
            count++;
            return true;
        }
        return false;
    }
}


