package com.yedam.exam;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	@Test
	public void toObject() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		String jsonstr = "{\"color\":\"red\",\"type\":\"suv\"}";
		Car car = om.readValue(jsonstr, Car.class);
		car.setColor("blue");
		String result = om.writeValueAsString(car);
		System.out.println(result);
		
		//Map map = om.readValue("https://jsonplaceholder.typicode.com/todos/1", Map.class);
		//System.out.println(map);
		assertEquals(car.getColor(), "blue");
	}

}
