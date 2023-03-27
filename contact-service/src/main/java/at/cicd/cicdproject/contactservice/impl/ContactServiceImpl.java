package at.cicd.cicdproject.contactservice.impl;

import at.cicd.api.Customer;
import at.cicd.api.base.AbstractContact;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("contactService")
@RequestMapping("/contact")
public class ContactServiceImpl implements ContactService
{
    @Override
    public AbstractContact getContact(@RequestParam final String contactId)
    {
        return new Customer();
    }

    @Override
    public boolean putContact(@RequestBody final AbstractContact contact)
    {
        return false;
    }
}
