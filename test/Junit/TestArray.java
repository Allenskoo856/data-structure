package Junit;

import dataStruct.array.Array;
import org.junit.Test;

/**
 * @author : Administrator
 * @create 2018-10-31 21:37
 */
public class TestArray {

    @Test
    public void testArray() {
        Array az = new Array(5);
        az.addLast(12);
        az.addLast(14);
        az.addLast(15);
        az.addLast(16);
        az.addLast(17);
        az.addLast(17);
        System.out.println(az);
    }

    @Test
    public void testStudent() {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice", 100));
        arr.addLast(new Student("Bob", 66));
        arr.addLast(new Student("Charlie", 88));
        System.out.println(arr);
    }


}
