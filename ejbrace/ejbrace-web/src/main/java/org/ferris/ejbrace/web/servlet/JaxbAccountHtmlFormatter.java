package org.ferris.ejbrace.web.servlet;

import org.ferris.ejbrace.servlet.Account;
import org.ferris.ejbrace.servlet.Account.Phones.Entry;
import org.ferris.ejbrace.servlet.Address;
import org.ferris.ejbrace.servlet.Phone;

/**
 * Creates an HTML string for a JAXB Account.
 *  
 * @author Tim Taylor tim@taylorhome.org
 */
public class JaxbAccountHtmlFormatter extends HtmlFormatter<Account> {

    @Override
    public String toHtml(Account account) {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>\n");
        sb.append("Account ID: ").append(account.getId()).append('\n');
        sb.append("Addresses").append('\n');
        int addressCounter = 0;
        sb.append("<ul style=\"list-style-type: none;\">").append("\n");
        for (Address address: account.getAddresses()) {
            sb.append("<li>").append("Address ").append(addressCounter++).append("</li>\n");
            sb.append("<ul style=\"list-style-type: none;\">").append("\n");
            sb.append("<li>Address1: ").append(address.getAddress1()).append("</li>\n");
            sb.append("<li>Address2: ").append(address.getAddress2()).append("</li>\n");
            sb.append("<li>City: ").append(address.getCity()).append("</li>\n");
            sb.append("<li>State: ").append(address.getState()).append("</li>\n");
            sb.append("<li>ZipCode: ").append(address.getZipCode()).append("</li>\n");
            sb.append("</ul>\n");
        }
        sb.append("</ul>\n");
        sb.append("<ul style=\"list-style-type: none;\">").append("\n");
        int phoneCounter = 0;
        for (Entry entry: account.getPhones().getEntry()) {
            sb.append("<li>").append("Phone ").append(phoneCounter++).append("</li>\n");
            sb.append("<ul style=\"list-style-type: none;\">").append("\n");
            sb.append("<li>ID: ").append(entry.getValue().getId()).append("</li>\n");
            sb.append("<li>Type: ").append(entry.getValue().getType()).append("</li>\n");
            sb.append("<li>Number: ").append(entry.getValue().getNumber()).append("</li>\n");
            sb.append("<li>Description: ").append(entry.getValue().getDescription()).append("</li>\n");
            sb.append("</ul>\n");
        }
        sb.append("</ul>\n");
        sb.append("<p>\n");
        return sb.toString();
    }
}
