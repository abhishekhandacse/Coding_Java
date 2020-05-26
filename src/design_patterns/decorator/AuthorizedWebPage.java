package design_patterns.decorator;

public class AuthorizedWebPage extends WebPageDecorator{
    public AuthorizedWebPage(WebPage decoratedPage)
    {
        super(decoratedPage);
    }
    public void authorizedUser() {
        System.out.println("Authorizing user");
    }
    public void display() {
        System.out.println("Inside authorized display");
        super.display();
        this.authorizedUser();
    }
}
