package com.flyingh.demo;

import org.junit.Assert;
import org.junit.Test;

public class Demo {
	abstract class Hello {

	}

	enum Grade {
		A {
			@Override
			public String toString() {
				return "AAA";
			}
		},
		B {
			@Override
			public String toString() {
				return "B";
			}
		},
		C {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return null;
			}
		},
		D {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return null;
			}
		},
		E {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return null;
			}
		};

		private Grade() {
			// TODO Auto-generated constructor stub
		}

		public abstract String toString();
	}

	enum Sex {
		MAN, WOMAN;
	}

	@Test
	public void test3() {
		System.out.println(Grade.A);
		System.out.println(Grade.valueOf("A"));
		System.out.println(Grade.valueOf(Grade.class, "B"));
		System.out.println(Enum.valueOf(Grade.class, "B"));
		System.out.println(Grade.values());
		System.out.println(Grade.A.ordinal());
		System.out.println(Grade.A.name());
		System.out.println(Grade.A.compareTo(Grade.C));
		System.out.println("************");
		System.out.println(Grade.valueOf(Sex.class, "MAN"));
		System.out.println(Grade.valueOf(Sex.class, "WOMAN"));
		System.out.println(Enum.valueOf(Sex.class, "MAN"));
	}

	@Test
	public void test2() {
		Integer a = 1;
		int b = a;
		System.out.println(a);
		System.out.println(b);
	}

	@Test
	public void test() {
		int[] a = { 1, 2, 3 };
		int[] b = { 1, 2, 3 };
		Assert.assertArrayEquals(a, b);
	}
}
