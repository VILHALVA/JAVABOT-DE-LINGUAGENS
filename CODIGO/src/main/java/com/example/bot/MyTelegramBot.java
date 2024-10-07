package com.example.bot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyTelegramBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return Config.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return Config.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (messageText.toLowerCase()) {
                case "/start":
                    sendTextMessage(chatId, "😀Olá! Bem-vindo ao Bot de INTRODUÇÃO A LINGUAGENS DE PROGRAMAÇÃO. \n😎Tente usar comandos como:\n/java - Para conceitos sobre o Java\n /python - Para conceitos sobre o Python\n/javascript - Para conceitos sobre o Javascript\n/csharp - Para conceitos sobre o C#\n/php - Para conceitos sobre o PHP\n/ruby - Para conceitos sobre o Ruby\n/go - Para conceitos sobre o Golang\n /kotlin - Para conceitos sobre o Kotlin\n");
                    break;
                case "/java":
                    sendTextMessage(chatId, "Java é uma linguagem de programação orientada a objetos, muito usada para desenvolver aplicações corporativas.");
                    break;
                case "/python":
                    sendTextMessage(chatId, "Python é uma linguagem de programação poderosa, conhecida por sua sintaxe simples e vasta gama de bibliotecas.");
                    break;
                case "/javascript":
                    sendTextMessage(chatId, "JavaScript é amplamente utilizado para desenvolvimento web, permitindo criar páginas dinâmicas e interativas.");
                    break;
                case "/csharp":
                    sendTextMessage(chatId, "C# é uma linguagem de programação moderna e orientada a objetos, muito utilizada no desenvolvimento de aplicações .NET.");
                    break;
                case "/php":
                    sendTextMessage(chatId, "PHP é uma linguagem de script usada principalmente para desenvolvimento web, famosa por sua integração com o HTML.");
                    break;
                case "/ruby":
                    sendTextMessage(chatId, "Ruby é uma linguagem de programação dinâmica e orientada a objetos, usada principalmente para desenvolvimento web com o framework Ruby on Rails.");
                    break;
                    case "/go":
                    sendTextMessage(chatId, "Go é uma linguagem de programação criada pelo Google, conhecida por sua simplicidade e eficiência.");
                    break;
                case "/kotlin":
                    sendTextMessage(chatId, "Kotlin é uma linguagem moderna, interoperável com Java, popular no desenvolvimento de aplicativos Android.");
                    break;                
                default:
                    sendTextMessage(chatId, "🤨Desculpe, não reconheço o comando.\n😎Tente usar comandos como:\n/java - Para conceitos sobre o Java\n /python - Para conceitos sobre o Python\n/javascript - Para conceitos sobre o Javascript\n/csharp - Para conceitos sobre o C#\n/php - Para conceitos sobre o PHP\n/ruby - Para conceitos sobre o Ruby\n/go - Para conceitos sobre o Golang\n /kotlin - Para conceitos sobre o Kotlin\n");
                    break;
            }
        }
    }

    private void sendTextMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
