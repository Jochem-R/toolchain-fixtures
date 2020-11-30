package nl.praegus.fitnesse.junit.runner;

import fitnesse.junit.DescriptionFactory;
import fitnesse.testrunner.MultipleTestsRunner;
import fitnesse.wiki.WikiPage;
import nl.hsac.fitnesse.junit.HsacFitNesseRunner;
import nl.praegus.fitnesse.junit.testsystemlisteners.ConsoleLogListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.UnsupportedEncodingException;
import java.util.List;


public class ToolchainTestRunner extends HsacFitNesseRunner {
    public ToolchainTestRunner(Class<?> suiteClass) throws InitializationError {
        super(suiteClass);
        System.getProperties().setProperty("nodebug", "true");
    }


    @Override
    protected void runPages(List<WikiPage> pages, RunNotifier notifier) {
        super.runPages(pages, notifier);
    }

    //Add plain html listener for result html with embedded css/js and console log listener for fancy console output
    @Override
    protected void addTestSystemListeners(RunNotifier notifier, MultipleTestsRunner testRunner, Class<?> suiteClass, DescriptionFactory descriptionFactory) {
        super.addTestSystemListeners(notifier, testRunner, suiteClass, descriptionFactory);
        try {
            testRunner.addTestSystemListener(new ConsoleLogListener());
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }
    }
}
