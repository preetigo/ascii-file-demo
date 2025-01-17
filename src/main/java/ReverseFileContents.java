import java.io.*;

public class ReverseFileContents {

    public static void main(String[] args) {
        // Provide path to files
        try(InputStream inputStream = new FileInputStream("C:\\Users\\Binder\\input.txt");
            OutputStream outputStream = new FileOutputStream("C:\\Users\\Binder\\output.txt")) {

            // Invoke method to reverse the contents
            reverseContents(inputStream, outputStream);
            System.out.println("Successfully reversed contents");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static void reverseContents(InputStream inputStream, OutputStream outputStream) throws IOException {
        //Read the input stream
        StringBuilder content = new StringBuilder();
        try( BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = reader.readLine()) != null) {
                content.append(line);
            }
        }

        //reverse the contents
        content.reverse();

        // Write the contents to the output stream
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            writer.write(content.toString());
        }
    }
}
