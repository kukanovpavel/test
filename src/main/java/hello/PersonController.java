package hello;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @RequestMapping(value ="/all" , method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public String getAll() {
        return  Application.getAllPerson().toString();
    }

    @RequestMapping(value = "/id" , method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public String getByID(@RequestParam(value="ID") long id) {
        String response = Application.getPersonByID(1L).toString();
        if (response.isEmpty()){
            return "Empty";
        }
        return response + id;
    }


}