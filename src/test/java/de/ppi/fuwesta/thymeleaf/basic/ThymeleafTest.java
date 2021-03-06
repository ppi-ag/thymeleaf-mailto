package de.ppi.fuwesta.thymeleaf.basic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;
import org.thymeleaf.testing.templateengine.context.web.SpringWebProcessingContextBuilder;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;
import org.thymeleaf.testing.templateengine.report.ITestReporter;
import org.thymeleaf.testing.templateengine.testable.ITestResult;

import de.ppi.fuwesta.thymeleaf.mail.MailToDialect;

/**
 * Basis-Test for some thymeleaf-test.
 *
 */
public abstract class ThymeleafTest {

    /**
     * Thymeleaf testexecutor.
     */
    private static final TestExecutor EXECUTOR = new TestExecutor();

    /**
     * Testspecification.
     */
    private final File testSpec;

    /**
     * Configures {@link TestExecutor} and define the {@link IDialect}.
     */
    @BeforeClass
    public static void configTestExcecutor() {
        final List<IDialect> dialects = new ArrayList<>();
        dialects.add(new MailToDialect());
        dialects.add(new SpringStandardDialect());
        final SpringWebProcessingContextBuilder springPCBuilder =
                new SpringWebProcessingContextBuilder();
        springPCBuilder.setApplicationContextConfigLocation(null);
        EXECUTOR.setProcessingContextBuilder(springPCBuilder);
        EXECUTOR.setDialects(dialects);

    }

    /**
     * Find all filenames.
     * 
     * @param testDir the search - directory.
     * @return a Collection of files.
     * @throws IOException if something goes wrong.
     */
    protected static Collection<Object[]> getFilenames(String testDir)
            throws IOException {
        final PathMatchingResourcePatternResolver resolver =
                new PathMatchingResourcePatternResolver();
        final List<Object[]> result = new ArrayList<>();
        final Resource[] testResources = resolver.getResources(testDir);
        for (Resource file : testResources) {
            result.add(new Object[] { file.getFilename(), file.getFile() });
        }
        return result;
    }

    /**
     * @throws java.lang.Exception if something goes wrong.
     */
    @Before
    public void setUp() throws Exception {
        EXECUTOR.reset();
    }

    /**
     * Initiates an object of type ThymeleafTest.
     * 
     * @param name the name of the test.
     * @param testSpec the test-specification.
     */
    public ThymeleafTest(String name, File testSpec) {
        this.testSpec = testSpec;
    }

    /**
     * Test of the specification.
     */
    @Test
    public void testSpecification() {
        EXECUTOR.execute("file://" + testSpec.getAbsolutePath());
        assertResultOK(EXECUTOR.getReporter());
    }

    /**
     * Check the result.
     * 
     * @param reporter a testreporter.
     */
    private void assertResultOK(ITestReporter reporter) {
        for (String testName : reporter.getAllTestNames()) {
            final ITestResult result = reporter.getResultByTestName(testName);
            Assert.assertNull(result.getMessage());
        }
    }
}
