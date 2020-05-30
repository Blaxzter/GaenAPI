package garuntimeenv.apicomponents;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.MalformedJsonException;
import garuntimeenv.utils.ProblemLoader;

import java.io.*;

public class ProblemConstrainDefinition {

    private File jsonFile;
    private String path;
    private JsonArray jsonObject;

    public ProblemConstrainDefinition(String path) {
        this.path = path;
    }

    public ProblemConstrainDefinition(File jsonFile) {
        this.jsonFile = jsonFile;
    }

    public ProblemConstrainDefinition(JsonArray jsonObject) {
        this.jsonObject = jsonObject;
    }

    void getJson() throws FileNotFoundException {
        if (jsonFile != null) {
            if (jsonFile.isFile() && jsonFile.canRead()) {
                InputStream inputStream = new FileInputStream(jsonFile);
            }
        }
    }

    /**
     * Takes a filepath to a problem and returns the json array
     *
     * @param filepath The filepath of the file that contains the json
     * @return The json array containing the problem instances
     * @throws FileNotFoundException  If the file is not found
     * @throws MalformedJsonException If the json couldn't be parsed
     */
    private JsonArray readFileByPath(String filepath) throws FileNotFoundException, MalformedJsonException {

        InputStream input = ProblemLoader.class.getResourceAsStream("/problems/" + filepath);
        if (input == null) {
            input = ProblemLoader.class.getClassLoader().getResourceAsStream(filepath);
        }

        if(input == null) {
            throw new FileNotFoundException("File " + filepath + " not found");
        }
        return readInputStream(input);
    }

    private JsonArray readInputStream(InputStream input) throws MalformedJsonException {
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(
                new InputStreamReader(input)
        );

        if (jsonElement.isJsonArray()) {
            return jsonElement.getAsJsonArray();
        }

        throw new MalformedJsonException("The problem json wasn't an array.");
    }

    public void loadProblem() {

    }

    public JsonArray getJsonConstraints() {
        return jsonObject;
    }
}
