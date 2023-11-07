import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextToASCIIArt {
    private Map<String, List<String>> asciiArtAlphabet;
    private int quantityLineAsciiAtrRepresentation = 14;
    private String[] textAsciiArtRepresentation;

    public TextToASCIIArt() {
        asciiArtAlphabet = new HashMap<>();
        alphabetLoader();
    }

    private void alphabetLoader() {
        File file = new File("./src/main/resources/Data.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()) {
                List<String> letterAsciiArtRepresentation = new ArrayList<>();
                String[] allLetterElements = bufferedReader.readLine().split(";");
                for (int i = 1; i < allLetterElements.length; i++) {
                    letterAsciiArtRepresentation.add(allLetterElements[i]);
                }
                asciiArtAlphabet.put(allLetterElements[0], letterAsciiArtRepresentation);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public void printTextInAsciiArtRepresentation(String text) {
        char[] textSpell = text.toUpperCase().toCharArray();
        textAsciiArtRepresentation = new String[quantityLineAsciiAtrRepresentation];
        for (int i = 0; i < quantityLineAsciiAtrRepresentation; i++) {
            StringBuilder asciiLayer = new StringBuilder();
            for (char letter : textSpell) {
                asciiLayer.append(asciiArtAlphabet.get(String.valueOf(letter)).get(i));
            }
            textAsciiArtRepresentation[i] = asciiLayer.toString();
        }
        StringBuilder finalText = new StringBuilder();
        for (String element : textAsciiArtRepresentation) {
            finalText.append(element + "\n");
        }
        System.out.println(finalText);
    }
}
