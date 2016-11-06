package techkids.vn.dailyquote.models;

/**
 * Created by apple on 10/13/16.
 */

public class AlertDialogEvent {
    private String title;
    private String message;
    private boolean cancelable;
    private String positiveButtonTitle;

    public AlertDialogEvent(String title, String message, boolean cancelable, String positiveButtonTitle) {
        this.title = title;
        this.message = message;
        this.cancelable = cancelable;
        this.positiveButtonTitle = positiveButtonTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public String getPositiveButtonTitle() {
        return positiveButtonTitle;
    }
}

