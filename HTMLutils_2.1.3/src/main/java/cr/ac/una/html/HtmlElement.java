package cr.ac.una.html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * (c) 2022-2023
 *
 * @author Georges Alfaro S.
 * @version 2.1.3 2023-08-24
 *
 */
public class HtmlElement extends HtmlNode {

    public HtmlElement(String tagName, String id, String text) {
        this.tagName = tagName;
        this.attributes = new HashMap<>();
        this.children = new ArrayList<>();

        setAttribute("id", id);
        if (text != null) {
            appendChild(new TextNode(text));
        }
    }

    public HtmlElement(String tagName) {
        this(tagName, null, null);
    }

    public HtmlElement(String tag, String text) {
        this(tag, null, text);
    }

    @Override
    public String toString(int level) {
        StringBuilder r = new StringBuilder();
        r.append(String.format("%s<%s",
                " ".repeat(level * getIndentFactor()), getTagName()));
        for (String k : attributes.keySet()) {
            r.append(String.format(" %s=\"%s\"", k, attributes.get(k)));
        }

        if (children.isEmpty()) {
            r.append(" />");
        } else {
            r.append(">");
            r.append(getContents(level + 1));
            r.append(String.format("</%s>", getTagName()));
        }

        return r.toString();
    }

    private String getContents(int level) {
        StringBuilder r = new StringBuilder();

        // 2023-08-25
        // El elemento contiene solamente un nodo de texto.
        //
        if ((children.size() == 1) && children.get(0).isTextNode()) {
            return children.get(0).toString();

        } else if (children.size() >= 1) {
            for (HtmlNode n : children) {
                r.append(String.format("%n%s", n.toString(level)));
            }
            r.append(String.format("%n%s", " ".repeat((level - 1) * getIndentFactor())));
        } else {

        }
        return r.toString();
    }

    public String getTagName() {
        return tagName;
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }

    public final HtmlElement setAttribute(String key, String value) {
        if (value != null) {
            attributes.put(key, value);
        }
        return this;
    }

    public HashMap<String, String> getAttributeMap() {
        return attributes;
    }

    public HtmlElement setAttributeMap(HashMap<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }

    public final HtmlNode appendChild(HtmlNode newNode) {
        children.add(newNode);
        return newNode;
    }

    public final HtmlNode setTextContent(String text) {
        return appendChild(new TextNode(text));
    }

    public List<HtmlNode> getChildren() {
        return children;
    }

    public static void main(String[] args) {
        HtmlElement e1 = new HtmlElement("p");
        System.out.println(e1);
        HtmlElement e2 = new HtmlElement("p", "first paragraph");
        System.out.println(e2);
        HtmlElement e3 = new HtmlElement("p");
        e3.setAttribute("class", "c1");
        e3.appendChild(new TextNode("second paragraph"));
        System.out.println(e3);
    }

    private final String tagName;
    private HashMap<String, String> attributes;
    private List<HtmlNode> children;
}
