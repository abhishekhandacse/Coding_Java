package design_patterns.decorator;
// References Design Pattern Course from coursera by University of Alberta
public class Program {
    public static void main(String args[]) {
        WebPage myPage = new BasicWebPage("HTML5 fetched","CSS5 fetched","JS5 fetched");
        myPage = new AuthorizedWebPage(myPage);
        myPage = new AuthenticatedWebPage(myPage);
        myPage.display();
    }
}
