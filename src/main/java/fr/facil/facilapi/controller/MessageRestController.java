package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Message;
import fr.facil.facilapi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MessageRestController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(value = "/")
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @PostMapping(value = "/create")
    public Message addMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    @DeleteMapping(value = "/delete/{userId}")
    public void deleteMessage(@PathVariable String MessageId) {
        messageRepository.deleteById(MessageId);
    }

}
