package juc.day01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class Person {
    Integer age;
    String userName;

    public Person(String userName) {
        this.userName = userName;
    }
}

public class TansferValue {
    public void changeValue1(int age) {
        age = 30;
    }

    public void changeValue2(Person person) {
        person.setUserName("xxx");
    }

    public void changeValue3(String str) {
        str = "xxx";
    }

    public static void main(String[] args) {
        TansferValue tansferValue = new TansferValue();
        int age = 20;
        tansferValue.changeValue1(age);
        System.out.println("age=====" + age); //20

        Person person = new Person("fangkai");
        tansferValue.changeValue2(person);
        System.out.println("personName====" + person.getUserName());//xxx

        String str = "abc";
        tansferValue.changeValue3(str);
        System.out.println("String=====" + str);// xxx
    }
}
