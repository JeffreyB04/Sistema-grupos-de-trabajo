package cr.ac.una.html;

/**
 *
 * (c) 2022-2023
 *
 * @author Georges Alfaro S.
 * @version 1.0.1 2023-09-15
 *
 */
public class HtmlTable extends HtmlElement {

    public HtmlTable(String caption) {
        super("table");

        if ((caption != null) && (!caption.isBlank())) {
            this.tableCaption = new HtmlElement("caption", caption);
            appendChild(this.tableCaption);
        } else {
            this.tableCaption = null;
        }

        this.tableHeader = new HtmlElement("thead");
        this.tableBody = new HtmlElement("tbody");
        this.tableFooter = new HtmlElement("tfoot");

        appendChild(this.tableHeader);
        appendChild(this.tableBody);
        appendChild(this.tableFooter);
    }

    public HtmlTable() {
        this(null);
    }

    public HtmlElement getTableCaption() {
        return tableCaption;
    }

    public HtmlElement getTableHeader() {
        return tableHeader;
    }

    public HtmlElement getTableBody() {
        return tableBody;
    }

    public HtmlElement getTableFooter() {
        return tableFooter;
    }

    public HtmlTableRow appendHeaderRow() {
        return (HtmlTableRow) getTableHeader().appendChild(new HtmlTableRow());
    }

    public HtmlTableRow appendRow() {
        return (HtmlTableRow) getTableBody().appendChild(new HtmlTableRow());
    }

    public HtmlTableRow appendFooterRow() {
        return (HtmlTableRow) getTableFooter().appendChild(new HtmlTableRow());
    }

    public static void main(String[] args) {
        HtmlTable t = new HtmlTable("Prueba");
        t.setAttribute("class", "t1");

        HtmlTableRow r = t.appendHeaderRow();
        r.appendHeaderCell("A");
        r.appendHeaderCell("B");
        r.appendHeaderCell("C");
        r.appendHeaderCell("D");

        for (int i = 0; i < 3; i++) {
            r = t.appendRow();
            for (int j = 0; j < 4; j++) {
                r.appendCell(String.format("%d", (i + 1) * 100 + (j + 1)));
            }
        }

        System.out.println(t);
        System.out.println();
    }

    private final HtmlElement tableCaption;
    private final HtmlElement tableHeader;
    private final HtmlElement tableBody;
    private final HtmlElement tableFooter;
}
