package API;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class GetRequestIntro {

    @Test
    public void getRequesr() throws URISyntaxException, IOException {

        //To send a API call:
        //1. Open a client (Postman, terminal)
        //2. Specify the HTTP method (Get, Post)
        //3. Specify URL/endPoint
        //4. Add query parameters( if needed)
        //5. Add header parameters (Accept, content-Type)
        //6. Add body parameters (for Post)
        //7. Execute (click on Send button)

        //Open a client
        HttpClient client = HttpClientBuilder.create().build();
        //Specify URL/endPoint
        //https://petstore.swagger.io/v2/pet/{petID}
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("petstore.swagger.io");
        uri.setPath("v2/pet/2185");
        //Specify the HTTP method
        HttpGet get = new HttpGet(uri.build());
        //Add header parameters
        get.setHeader("Accept", "application/json");
        //Execute
        HttpResponse response = client.execute(get);

        System.out.println("Status code for Get request is " + response.getStatusLine().getStatusCode());

        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json", response.getEntity().getContentType().getValue());
    }
        @Test
    public void getRequest2() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
            URIBuilder uri = new URIBuilder();
            uri.setScheme("https");
            uri.setHost("petstore.swagger.io");
            uri.setPath("v2/pet/findByStatus");
            uri.setCustomQuery("status=sold");

            HttpGet httpGet = new HttpGet(uri.build());
            httpGet.setHeader("Accept", "application/json");

            HttpResponse response = client.execute(httpGet);

            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Assert.assertEquals("application/json", response.getEntity().getContentType().getValue());




    }
}
