package comparators;

import data.Person;

import java.util.Comparator;

public class HeightComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o2.getHeight() - o1.getHeight();
    }
}