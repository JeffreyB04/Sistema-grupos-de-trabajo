package cr.ac.una.html;

/**
 *
 * (c) 2022-2023
 *
 * @author Georges Alfaro S.
 * @version 1.1.1 2023-08-24
 *
 */
public class TextNode extends HtmlNode {

    public TextNode(String text) {
        this.text = text;
    }

    @Override
    public boolean isTextNode() { // 2023-08-25
        return true;
    }

    @Override
    public String toString(int level) {
        // return String.format("%s%s", " ".repeat(level * getIndentFactor()), getText());
        return getText();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;
}
