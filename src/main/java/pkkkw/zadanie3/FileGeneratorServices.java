package pkkkw.zadanie3;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;


@RestController
public class FileGeneratorServices {

    @ResponseBody
    @RequestMapping(value = "/stringInformation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> checkString(HttpServletRequest request) throws IOException {

        String ApiUrl ="http://localhost:8080/checkString?stringToCheck=";
        RestTemplate restTemplate = new RestTemplate();
        HashMap MapAnalisys = restTemplate.getForObject(ApiUrl.concat(request.getParameter("string")),HashMap.class);

        if(request.getParameter("format").equals("JSON"))
        {
            return MapAnalisys;
        }
        HashMap<String, Object> map = new HashMap<>();
        String input = (String) MapAnalisys.get("data");
        input =  input.replace("Analysis", "");
        input =  input.replace("{", "");
        input =  input.replace("}", "");
        String[] parts = input.split(", ");

        if(request.getParameter("format").equals("CSV"))
        {
            StringBuilder toReturn = new StringBuilder();
            for (int i = 0; i < parts.length; i++) {
                toReturn.append(parts[i]).append(" \n  ");
            }
            map.put("data", toReturn.toString());
            return map;
        }else if(request.getParameter("format").equals("XML"))
        {
            StringBuilder toReturn = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");

            for (int i = 0; i < parts.length; i++) {
                String[] smallPart = parts[i].split("=");

                toReturn.append("<").append(smallPart[0]).append(">").append(smallPart[1]).append("</").append(smallPart[0]).append(">");
            }
            map.put("data", toReturn.toString());
            return map;
        }



        return null;
    }
}


