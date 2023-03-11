package data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Deque;

@JacksonXmlRootElement(localName = "XML")
public class Collection {
    @JacksonXmlProperty(localName = "InitializationDate")
    private ZonedDateTime init_date = null;

    @JacksonXmlElementWrapper(localName = "Collection")
    @JacksonXmlProperty(localName = "Person")
    private Deque<Person> collection = new ArrayDeque<>();

    public Deque<Person> getCollection() {
        return collection;
    }

    public void setCollection(Deque<Person> collection) {
        this.collection = collection;
    }

    public ZonedDateTime getInit_date() {
        return init_date;
    }

    public void setInit_date(ZonedDateTime init_date) {
        this.init_date = init_date;
    }
}
