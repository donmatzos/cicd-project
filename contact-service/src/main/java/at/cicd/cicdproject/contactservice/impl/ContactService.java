package at.cicd.cicdproject.contactservice.impl;

import at.cicd.api.base.AbstractContact;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Service
public interface ContactService
{
    @GetMapping("/get-contact")
    AbstractContact getContact(@RequestParam final String contactId);

    @PutMapping("/put-contact")
    boolean putContact(@RequestBody final AbstractContact contact);
}
