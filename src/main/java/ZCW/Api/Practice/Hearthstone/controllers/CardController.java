package ZCW.Api.Practice.Hearthstone.controllers;

import ZCW.Api.Practice.Hearthstone.services.*;
import kong.unirest.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {

    private static CardService service;

    @Autowired
    public CardController(CardService serv) { service = serv; }

    @GetMapping("/cards/{classname}")
    public ResponseEntity<?> getClassCards(@PathVariable String classname) {
        HttpResponse<String> response = Unirest.get("https://omgvamp-hearthstone-v1.p.rapidapi.com/cards/classes/Mage")
                .header("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "4c4e379b8cmsh5b8ee3f43ccd278p1a858cjsn82edf9884af0")
                .asString();
       return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

}
