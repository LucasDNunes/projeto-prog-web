package br.unisul.progweb.core.exception;

import br.unisul.progweb.core.support.MessageBundle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CampoObrigatorioException extends IllegalArgumentException {
    public CampoObrigatorioException(String campo) {
        super(MessageBundle.getMessage("objeto.requerido", campo));
    }
}
