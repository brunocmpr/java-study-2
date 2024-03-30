package sorting;

import java.util.*;

public class CollectionsArrays {
    public static void main(String[] args) {
        // **** Summary start *****
        /*
        The shortest and most elegant way to sort a collection or array is with Comparators,
        listing which param to compare.
        Lambdas should be used in complex cases that you can't express in comparators.
        */

        List<Person> listSummary = new ArrayList<>();
        listSummary.add(new Person(3L, "John"));
        listSummary.add(new Person(2L, "Jane"));
        listSummary.add(new Person(1L, "John"));

        listSummary.sort(Comparator.comparing(Person::name)); //1 param, name
        listSummary.stream().sorted(Comparator.comparing(Person::name) //order by name
                .thenComparing(Person::uniqueId, Comparator.reverseOrder()))//then order by id, descending
                .toList();

        Person[] persons = {new Person(3L, "John"),new Person(2L, "Jane"),
                new Person(1L, "John")};
        Arrays.sort(persons, Comparator.comparing(Person::name).thenComparing(Person::uniqueId, Comparator.reverseOrder()));

        int[] arrayInt = {3, 1, 2};
//        Arrays.sort(arrayInt, Comparator.reverseOrder()); //no way to reverse a primitive array in oneliner, unfort.
     /*    for (int i = 0; i < arrayInt.length / 2; i++) {
            int temp = arrayInt[i];
            arrayInt[i] = arrayInt[arrayInt.length - 1 - i];
            arrayInt[arrayInt.length - 1 - i] = temp;
        }*/

        Integer[] arrayInteger = {3, 1, 2};
        Arrays.sort(arrayInteger, Comparator.reverseOrder()); //boxed integer array can be reversed in oneliner

        //sort arrayInt in reverse order
        Arrays.sort(arrayInt);
        // **** Fim do resumo sobre sorting com as APIs Collections e Arrays *****

        //Meus testes
        List<Person> list = new ArrayList<>();
        list.add(new Person(3L, "John"));
        list.add(new Person(2L, "Jane"));
        list.add(new Person(1L, "John"));

        Collections.sort(list, (p1, p2) -> {
            int nameComparison = p1.name().compareTo(p2.name()); //name ascending
            int idComparison = p2.uniqueId().compareTo(p1.uniqueId()); //id descending
            if(nameComparison != 0 ) return nameComparison;
            return idComparison;
        });
        System.out.println("list with lambda: " + list);

        Comparator<Person> declaredComparatorWithLambda = (p1, p2) -> {
            int nameComparison = p1.name().compareTo(p2.name()); //name ascending
            int idComparison = p2.uniqueId().compareTo(p1.uniqueId()); //id descending
            if(nameComparison != 0 ) return nameComparison;
            return idComparison;
        };
        Collections.sort(list, declaredComparatorWithLambda);
        System.out.println("list with comparator: " + list);
        Collections.sort(list, Collections.reverseOrder(declaredComparatorWithLambda));

        Collections.sort(list, new PersonComparatorDeclaredTypeImproved());
        System.out.println("list with comparator: " + list);

        List<PersonComparable> listComparable = new ArrayList<>();
        listComparable.add(new PersonComparable(3L, "John"));
        listComparable.add(new PersonComparable(2L, "Jane"));
        listComparable.add(new PersonComparable(1L, "John"));
        Collections.sort(listComparable);
        System.out.println("list with personcomparable: " + listComparable);
        Collections.sort(listComparable, Collections.reverseOrder());
        System.out.println("list with comparable: " + listComparable);
        System.out.println("reverse list with comparable: " + listComparable);
    }

}

record Person(Long uniqueId, String name) {
    @Override
    public String toString() {
        return "sorting.Person{" + "uniqueId=" + uniqueId + ", name='" + name + '\'' + '}';
    }
}

record PersonComparable(Long uniqueId, String name) implements Comparable<PersonComparable> {
    @Override
    public String toString() {
        return "sorting.Person{" + "uniqueId=" + uniqueId + ", name='" + name + '\'' + '}';
    }
    @Override
    public int compareTo(PersonComparable o) {
        //Return value of this method should be negative for ascending order, positive for descending order and 0 for same
        int nameComparison = this.name.compareTo(o.name); //name ascending
        int idComparison = o.uniqueId.compareTo(this.uniqueId); //id descending
        if (nameComparison != 0) return nameComparison;
        return idComparison;
    }
}

class PersonComparatorDeclaredType implements Comparator<Person>{
    //ChatGPT suggested me sorting.PersonComparatorDeclaredTypeImproved, which looks more scalable
    @Override
    public int compare(Person p1, Person p2){
        int nameComparison = p1.name().compareTo(p2.name()); //name ascending
        int idComparison = p2.uniqueId().compareTo(p1.uniqueId()); //id descending
        if(nameComparison != 0 ) return nameComparison;
        return idComparison;
    }
}

class PersonComparatorDeclaredTypeImproved implements Comparator<Person>{
    @Override
    public int compare(Person p1, Person p2){
        Comparator<Person> nameComparison = Comparator.comparing(Person::name);
        Comparator<Person> idComparison = Comparator.comparing(Person::uniqueId).reversed();
        return nameComparison.thenComparing(idComparison).compare(p1, p2);
    }
}