package cr.ac.una.html;

/**
 *
 * (c) 2022
 *
 * @author Georges Alfaro S.
 * @version 1.0.0 2022-07-29
 *
 */
public class HtmlTableRow extends HtmlElement {

    public HtmlTableRow() {
        super("tr");
    }

    public HtmlElement appendCell(String value) {
        HtmlElement td = new HtmlElement("td", value);
        appendChild(td);
        return td;
    }

    public HtmlElement appendHeaderCell(String value) {
        HtmlElement th = new HtmlElement("th", value);
        appendChild(th);
        return th;
    }

    public static void main(String[] args) {
        HtmlTableRow r1 = new HtmlTableRow();
        r1.appendHeaderCell("A");
        r1.appendHeaderCell("B");
        r1.appendHeaderCell("C");
        System.out.println(r1);

        HtmlTableRow r2 = new HtmlTableRow();
        r2.appendHeaderCell("23.56");
        r2.appendHeaderCell("texto");
        r2.appendHeaderCell("12345");
        System.out.println(r2);
    }

}
