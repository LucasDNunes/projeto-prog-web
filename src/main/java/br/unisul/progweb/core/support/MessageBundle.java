package br.unisul.progweb.core.support;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class MessageBundle {
    public static final String OBJETO_REQUERIDO = "objeto.requerido";

    private MessageBundle() {
    }

    public static String getMessage(String key, Object... argumentos) {

        try {
            MessageSource bean = ApplicationContextProvider.getBean(MessageSource.class);
            return bean.getMessage(key, argumentos, Locale.getDefault());
        } catch (Exception e) {
            return "Chave não reconhecida: " + key;
        }
    }

}
