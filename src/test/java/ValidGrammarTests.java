import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;

public class ValidGrammarTests{
    @DisplayName("Valid Grammar Tests")
    @ParameterizedTest(name = "{0}")
    @MethodSource("listTestFiles")

    public void ValidGrammarTestSuite(String file){
        InputStream input = System.in;
        try{
            input = new FileInputStream(new File(file));
        }
        catch (IOException e)
        {
            System.out.println("File not found");
        }
        try{
            Jason parserInstance = new Jason(input);
            parserInstance.Program();
        }
        catch(ParseException e){
            String error = "\n*****ParseExeception encountered!****\n";
            fail(error+e.getMessage());
        }
        catch(TokenMgrError e){
            String error = "\n****TokenMgr Error encounterd!*****\n";
            fail(e.getMessage());
        }
        
    }

    private static List<String> listTestFiles(){
        List<String> results = new ArrayList<String>();
        String basePath = "src/test/resources/ValidGrammarTests";
        File[] files = new File(basePath).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                results.add(basePath+"/"+file.getName());
            }
        }
        return results;
    }
}
