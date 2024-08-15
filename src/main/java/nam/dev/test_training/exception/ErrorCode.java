package nam.dev.test_training.exception;


public enum ErrorCode {
   CATEGORY_EXISTED(1402,"CategoryName exíted"),
    ALL_EXEPCTION(8804,"Lỗi khác"),
   CATENAME_WRONG(2004,"Tên tối thiểu 8 ký tự"),
   ENUM_KEY_WRONG(2008,"Key lỗi"),
    CATEGORY_NOT_EXISTED(8814,"CategoryName not exíted"),

    ;

   private int code;
   private String message;

   ErrorCode(int code, String message) {
       this.code = code;
      this.message = message;
    }

   public int getCode() {
      return code;
  }

   public String getMessage() {
     return message;
   }

}
