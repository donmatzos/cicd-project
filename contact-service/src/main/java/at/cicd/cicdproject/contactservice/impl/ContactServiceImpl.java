package at.cicd.cicdproject.contactservice.impl;

import at.cicd.cicdproject.impl.model.base.AbstractContact;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component("contactService")
@RequestMapping("/contact")
public class ContactServiceImpl implements ContactService
{
    @Override
    public boolean putContact(@RequestBody final AbstractContact contact)
    {
        return false;
    }
}
