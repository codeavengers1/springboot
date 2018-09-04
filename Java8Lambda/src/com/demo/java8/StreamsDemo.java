package com.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {

	public static void main(String[] args) {
		List<String> names=Arrays.asList("gopal","seema","kirthy","suman","shantanu","kamal");
		List<String> filteredNames=names.stream().filter(s->s.startsWith("s")).collect(Collectors.toList());

		filteredNames.stream().forEach(System.out::println);
	}

}
