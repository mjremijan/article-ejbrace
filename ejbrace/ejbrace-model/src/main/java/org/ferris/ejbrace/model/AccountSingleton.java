package org.ferris.ejbrace.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
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
        private static List<Account> instance;
        
        static {
            Random random = new Random();
            
            instance = new LinkedList<>();
            
            
            for (int i=0, imax=random.nextInt(100) + 1; i<imax; i++) 
            {
                // New Account
                Account account
                    = new Account(UUID.randomUUID().toString());
                
                // Addresses
                for (int j=0, jmax=random.nextInt(4) + 1; j<jmax; j++) 
                {
                    Address address = new Address(UUID.randomUUID().toString());
                    address.setAddress1(UUID.randomUUID().toString());
                    address.setAddress2(UUID.randomUUID().toString());
                    address.setCity(UUID.randomUUID().toString());
                    address.setState(UUID.randomUUID().toString());
                    address.setState(UUID.randomUUID().toString());
                    account.addAddress(address);
                }
                
                // Phone numbers
                for (int k=0, kmax=random.nextInt(5) + 1; k<kmax; k++)
                {
                    Phone phone = new Phone(UUID.randomUUID().toString(), PhoneType.values()[random.nextInt(3)], UUID.randomUUID().toString());
                    phone.setDescription(UUID.randomUUID().toString());
                    account.addPhone(phone);
                }

                // Add to list
                instance.add(account);
            }
        }

    }

    public static List<Account> getAccounts() {
        return AccountHolder.instance;
    }
}
