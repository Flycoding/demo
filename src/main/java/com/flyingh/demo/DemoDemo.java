package com.flyingh.demo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class DemoDemo {
	class Person {
		private int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}

	@Test
	public void test() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Person person = new Person();
		BeanUtils.setProperty(person, "id", 5);
		System.out.println(person.getId());
	}
}
