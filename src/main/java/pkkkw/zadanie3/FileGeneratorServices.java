package pkkkw.zadanie3;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class FileGeneratorServices {

    @ResponseBody
    @RequestMapping(value = "/stringInformation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> checkString(HttpServletRequest request) {

        String ApiUrl ="http://localhost:8080/checkString?stringToCheck=";
        RestTemplate restTemplate = new RestTemplate();
        if(request.getParameter("format").equals("JSON"))
        {
            return restTemplate.getForObject(ApiUrl.concat(request.getParameter("string")),HashMap.class);
        }



        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String cheasdasdackString() {
       return  "AAAAAA";
    }
}


