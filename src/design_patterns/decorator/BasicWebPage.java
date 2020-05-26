package design_patterns.decorator;

public class BasicWebPage implements WebPage {

    public String html;
    public String styleSheet;
    public String script;

    public BasicWebPage(String html, String styleSheet, String script) {
        this.html = html;
        this.styleSheet = styleSheet;
        this.script = script;
    }

    @Override
    public void display() {
        System.out.println("Rendring "+html+"  "+ styleSheet+" "+ script);
    }
}
