package interfaces;

import java.io.BufferedReader;
import java.io.IOException;

public interface AssemblableCommand {
    void buildObject();
    void buildObjectFromScript(BufferedReader reader) throws IOException;
}
