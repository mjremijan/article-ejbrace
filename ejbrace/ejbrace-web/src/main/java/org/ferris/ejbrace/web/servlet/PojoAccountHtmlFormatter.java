package org.ferris.ejbrace.web.servlet;

import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.model.Address;
import org.ferris.ejbrace.model.Phone;

/**
 * Creates an HTML string for a non-JAXB POJO Account.
 *  
 * @author Tim Taylor tim@taylorhome.org
 */
public class PojoAccountHtmlFormatter extends HtmlFormatter<Account> {

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
        for (String id: account.getPhones().keySet()) {
            Phone phone = account.getPhones().get(id);
            sb.append("<li>").append("Phone ").append(phoneCounter++).append("</li>\n");
            sb.append("<ul style=\"list-style-type: none;\">").append("\n");
            sb.append("<li>ID: ").append(phone.getId()).append("</li>\n");
            sb.append("<li>Type: ").append(phone.getType()).append("</li>\n");
            sb.append("<li>Number: ").append(phone.getNumber()).append("</li>\n");
            sb.append("<li>Description: ").append(phone.getDescription()).append("</li>\n");
            sb.append("</ul>\n");
        }
        sb.append("</ul>\n");
        sb.append("<p>\n");
        return sb.toString();
    }
}
