package org.ferris.ejbrace.web.servlet;

/**
 * Creates HTML strings for objects of type <code>T</code>
 * 
 * @author Tim Taylor tim@taylorhome.org
 *
 * @param <T> type to create the HTML string for
 */
public abstract class HtmlFormatter<T> {
    public abstract String toHtml(T object);
}
