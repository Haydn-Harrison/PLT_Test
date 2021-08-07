package Setup;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@CucumberOptions(features = {"src/test/java/features"}, glue = "Steps", plugin = {"pretty"}, publish = true)

        public class CucumberRunner extends AbstractTestNGCucumberTests {
    }