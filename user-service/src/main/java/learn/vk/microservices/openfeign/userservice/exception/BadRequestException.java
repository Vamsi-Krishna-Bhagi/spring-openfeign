package learn.vk.microservices.openfeign.userservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class BadRequestException extends RuntimeException{
    final String message;

    public BadRequestException(String message) {
        this.message = message;
    }
}
