package unioeste.br.contractor_api.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.chatbot.domain.ChatbotResponseDTO;
import unioeste.br.contractor_api.chatbot.service.ChatbotService;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @PostMapping
    public ChatbotResponseDTO sendMessageToChatbot(@RequestBody String message) throws IOException, InterruptedException {
        ChatbotResponseDTO chatbotResponseDTO = new ChatbotResponseDTO();
        chatbotResponseDTO.setMessage(chatbotService.sendMessage(message));
        return chatbotResponseDTO;
    }
}
