package com.flyingh.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

class Person {
	public Person() {
		System.out.println("Hello world!!!");
	}

	public Person(String name) {
		System.out.println(name);
	}

	public Person(String name, int age) {
		System.out.println("name:" + name + ",age:" + age);
	}
}

class A {
	protected void foo() {

	}

	public void bar() {

	}
}

class B extends A {
	protected void fun() {

	}
}

public class Demo2 {
	class Foo {
		public void bar(String str) {
			System.out.println(str);
		}
	}

	@Test
	public void test5() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Method method = Foo.class.getMethod("bar", String.class);
		method.invoke(new Foo(), "hello");
		method.invoke(new Foo(), "flyingh");
	}

	@Test
	public void test4() {
		System.out.println(int.class.getMethods().length);
		System.out.println(void.class.getMethods().length);
		System.out.println(Void.TYPE.getMethods().length);
		System.out.println(int[].class.getMethods().length);
		System.out.println("*******************");
		Method[] methods = B.class.getMethods();
		System.out.println(methods.length);
		for (Method method : methods) {
			System.out.println(method);
		}
	}

	@Test
	public void test3() throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Constructor<? extends User> constructor = new User().getClass()
				.getConstructor(String.class, int.class);
		constructor.newInstance("flyingh", 24);
	}

	@Test
	public void test2() throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Constructor<User> constructor = User.class
				.getConstructor(String.class);
		constructor.newInstance("flyingh");
	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Constructor<User> constructor = User.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		System.out.println(constructor.newInstance());
	}
}