package techkids.vn.lab4structuredemo.entities;

/**
 * Created by apple on 10/9/16.
 */

public class ActionBarEvent {
    private int toggleBarResId;
    private boolean sendVisible;

    public ActionBarEvent(int toggleBarResId, boolean sendVisible) {
        this.toggleBarResId = toggleBarResId;
        this.sendVisible = sendVisible;
    }

    public int getToggleBarResId() {
        return toggleBarResId;
    }

    public void setToggleBarResId(int toggleBarResId) {
        this.toggleBarResId = toggleBarResId;
    }

    public boolean isSendVisible() {
        return sendVisible;
    }

    public void setSendVisible(boolean sendVisible) {
        this.sendVisible = sendVisible;
    }
}
