package at.cicd.api;

import at.cicd.api.base.AbstractContact;
import at.cicd.api.enumeration.ContactType;
import lombok.Getter;

public class Supplier extends AbstractContact
{
    @Getter
    private final ContactType contactType = ContactType.SUPPLIER;


    @Override
    protected void notifyContact()
    {

    }
}
