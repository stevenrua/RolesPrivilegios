package co.com.sofka.roles.privilegios.api.filter;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import reactor.core.publisher.Mono;
import java.io.IOException;

public class RequestFilter {

    public static Mono<String> validarToken(String token) {

        return Mono.fromCallable(() -> (new OkHttpClient())
                        .newCall(new Request.Builder().url(String.format("https://www.googleapis.com/oauth2/v3/tokeninfo?id_token=%s", token)).build()).execute())
                .map(Response::body)
                .map(responseBody -> {
                    try {
                        return responseBody.string();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                //.map(ResponseBody::string)
                //.onErrorMap(IOException.class, RuntimeException::new);

    }

}
