package org.ferris.ejbrace.model;

import java.util.UUID;
import static org.ferris.ejbrace.model.PhoneType.Home;
import static org.ferris.ejbrace.model.PhoneType.Mobile;
import static org.ferris.ejbrace.model.PhoneType.Work;
/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class AccountSingleton {

    public static class AccountHolder {
        private static Account instance;
        {
            instance = new Account(UUID.randomUUID().toString());
            {
                final Address address = new Address(UUID.randomUUID().toString());
                address.setAddress1("123 Main Street");
                address.setAddress2("#100");
                address.setCity("City");
                address.setState("ST");
                address.setState("12345-4567");
                instance.addAddress(address);
            }
            {
                final Address address = new Address(UUID.randomUUID().toString());
                address.setAddress1("456 Summer St.");
                address.setCity("Springfield");
                address.setState("AX");
                address.setState("36325-9865");
                instance.addAddress(address);
            }
            {
                final Address address = new Address(UUID.randomUUID().toString());
                address.setAddress1("456 Winter Blvd.");
                address.setAddress2("");
                address.setCity("Greenville");
                address.setState("II");
                address.setState("66547-7538");
                instance.addAddress(address);
            }
            {
                final Phone phone = new Phone(UUID.randomUUID().toString(), Work, "145-696-8855");
                phone.setDescription("iPhone8 (work)");
                instance.addPhone(phone);
            }
            {
                final Phone phone = new Phone(UUID.randomUUID().toString(), Mobile, "555-6914");
                phone.setDescription("My Android");
                instance.addPhone(phone);
            }
            {
                final Phone phone = new Phone(UUID.randomUUID().toString(), Home, "222-335-6174");
                phone.setDescription("Lan line?");
                instance.addPhone(phone);
            }
        }

    }

    public static Account getAccount() {
        return AccountHolder.instance;
    }
}
