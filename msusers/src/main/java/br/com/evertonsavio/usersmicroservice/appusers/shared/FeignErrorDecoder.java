package br.com.evertonsavio.usersmicroservice.appusers.shared;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    Environment environment;
@Autowired
    public FeignErrorDecoder(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()){
            case 400:
                //return new BadRequest
                break;
            case 404:
            {
                if(s.contains("getAlbums"))
                return new ResponseStatusException(HttpStatus.valueOf("Not Found"));

                break;
            }
            case 500:
                return new ResponseStatusException(HttpStatus.valueOf("Algo deu errado!"));
            default:
                return new Exception(response.reason());
        }
        return null;
    }
}
