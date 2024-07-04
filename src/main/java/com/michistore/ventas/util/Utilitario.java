package com.michistore.ventas.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilitario {

    public static LocalDateTime stringDateTime(String fecha) {
        return LocalDateTime.parse(fecha,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
