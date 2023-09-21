package cr.ac.una.html;

/**
 *
 * (c) 2022-2023
 *
 * @author Georges Alfaro S.
 * @version 1.1.0 2023-04-07
 *
 */
public abstract class HtmlNode {

    public boolean isTextNode() { // 2023-08-25
        return false;
    }

    protected int getIndentFactor() {
        return indentFactor;
    }

    public static void setIndentFactor(int newIndent) {
        indentFactor = newIndent;
    }

    public static void setLvlSeparator(String aLvlSeparator) {
        lvlSeparator = aLvlSeparator;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public abstract String toString(int level);

    private static int indentFactor = 4;
    private static String lvlSeparator = "\t";

}
