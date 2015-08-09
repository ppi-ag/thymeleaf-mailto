package de.ppi.fuwesta.thymeleaf.mail;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import de.ppi.fuwesta.thymeleaf.basic.ThymeleafTest;

/**
 * Test for {@link MailToDialect}.
 * 
 */
@RunWith(Parameterized.class)
public class MailThymeleafTest extends ThymeleafTest {

    /**
     * The filenames of tests.
     * 
     * @return a list of files with testspecification.
     * @throws IOException if something goes wrong.
     */
    @Parameters(name = "{0}")
    public static Collection<Object[]> getFilenames() throws IOException {
        return ThymeleafTest
                .getFilenames("classpath:/thymeleaf/mail/**/*.thtest");
    }

    /**
     * Initiates an object of type MailThymeleafTest.
     * 
     * @param name the name of the test.
     * @param testSpec the test-specification.
     */
    public MailThymeleafTest(String name, File testSpec) {
        super(name, testSpec);
    }

}
