package com.automation;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class ApiTestingPw {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        APIRequest request = playwright.request();
        APIRequestContext requestContext = request.newContext();

        String token = createToken(requestContext);
        String bookingId = createBooking(requestContext);
        updateBooking(requestContext, bookingId, token);
        getBooking(requestContext);
        getBookingById(requestContext, bookingId);
        deleteBooking(requestContext, bookingId, token);

        playwright.close();
    }
    private static void getBookingById(APIRequestContext requestContext, String bookingId){
        //get booking by id
        APIResponse getIdResponse = requestContext.get("https://restful-booker.herokuapp.com/booking/"+ bookingId);
        System.out.println("getId: " + getIdResponse.text());
        System.out.println("getId: " + getIdResponse.status());
    }
    private static void getBooking(APIRequestContext requestContext){

        //get booking all
        APIResponse getResponse = requestContext.get("https://restful-booker.herokuapp.com/booking");
        System.out.println("get: " + getResponse.text());
        System.out.println("get: " + getResponse.status());
    }
    private static void updateBooking(APIRequestContext requestContext, String bookingId, String token){
        String updateBookingBody = "{\n" +
                "    \"firstname\" : \"House\",\n" +
                "    \"lastname\" : \"White\",\n" +
                "    \"totalprice\" : 999,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        //update booking
        RequestOptions updateBookingOptions = RequestOptions.create();
        updateBookingOptions.setData(updateBookingBody);
        updateBookingOptions.setHeader("Content-Type", "application/json");
        updateBookingOptions.setHeader("Accept", "application/json");
        updateBookingOptions.setHeader("Cookie", "token="+token);


        APIResponse updateBookingResponse = requestContext.put("https://restful-booker.herokuapp.com/booking/"+bookingId, updateBookingOptions);
        System.out.println("updateBooking: " + updateBookingResponse.text());
        System.out.println("updateBooking: " + updateBookingResponse.status());
    }

    private static String createToken(APIRequestContext requestContext) {
        String tokenBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        //create token
        RequestOptions createTokenOptions = RequestOptions.create();
        createTokenOptions.setData(tokenBody);
        createTokenOptions.setHeader("Content-Type", "application/json");

        APIResponse tokenResponse = requestContext.post("https://restful-booker.herokuapp.com/auth", createTokenOptions);
        System.out.println("token: " + tokenResponse.text());
        System.out.println("token: " + tokenResponse.status());

        String responseBody = tokenResponse.text();
        // Parse the response body as JSON
        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
        // Extract the token value
        String token = jsonObject.get("token").getAsString();
        return token;
    }

    private static String createBooking(APIRequestContext requestContext){

        String createBookingBody = "{\n" +
                "    \"firstname\" : \"TEST\",\n" +
                "    \"lastname\" : \"black\",\n" +
                "    \"totalprice\" : 777,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        //create Booking
        RequestOptions createBookingOptions = RequestOptions.create();
        createBookingOptions.setData(createBookingBody);
        createBookingOptions.setHeader("Content-Type", "application/json");

        APIResponse createBookingResponse = requestContext.post("https://restful-booker.herokuapp.com/booking", createBookingOptions);
        System.out.println("createBooking: " + createBookingResponse.text());
        System.out.println("createBooking: " + createBookingResponse.status());

        String createBookingResponseBody = createBookingResponse.text();
        JsonObject createBookingJsonObject = JsonParser.parseString(createBookingResponseBody).getAsJsonObject();
        String bookingId = createBookingJsonObject.get("bookingid").getAsString();

        return bookingId;
    }

    private static void deleteBooking(APIRequestContext requestContext, String bookingId, String token){
        //delete booking
        RequestOptions deleteBookingOptions = RequestOptions.create();
        deleteBookingOptions.setHeader("Content-Type", "application/json");
        deleteBookingOptions.setHeader("Cookie", "token="+token);


        APIResponse deleteBookingResponse = requestContext.delete("https://restful-booker.herokuapp.com/booking/"+bookingId, deleteBookingOptions);
        System.out.println("deleteBooking: " + deleteBookingResponse.text());
        System.out.println("deleteBooking: " + deleteBookingResponse.status());

    }
}
