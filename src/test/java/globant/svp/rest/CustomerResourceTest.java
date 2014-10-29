package globant.svp.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;
import globant.svp.core.domain.Customer;

import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CustomerResourceTest {
	private static final String BASE_URL = "http://localhost:8080"
			+ "/Customer";

	@Test
	public void shouldCreateFollowAndDelete() {

		Customer customer = new Customer();
		customer.setFirstName("Mohammed Mahmudul");
		customer.setLastName("Alam");
		String requestJson = JSONUtil.convertTOJson(customer);
		RestTemplate rest = new TestRestTemplate();

		// Post new Customer
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> postData = new HttpEntity<String>(requestJson,
				headers);

		ResponseEntity<Customer> postResponse = rest.postForEntity(BASE_URL,
				postData, Customer.class);
		assertThat(postResponse.getStatusCode(), equalTo(HttpStatus.CREATED));

		// Test GET Opearation
		ResponseEntity<String> getResponse = rest.getForEntity(
				BASE_URL, String.class);
		MediaType contentType = getResponse.getHeaders().getContentType();


		System.out.println("XXXX>" + getResponse.getBody());
		// TODO: Assert that body matches the expected json


	}
}
