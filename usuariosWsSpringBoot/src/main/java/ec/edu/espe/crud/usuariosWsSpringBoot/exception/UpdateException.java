package ec.edu.espe.crud.usuariosWsSpringBoot.exception;

import lombok.Getter;

@Getter
public class UpdateException extends Exception {
    private static final long serialVersionUID = 1L;
    private final String tableName;

    public UpdateException(String collectionName, String message) {
        super(message);
        this.tableName = collectionName;
    }

    public UpdateException(String collectionName, String message, Throwable cause) {
        super(message, cause);
        this.tableName = collectionName;
    }
}
