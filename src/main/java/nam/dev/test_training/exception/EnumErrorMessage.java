package nam.dev.test_training.exception;

//import com.longnh.exceptions.BaseErrorMessage;

public enum EnumErrorMessage{
    ENUM_ERROR_MESSAGE(8814,"EnumErrorMessage")
    ;
    private int code;

    private String message;

    EnumErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

//    @Override
//    public String val() {
//        return null;
//    }
}
