package com.metehan.AndroidBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @PostMapping("/add")
    public ResponseEntity<String> createActor(@RequestBody Actor actor) {
        //Burada actorDto, actorDao kullanılsa daha güzel olabilir.
        Actor actor2 = new Actor();
        actor2.setFirstName(actor.getFirstName());
        actor2.setLastName(actor.getLastName());
        try {
            // Gelen kullanıcı bilgisini veritabanına kaydet
            actorRepository.save(actor2);

            // Başarı durumunda OK (200) cevabı döndür
            return new ResponseEntity<>("User added successfully", HttpStatus.OK);
        } catch (Exception e) {
            // Hata durumunda BAD REQUEST (400) cevabı döndür
            return new ResponseEntity<>("Error adding user: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
