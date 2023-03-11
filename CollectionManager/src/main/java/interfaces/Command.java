package interfaces;

import java.io.BufferedReader;
import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}
