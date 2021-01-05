import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyFunTgBot extends TelegramLongPollingBot {

    long chat_id;

    public void onUpdateReceived(Update update) {

        //this way good work with input()
        update.getUpdateId();

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        chat_id = update.getMessage().getChatId();
        sendMessage.setText(input(update.getMessage().getText()));

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        /*
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(message_text);
            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        OR

        We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage()                    Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        */
    }

    public String getBotUsername() {
        return "WorkIdeasFromMarchello_bot";
    }

    public String getBotToken() {
        return "1492966661:AAFfg0xal8yv0CUukezv4qgzc0nSMT_GJdo";
    }

    private String input(String msg) {
        if (msg.contains("Привет") || msg.contains("Прувэт")
                || msg.contains("привет") || msg.contains("прувэт")) {
            return "Воділа прівєт";
        } else if (msg.contains("Хай") || msg.contains("хай")) {
            return "Это какая-то шутка? Спик инглишь";
        } else if (msg.contains("Hi") || msg.contains("Hello")
                || msg.contains("hi") || msg.contains("hello")) {
            return "О! Человек знающий английский. Not bad...";
        } else if (msg.contains("Йо") || msg.contains("йо")) {
            return "Йо, человек!";
        }
//        else if (msg.contains("Йоу") || msg.contains("йоу")) {
//            return "Йоу, человек!";
//        }
        else if (msg.contains("Шалом") || msg.contains("шалом")) {
            return "Шалом, человек!";
        }  else if (msg.contains("Шолом") || msg.contains("шолом")) {
            return "Шолом, человек!";
        } else if (msg.contains("Как оно") || msg.contains("Как оно?")
                || msg.contains("как оно") || msg.contains("как оно?")) {
            return "Да норм так-то. У тебя как, человек?";
        }
        return msg;
    }
}