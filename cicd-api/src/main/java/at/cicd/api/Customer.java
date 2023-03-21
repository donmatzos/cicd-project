package at.cicd.api;

import at.cicd.api.base.AbstractContact;
import at.cicd.api.enumeration.ContactType;
import lombok.Getter;

public class Customer extends AbstractContact
{
    @Getter
    private final ContactType contactType = ContactType.CUSTOMER;


    @Override
    protected void notifyContact()
    {

    }
}
