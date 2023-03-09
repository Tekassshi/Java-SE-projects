package data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayDeque;
import java.util.Queue;

@JacksonXmlRootElement(localName = "XML")
public class Collection {

    @JacksonXmlElementWrapper(localName = "Collection")
    @JacksonXmlProperty(localName = "Person")
    private Queue<Person> collection = new ArrayDeque<>();

    public Queue<Person> getCollection() {
        return collection;
    }

    public void setCollection(Queue<Person> collection) {
        this.collection = collection;
    }
}
