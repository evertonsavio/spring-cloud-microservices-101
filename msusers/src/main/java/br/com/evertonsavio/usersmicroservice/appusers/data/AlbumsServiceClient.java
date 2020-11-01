package br.com.evertonsavio.usersmicroservice.appusers.data;

import br.com.evertonsavio.usersmicroservice.appusers.models.AlbumResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("albums-ws")
public interface AlbumsServiceClient {

    @GetMapping("/users/{id}/albumss")
    public List<AlbumResponseModel> getAlbums(@PathVariable String id);

}
