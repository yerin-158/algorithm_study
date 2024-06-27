package org.example.etc;

import java.util.Comparator;
import java.util.List;

/**
 * Created by robin on 6/23/24.
 *
 * @author robin
 * @version 6/23/24.
 * @implNote First created
 */
public class SortUtils {

  public static void sortDesc(List<Integer> list) {
    list.sort(Comparator.reverseOrder()); //기본 내림차순
  }

  public static void sortAsc(List<Integer> list) {
    list.sort(null); //기본 오름차순
  }

  public static class Person {
    public String name;
    public Integer age;
  }


  /**
   * 커스텀 정렬
   * @param people
   */
  public static void sortPerson(List<Person> people) {
    people.sort(Comparator.comparing((Person person) -> person.name)
        .thenComparing(person -> person.age).reversed());
  }

}
