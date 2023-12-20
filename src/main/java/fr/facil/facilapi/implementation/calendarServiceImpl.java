package fr.facil.facilapi.implementation;

import biweekly.io.TimezoneAssignment;
import biweekly.io.TimezoneInfo;
import biweekly.property.CalendarScale;
import biweekly.property.Organizer;
import fr.facil.facilapi.collections.Calendar;
import fr.facil.facilapi.repository.CalendarRepository;
import fr.facil.facilapi.service.EmailSenderService;
import fr.facil.facilapi.service.calendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class calendarServiceImpl implements calendarService {

    @Autowired
    private CalendarRepository repository;

    @Autowired
    private EmailSenderService senderService;

    @Override
    public List<Calendar> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Calendar findById(String id) {
        return this.repository.findOneById(id);
    }

    @Override
    public List<Calendar> findAllByUsername(String prenom, String nom) {

        List<Calendar> listCalendar = this.repository.findAll();
        List<Calendar> listCalendarFilter = new ArrayList<>();
        for (Calendar cal: listCalendar){

            if (cal.getUser().getFirst_name().equalsIgnoreCase(prenom) && cal.getUser().getLast_name().equalsIgnoreCase(nom)){
                listCalendarFilter.add(cal);
            }

        }

        return listCalendarFilter;
    }

    @Override
    public Calendar createOne(Calendar cal) {
        return this.repository.save(cal);
    }

    @Override
    public Calendar updateOne(Calendar cal, String id) {

        cal.setId(id);

        return this.repository.save(cal);
    }

    @Override
    public void deleteOne(String id) {

        Calendar cal = this.repository.findOneById(id);

        this.repository.delete(cal);
    }

    @Override
    public void sendOne(Calendar cal) throws IOException, ParseException {
        ICalendar ical = new ICalendar();

        ical.setMethod("REQUEST");
        ical.setCalendarScale(CalendarScale.gregorian());

        TimeZone javaTz = TimeZone.getTimeZone("Europe/Paris");
        TimezoneAssignment paris = TimezoneAssignment.download(javaTz, true);

        ical.getTimezoneInfo().setDefaultTimezone(paris);

        VEvent event = new VEvent();

        event.setDescription(cal.getDescription());
        event.setSummary(cal.getTitle());

        Date dateStart = null;
        SimpleDateFormat v_dateFormat = new SimpleDateFormat("yyyyMMdd");

        dateStart = v_dateFormat.parse(cal.getStartDate());
        dateStart.setHours(Integer.parseInt(cal.getStartTime().getH()));
        dateStart.setMinutes(Integer.parseInt(cal.getStartTime().getM()));

        event.setDateStart(dateStart);


        Date dateEnd = null;

        dateEnd = v_dateFormat.parse(cal.getEndDate());
        dateEnd.setHours(Integer.parseInt(cal.getEndTime().getH()));
        dateEnd.setMinutes(Integer.parseInt(cal.getEndTime().getM()));


        event.setDateEnd(dateEnd);

        for (String attendees: cal.getGuest()){
            event.addAttendee(attendees);
        }

        Organizer organizer = new Organizer(cal.getUser().getFirst_name() + " " + cal.getUser().getLast_name(), cal.getUser().getEmail());

        event.setOrganizer(organizer);

        ical.addEvent(event);

//using Biweekly
        File file = new File("c:/Temp/agenda.ics");
        Biweekly.write(ical).go(file);

        for (String attendees: cal.getGuest()){

            senderService.sendEmail(cal.getUser().getEmail(), attendees, "SCT Facil - Nouveau Rendez-vous", "Bonjour, \n \n Vous avez un rendez-vous avec " + cal.getUser().getFirst_name() + " " + cal.getUser().getLast_name() + " de ", "c:/Temp/agenda.ics");
        }
    }
    
}
