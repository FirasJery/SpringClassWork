package tn.esprit.firaseljary.aspects;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerad {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> HandelException(Exception exception)
    {
        Map map = new HashMap<>();
        map.put("error",exception.getMessage());
        return map;
    }

}