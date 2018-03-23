package tds.irisshared.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tds.irisshared.content.ContentException;

@Component
@Scope("singleton")
public class ContentLocation implements IContentLocation {

    @Override
    public String getFileLocation(String id) {
        String subDirectory;
        id = id.toLowerCase();

        if(id.matches("i-[0-9]+-[0-9]+(-[0-9a-zA-Z]+)?")) {
            subDirectory = "Items/";
        } else if (id.matches("p-[0-9]+-[0-9]+(-[0-9a-zA-Z]+)?")) {
            subDirectory = "Stimuli/";
        } else {
            throw new IllegalArgumentException();
        }

        return subDirectory;
    }
}
