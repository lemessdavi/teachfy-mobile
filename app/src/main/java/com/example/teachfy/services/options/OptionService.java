package com.example.teachfy.services.options;

import com.example.teachfy.services.options.request.PostOptionRequest;
import com.example.teachfy.services.options.response.GetOptionsResponse;
import com.example.teachfy.services.options.response.PostOptionsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OptionService {

    @GET("cards/{cardId}/options")
    Call<GetOptionsResponse> getOptions(@Header("authorization") String token, @Path("cardID") int id);

    @POST("options")
    Call<PostOptionsResponse> postOptions(@Header("authorization") String token, @Body PostOptionRequest request);
}