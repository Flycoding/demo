package com.flyingh.demo2;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Assert;
import org.junit.Test;

public class Demo {
	
	@Test
	public void test5(){
		System.out.println(List.class.getGenericSuperclass());
		System.out.println(ArrayList.class.getGenericSuperclass());
		System.out.println(int[].class.getGenericSuperclass());
		System.out.println(Integer.class.getGenericSuperclass());
		System.out.println(Arrays.toString(List.class.getGenericInterfaces()));
	}
	
	static class A<T, E, K> {
		public void foo(T t, E e, K k) {

		}

		public static <T> void bar(T t) {

		}
	}

	public <T> void reverse(T[] ts) {
		for (int i = 0; i < ts.length / 2; i++) {
			T t = ts[i];
			ts[i] = ts[ts.length - 1 - i];
			ts[ts.length - 1 - i] = t;
		}
	}

	public <T> void swap(T[] ts, int i, int j) {
		check(i < ts.length && i >= 0);
		check(j < ts.length && j >= 0);
		T t = ts[i];
		ts[i] = ts[j];
		ts[j] = t;
	}

	private void check(boolean flag) {
		if (!flag) {
			throw new IllegalArgumentException();
		}
	}

	@Test
	public void test4() {
		Integer[] array = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(array));
		reverse(array);
		System.out.println(Arrays.toString(array));
	}

	@Test
	public void test3() {
		String[] strs = new String[] { "a", "b", "c", "d", "e" };
		System.out.println(Arrays.toString(strs));
		swap(strs, 0, 4);
		System.out.println(Arrays.toString(strs));
	}

	@Test
	public void test2() throws IllegalAccessException,
			InvocationTargetException {
		ConvertUtils.register(new DateLocaleConverter(Locale.getDefault(),
				"yyyy-MM-dd"), Date.class);
		Person person = new Person();
		BeanUtils.setProperty(person, "id", 2);
		BeanUtils.setProperty(person, "name", "haha");
		BeanUtils.setProperty(person, "age", 22);
		BeanUtils.setProperty(person, "birthday", "2012-12-31");
		System.out.println(person);
	}

	@Test
	public void test() throws IllegalAccessException,
			InvocationTargetException, NoSuchFieldException, SecurityException {
		System.out.println(getClass());
		System.out.println(getClass().getName());
		System.out.println(getClass().getCanonicalName());
		Assert.assertFalse(null instanceof Object);
		ConvertUtils.register(new DateTimeConverter() {
			{
				setPattern("yyyy-MM-dd");
			}

			@Override
			protected Class<?> getDefaultType() {
				return Date.class;
			}

		}, Date.class);
		// ConvertUtils.deregister();
		// ConverterFacade facade = (ConverterFacade) ConvertUtils.lookup(
		// String.class, Date.class);
		// Field field = facade.getClass().getDeclaredField("converter");
		// field.setAccessible(true);
		// DateConverter converter = (DateConverter) field.get(facade);
		// converter.setPattern("yyyy-MM-dd");

		Person person = new Person();
		BeanUtils.setProperty(person, "id", 1);
		BeanUtils.setProperty(person, "name", "flyingh");
		BeanUtils.setProperty(person, "age", 25);
		BeanUtils.setProperty(person, "birthday", "2012-12-31");
		System.out.println(person);
	}
}
