package nesada.c4q.nyc.exam.backend;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import nesada.c4q.nyc.exam.helpers.Consumer;


public class AnimalApi {
    private static final String URL = "http://jsjrobotics.nyc//cgi-bin/12_21_2016_exam.pl";

    public static Request<String> buildDataRequest(Consumer<AnimalResponse> listener) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL,
                buildSuccessListener(listener),
                buildErrorListenr()
        );
        return request;
    }

    private static Response.ErrorListener buildErrorListenr() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Saw an error");
            }
        };
    }

    private static Response.Listener<String> buildSuccessListener(final Consumer<AnimalResponse> listener) {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                AnimalResponse result = AnimalResponse.parse(response);
                listener.accept(result);
            }
        };
    }
}
