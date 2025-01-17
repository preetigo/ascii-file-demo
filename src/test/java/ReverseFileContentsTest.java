import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class ReverseFileContentsTest {

    @Test
    public void testFileReversal() throws IOException {
        // simulate input file content
        String inputContent = "Hey There!";
        InputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        // Use reflection to access the private reverseContents method
        try {
            Method method = ReverseFileContents.class.getDeclaredMethod("reverseContents", InputStream.class, OutputStream.class);
            method.setAccessible(true);
            method.invoke(null, inputStream, outputStream);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // Verify te contents aare reversed
        String expectedOutput = "!erehT yeH";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
}
