package ed.lab;


import java.util.HashMap;
import java.util.Map;

public class E02Logger {

    // Map para almacenar el último timestamp permitido para cada mensaje
    private final Map<String, Integer> messageTimestamps;

    public E02Logger() {
        this.messageTimestamps = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        // Si el mensaje no se ha registrado antes o ya pasaron 10 segundos desde su último registro
        if (!messageTimestamps.containsKey(message) || timestamp >= messageTimestamps.get(message)) {
            messageTimestamps.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}
