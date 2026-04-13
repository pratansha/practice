package all.tech.practice.java8;

import all.tech.practice.java8.collectorsExamples.DepartmentEmployeeQuesJava8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static all.tech.practice.java8.collectorsExamples.DepartmentEmployeeQuesJava8.employeeList;

/*
What is Boxing/Unboxing in java :
---------------------------------
Boxing: The process of converting a primitive type into its corresponding Wrapper Object.
    Manual: Integer obj = Integer.valueOf(10);
    Automatic: Integer obj = 10; (This is called Autoboxing).

Unboxing: The process of converting a Wrapper Object back into its primitive type.
    Manual: int num = obj.intValue();
    Automatic: int num = obj; (This is called Auto-unboxing).

3 types of category :
---------------------
    1. Object Stream(Reference Types)
      => Stream<Integer> , Stream<String> , Stream<Employee>
      => It works with objects, Boxing & Unboxing required, Works with => collect(), groupingBy(), map(), flatMap().

    2. Primitive Stream(No Boxing/Unboxing Required i.e. faster)
      => IntStream ,LongStream ,DoubleStream (Mathematics Primitive Streams).
      => No Boxing/Unboxing i.e. fast., It provides numeric terminal ops => sum(), average(), max(), min().

    3. Below are the conversion:
       mapToInt()     from  Stream<t></t>         to    IntStream
       mapToLong()    from  Stream<t></t>         to    LongStream
       mapToDouble()  from  Stream<t></t>         to    DoubleStream
       boxed()        from  Int/Long/DoubleStream to    Stream<Integer/Long/Double>
       map()          from  Any Stream            to    Any Stream

  Example :
    Stream<Integer> → IntStream         // unboxing
    IntStream       → Stream<Integer>   // boxing
*/
public class StreamConcepts {
    public static void main(String[] args) {
        // Example:1 Creating Object Stream not Primitive Stream
        Stream<Integer> objectIntStream = Stream.of(1, 2, 3);  // 1,2,3 get auto-boxed to Integer
        System.out.println(objectIntStream.collect(Collectors.toList()));

        Stream<Integer> stream = Stream.of(1, 2, 3);
        IntStream primitiveInts = stream.mapToInt(Integer::intValue);  // mapToInt() => Extract a primitive int from each object.
        System.out.println(primitiveInts);

        // Example:2 4️⃣ When to use map() vs mapToInt()
        // Stream<Employee> → Stream<String>
        List<String> empNames = employeeList.stream().map(DepartmentEmployeeQuesJava8.Employee::getName).collect(Collectors.toList());
        System.out.println(empNames);

        // Example:3 :  mapToObj() Vs boxed() DIFFERENCES
        String apple = "AppLe";
        // mapToObj()
        System.out.println(apple.chars()
                .mapToObj(x -> {
                    if (x < 96) return String.valueOf(Character.toLowerCase((char) x));
                    else return String.valueOf(Character.toUpperCase((char) x));
                }).collect(Collectors.joining()));
        // boxed()
        System.out.println(apple.chars().boxed().map(x -> {
            if (x < 96) return String.valueOf(Character.toLowerCase((char) x.intValue()));
            else return String.valueOf(Character.toUpperCase((char) x.intValue()));
        }).collect(Collectors.joining()));
    }
}
