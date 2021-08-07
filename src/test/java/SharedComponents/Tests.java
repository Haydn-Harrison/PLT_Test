package SharedComponents;

import java.io.IOException;

public class Tests {

    public void ThrowAssertionError(String page) throws IOException {
        Helper helper = new Helper();
        helper.takeScreenshot(page);
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }


}
