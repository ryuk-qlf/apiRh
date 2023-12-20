package fr.facil.facilapi.service;

import fr.facil.facilapi.collections.Calendar;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface calendarService {

    List<Calendar> findAll();

    Calendar findById(String id);

    List<Calendar> findAllByUsername(String prenom, String nom);

    Calendar createOne(Calendar cal);

    Calendar updateOne(Calendar cal, String id);

    void deleteOne(String id);

    void sendOne(Calendar cal) throws IOException, ParseException;

}
