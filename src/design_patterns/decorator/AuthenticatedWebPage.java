package design_patterns.decorator;

public class AuthenticatedWebPage extends WebPageDecorator {
    public AuthenticatedWebPage(WebPage decoratedPage) {
        super(decoratedPage);
    }
    public void authenticateUser() {
        System.out.println("Authenticating user");
    }
    public void display() {
        System.out.println("Inside Authenticated display");
        super.display();
        this.authenticateUser();
    }
}
