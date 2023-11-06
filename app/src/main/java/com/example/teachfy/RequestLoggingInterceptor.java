package com.example.teachfy;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;
import okio.Buffer;

public class RequestLoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        // Log da URL da requisição
        System.out.println("Request URL: " + request.url());

        // Log do corpo da requisição
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            String requestBodyString = buffer.readUtf8();
            System.out.println("Request Body: " + requestBodyString);
        }

        // Continue com a execução da requisição
        return chain.proceed(request);
    }
}
