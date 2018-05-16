package lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @Author longchao
 * @Date 2018/1/24.
 */
public class LambdaAndStream {


    public static void main(String [] args) {
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };
        /**
         * 工资高于1400的php程序员
         */
        //salaryMoreThan1400(phpProgrammers);

        /**
         * 自定义filter得到工资高于1400的java程序员
         */
        //customFilter(javaProgrammers);

        /**
         * 使用limit限制结果个数
         */
        //limitResult(javaProgrammers);

        /**
         * 根据工资排序
         */
        //sortBySalary(javaProgrammers);

        /**
         * lambda和map结合
         */
        //lambdaWithMap(javaProgrammers);

        /**
         * anyMatch
         */
        anyMatch(javaProgrammers);

    }

    /**
     * 使用stream+filter来过滤
     * @param javaProgrammers
     * @param phpProgrammers
     */
    public static void salaryMoreThan1400(List<Person> phpProgrammers) {
        phpProgrammers.stream().filter(p -> (p.getSalary() > 1400)).forEach(p -> System.out.println(p.getFirstName()+p.getSalary()));
    }

    /**
     * 自定义filter来过滤
     * @param javaProgrammers
     */
    public static void customFilter(List<Person> javaProgrammers) {
        Predicate<Person> salaryFilter = p -> (p.getSalary() > 1400);
        javaProgrammers.stream().filter(salaryFilter).forEach(p ->System.out.println(p.getFirstName()+"" +p.getSalary()));
    }

    /**
     * 使用limit对结果进行处理，限制结果个数
     * @param javaProgrammers
     */
    public static void limitResult(List<Person> javaProgrammers) {
        javaProgrammers.stream().limit(2).forEach(p -> System.out.println(p.getFirstName()+p.getSalary()));
        javaProgrammers.stream().filter(p -> (p.getSalary() > 1400)).limit(3).forEach(p -> System.out.println(p.getFirstName()+p.getSalary()));
    }

    /**
     * 对集合进行排序并把 前5个结果/最小值/最大值 结果放到集合中
     * @param javaProgrammers
     */
    public static void sortBySalary(List<Person>javaProgrammers) {
        /**
         * 排序
         */
        List<Person> sortBySalary = javaProgrammers.stream()
                .sorted((p,p2) -> (p.getSalary() - p2.getSalary()))
                .limit(5)
                .collect(toList());
        sortBySalary.forEach(p -> System.out.println(p.getFirstName() + p.getSalary()));

        /**
         * 排序后取最小值
         */
        Person minPerson = javaProgrammers.stream()
                .min((p,p2) -> (p.getSalary() - p2.getSalary())).get();

        /**
         * 排序后取最大值
         */
        Person maxPerson = javaProgrammers.stream()
                .max((p,p2) -> (p.getSalary() - p2.getSalary())).get();

        System.out.println(maxPerson + "  " +minPerson);
    }

    /**
     * lambda和map结合
     * @param javaProgrammers
     */
    public static void lambdaWithMap(List<Person> javaProgrammers) {
        /**
         * 将javaDevelopers的firstName拼成字符串
         */
        String javaDevelopers = javaProgrammers.stream()
                .map(Person::getFirstName)
                .collect(joining(" ; "));
        System.out.println(javaDevelopers);

        /**
         * 将javaDevelopers的firstName存放到Set中
         */
        Set<String> javaDevFirstName = javaProgrammers.stream()
                .map(Person::getFirstName)
                .collect(toSet());
        System.out.println(javaDevFirstName);

        /**
         * 将javaDevelopers的firstName存放到treeSet中
         */
        TreeSet<String> javaDevLastName = javaProgrammers.stream()
                .map(Person::getLastName)
                .collect(toCollection(TreeSet::new));
        System.out.println(javaDevLastName);

        /**
         * 并发
         */
        javaDevLastName.parallelStream().forEach(p -> System.out.print(p));
    }

    public static void anyMatch(List<Person> javaProgrammers) {
        Boolean result = javaProgrammers.stream().anyMatch(javaProgrammer ->
        javaProgrammer.getFirstName().equals("Addison"));
        System.out.print(result);
    }
}
