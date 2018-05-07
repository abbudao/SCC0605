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

public class InvalidGrammarTests{
    @DisplayName("Invalid Grammar Tests")
    @ParameterizedTest(name = "{0}")
    @MethodSource("listTestFiles")
    public void invalidGrammarTestSuite(String file){
        InputStream input = System.in;
        try{
            input = new FileInputStream(new File(file));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        boolean encounteredException = false;
        try{
            Jason parserInstance = new Jason(input);
            parserInstance.Program();
        }
        catch(ParseException e){
            encounteredException= true;
            System.out.println(e.getMessage());
        }
        catch(TokenMgrError e){
            encounteredException = true;
            System.out.println(e.getMessage());
        }
        finally{
            if(!encounteredException){
                fail("No exception found");
            }
        }
    }
    private static List<String> listTestFiles(){
        List<String> results = new ArrayList<String>();
        String basePath = "src/test/resources/InvalidGrammarTests";
        File[] files = new File(basePath).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                results.add(basePath+"/"+file.getName());
            }
        }
        return results;
    }
}

