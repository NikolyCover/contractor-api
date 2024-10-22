package unioeste.br.contractor_api.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.chatbot.service.ChatbotService;

import java.io.IOException;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @PostMapping
    public String sendMessageToChatbot(@RequestBody String message) throws IOException, InterruptedException {
        return chatbotService.sendMessage(message);
    }
}
