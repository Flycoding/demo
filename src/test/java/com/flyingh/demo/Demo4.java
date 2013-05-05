package com.flyingh.demo;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

class User {
	private int id;
	private String name;
	private int age;

	public String getFoo() {
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String isName1() {
		return "flyingh";
	}

	public void setName1(String str) {

	}

}

public class Demo4 {
	@Test
	public void test5() throws IntrospectionException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor("name1", User.class);
		System.out.println(pd.getPropertyType());
		Method readMethod = pd.getReadMethod();
		System.out.println(readMethod.invoke(new User()));
	}

	@Test
	public void test4() throws IntrospectionException {
		// PropertyDescriptor pd = new PropertyDescriptor("foo", User.class);//
		// error
		PropertyDescriptor[] pds = Introspector.getBeanInfo(User.class)
				.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}
	}

	@Test
	public void test3() {
		List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
		Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,
				9, 10));
		list.removeAll(set);
		System.out.println(list);
	}

	@Test
	public void test2() throws IntrospectionException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor("name", User.class);
		Method writeMethod = pd.getWriteMethod();
		writeMethod.setAccessible(true);
		User user = new User();
		writeMethod.invoke(user, "flyingh");
		System.out.println(user.getName());
	}

	@Test
	public void test() throws IntrospectionException {
		PropertyDescriptor[] pds = Introspector.getBeanInfo(User.class,
				Object.class).getPropertyDescriptors();
		System.out.println(pds.length);
		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}
	}
}
