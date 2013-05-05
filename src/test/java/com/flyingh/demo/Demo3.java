package com.flyingh.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Test;

class Foo {
	public int a = 5;
	@SuppressWarnings("unused")
	private String name = "flyingh";
	@SuppressWarnings("unused")
	private static int age = 24;

	public static void main(String[] args) {
		System.out.println("hello world!!!");
	}
}

public class Demo3 {
	@Test
	public void test2() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		Field field = Foo.class.getField("a");
		System.out.println(field.get(new Foo()));
		System.out.println(field.getClass());
		System.out.println(field.getClass().getName());
		System.out.println(field.getType());

		Field nameField = Foo.class.getDeclaredField("name");
		nameField.setAccessible(true);
		System.out.println(nameField.get(new Foo()));
		System.out.println(nameField.getType());
		System.out.println("***********");
		Field ageField = Foo.class.getDeclaredField("age");
		ageField.setAccessible(true);
		System.out.println(ageField.getInt(null));
	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Method mainMethod = Foo.class.getMethod("main", String[].class);
		mainMethod.invoke(null,
				(new Object[] { new String[] { "a", "b", "c" } }));
		mainMethod.invoke(null, (Object) new String[] { "a", "b", "c" });
		System.out.println(Arrays.asList("a", "b", "c"));
		System.out.println(Arrays.asList(1, 2, 3));
		System.out.println(Arrays.asList(new String[] { "a", "b", "c" }));
		System.out.println(Arrays.asList(new int[] { 1, 2, 3 }));
		System.out.println(Arrays.toString(new int[] { 1, 2, 3, }));
	}
}
