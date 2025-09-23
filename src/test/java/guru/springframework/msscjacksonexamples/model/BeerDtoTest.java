package guru.springframework.msscjacksonexamples.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTest
class BeerDtoTest extends BaseTest {

	@Test
	void testSerializeDto() throws JsonProcessingException {
		BeerDto beerDto = getDto();

		String jsonString = objectMapper.writeValueAsString(beerDto);

		System.out.println(jsonString);
	}

	@Test
	void testDeserialize() throws JsonMappingException, JsonProcessingException {
		String json = "{\"beerId\":\"e5ef7f9c-b0b3-41e7-9b77-7cd4936d076d\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":121212121212,\"price\":12.99,\"createdDate\":\"2025-09-22T08:45:52.16575117+02:00\",\"lastUpdatedDate\":\"2025-09-22T08:45:52.16578831+02:00\"}";
		
		BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
		
		System.out.println(beerDto);
	}
}
