package homeguard;

public class TextView implements HomeGuardView {
    public void showMessage(String message) {
        System.out.println(message);
    }
}
