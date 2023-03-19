//package com.lmx.project.until;
//
//import com.theokanning.openai.OpenAiService;
//import com.theokanning.openai.completion.CompletionRequest;
//import com.theokanning.openai.completion.CompletionResult;
//
//public class ChatGptUntil {
//    public static void main(String[] args) {
//        OpenAiService openAiService = new OpenAiService("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");
//        CompletionRequest completionRequest = CompletionRequest.builder()
//                .prompt("中印边境自卫反击战谁获胜了？").model(openAiService.listModels().get(1).id).echo(true).build();
//        CompletionResult completionResult = openAiService.createCompletion(completionRequest);
//        completionResult.getChoices().forEach(System.out::println);
//    }
//
//}
