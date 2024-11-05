package unioeste.br.contractor_api.chatbot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.contract.service.ContractService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;


@Service
public class ChatbotService {

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    @Autowired
    private ContractService contractService;

    private final String initialInstructions = "Você é o assistente virtual do sistema Contractor - um sistema gerenciador de contratos de uma empresa que realiza diversas ações e rotias através de contratos. Por exemplo, construindo alguma obra, adquirindo algum software, contratnado serviços e etc. Dessa forma, só responda perguntas relacionadas a isso e em português do Brasil. Não assuma nada. Quando te perguntarem algo que você não pode responder peça desculpas e diga o porquê. As coisas que você pode fazer são mostrar dados de um contrato a partir do código dele. Agora o usuário irá falar com você. ";

    public String sendMessage(String message) throws IOException, InterruptedException {
        String responseBody = sendRequest(message);
        return processResponse(responseBody);
    }

    private String sendRequest(String message) throws IOException, InterruptedException {
        Map<String, Object> requestBody = createRequestBody(message);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInput = objectMapper.writeValueAsString(requestBody);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(geminiApiUrl + geminiApiKey))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonInput))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private Map<String, Object> createRequestBody(String message) {
        return Map.of(
                "contents", List.of(
                        Map.of(
                                "parts", List.of(
                                        Map.of("text", initialInstructions),
                                        Map.of("text", message)
                                )
                        )
                ),
                "tools", Map.of(
                        "function_declarations", List.of(
                                Map.of(
                                        "name", "getStringContractById",
                                        "description", "Retorna todas as informações de um contrato baseado no identificador (id/número/código) fornecido. Sempre que o usuário falar de um contrato e passar um número, essa função deve ser ativada",
                                        "parameters", Map.of(
                                                "type", "object",
                                                "properties", Map.of(
                                                        "contractId", Map.of(
                                                                "type", "integer",
                                                                "description", "O identificador (id/número/código) do contrato para o qual você deseja obter detalhes/falar sobre/saber informações"
                                                        )
                                                ),
                                                "required", List.of("contractId")
                                        )
                                ),
                                Map.of(
                                        "name", "getContracts",
                                        "description", "Retorna todos os contratos do sistema, mostrando um resumo das infomações de cada um."
                                )
                        )
                )
        );
    }

    private String processResponse(String responseBody) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody);

        if (rootNode.has("candidates")) {
            return handleCandidates(rootNode.path("candidates"));
        }

        return responseBody;
    }

    private String handleCandidates(JsonNode candidatesNode) {
        if (candidatesNode.isArray() && candidatesNode.size() > 0) {
            JsonNode contentNode = candidatesNode.get(0).path("content");
            if (contentNode.has("parts") && contentNode.path("parts").isArray()) {
                return handleParts(contentNode.path("parts"));
            }
        }
        return null;
    }

    private String handleParts(JsonNode partsNode) {
        if (partsNode.size() > 0) {
            JsonNode firstPart = partsNode.get(0);
            if (firstPart.has("functionCall")) {
                JsonNode functionCallNode = firstPart.path("functionCall");
                return callFunction(functionCallNode);
            } else if (firstPart.has("text")) {
                return firstPart.path("text").asText();
            }
        }
        return null;
    }

    private String callFunction(JsonNode functionCallNode) {
        String functionName = functionCallNode.path("name").asText();
        JsonNode argsNode = functionCallNode.path("args");

        if ("getStringContractById".equals(functionName)) {
            int contractId = argsNode.path("contractId").asInt();
            return contractService.getContractByIdAsString((long) contractId);
        }

        if("getContracts".equals(functionName)) {
            return contractService.getAllContractsAsString();
        }

        return null;
    }
}
