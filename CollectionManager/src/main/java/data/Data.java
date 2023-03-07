package data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayDeque;
import java.util.Queue;

public class Data {
    @JacksonXmlElementWrapper(localName = "Collection")
    @JacksonXmlProperty(localName = "person")
    Queue<Person> collection = new ArrayDeque<>();

    public Data(Queue<Person> collection) {
        this.collection = collection;
    }

    public Queue<Person> getCollection() {
        return collection;
    }

    public void setCollection(Queue<Person> collection) {
        this.collection = collection;
    }
}
