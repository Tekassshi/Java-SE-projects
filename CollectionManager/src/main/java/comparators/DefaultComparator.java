package comparators;

import data.Person;

import java.util.Comparator;

public class DefaultComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (!p1.getName().equals(p2.getName()))
            return p1.getName().compareTo(p2.getName());
        else {
            if (!p1.getCreationDate().equals(p2.getCreationDate()))
                return p1.getCreationDate().compareTo(p2.getCreationDate());
            else {
                if (p1.getHeight() != p2.getHeight())
                    return p1.getHeight() - p2.getHeight();
                else {
                    if (p1.getWeight() != p2.getWeight())
                        return Float.compare(p1.getWeight(), p2.getWeight());
                    else
                        return p1.getName().compareTo(p2.getName());
                }
            }
        }
    }
}