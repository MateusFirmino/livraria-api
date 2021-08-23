package br.com.totemti.livraria.configurations;

import br.com.totemti.livraria.dto.ErroDTO;
import br.com.totemti.livraria.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceExceptionHandler {

    private MessageSource messageSource;

    @Autowired
    public ResourceExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErroDTO handle(IllegalArgumentException exception) {
        return new ErroDTO(messageSource
                .getMessage(exception.getMessage(),null, LocaleContextHolder.getLocale()));
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public ErroDTO handle(RegistroNaoEncontradoException exception) {
        return new ErroDTO(messageSource
                .getMessage(exception.getMessage(),null, LocaleContextHolder.getLocale()));
    }
}
