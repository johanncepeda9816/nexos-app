package com.nexos.app.exceptions;

public class AppException extends Exception{

    public static final String USER_NOT_FOUND = "El Usuario no existe";
    public static final String ITEM_ALREADY_EXITS = "El item con ese nombre ya se encuentra registrado";
    public static final String ITEM_DO_NOT_EXISTS = "El item con ese nombre no se encuentra registrado";
    public static final String ONLY_CREATOR_CAN_DELETE_ITEM = "Solo el usuario creador puede eliminar el item";

    public AppException(String msg){
        super(msg);
    }
}
