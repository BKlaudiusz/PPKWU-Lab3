# Zadanie 3 

### This REST API provides you informations about string you passed, in selected format(CSV, JSON, XML)

`POST /stringInformation`

    Put in body reqest two parameters
    body{
      "string": *Your String you pass*,
      "format": **selected format** ,
      }
      
      example:
       body{
        "string": "Where_is-1123!Banana,
        "format": "CSV",
      }

`Response for selected format/stringInformation`

 **CSV**
 
   **retrun file**
    
    {
      "file":file.csv
    }
   
      
 **JSON**
    
    {
      "data": 
        "Analysis{
          upperCase=2,
          stringToCheck='Where_is-1123!Banana',
          lowerCase=11,
          countNumber=4,
          specialMarks=3,
          hasCombination=true
      }"
    }
      
 **XML**
 
 Response:
    
    {
      "file":file.xml
     }
   **retrun file**
   
    <?xml version="1.0" encoding="UTF-8" standalone="no"?>
    <Analysis>
        <upperCase>2</upperCase>
        <stringToCheck>Where_is-1123!Banana</stringToCheck>
        <lowerCase>11</lowerCase>
        <countNumber>4</countNumber>
        <specialMarks>3</specialMarks>
        <hasCombination>true</hasCombination>
    </Analysis>
