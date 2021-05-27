package com.mercadolibre.calculadora_idade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
public class CalculadoraRestController {

    @GetMapping("/{day}/{month}/{year}")
    public String calcule(@PathVariable String day, @PathVariable String month, @PathVariable String year) throws ParseException {

        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(day + "/" + month + "/" + year));

        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

        dateOfBirth.add(Calendar.YEAR, age);

        if (today.before(dateOfBirth)) {
            age--;
        }

        return String.valueOf(age);

    }
}
