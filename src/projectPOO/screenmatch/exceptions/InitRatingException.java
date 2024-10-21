package projectPOO.screenmatch.exceptions;

public class InitRatingException extends RuntimeException {
    private String message;

    public InitRatingException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.getMessage();
    }
}
