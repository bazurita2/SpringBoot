package ec.edu.espe.crud.usuariosWsSpringBoot.exception;

import lombok.Getter;

@Getter
public class DataNotFoundException extends Exception {

    private final String tableName;

    public DataNotFoundException(String collectionName, String message) {
        super(message);
        this.tableName = collectionName;
    }
}
