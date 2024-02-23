package fr.oga.kataproject.infrastructure.enums;

public enum ErrorCodes {
    ACCOUNT_NOT_FOUND(1000),

    INSUFFICIENT_ACCOUNT_BALANCE(1001),
    ACCOUNT_BALANCE_SHOULD_NOT_BE_NEGATIVE(1002);

    private int id;

    ErrorCodes(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}
