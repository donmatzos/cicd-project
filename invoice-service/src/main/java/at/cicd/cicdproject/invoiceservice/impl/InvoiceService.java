package at.cicd.cicdproject.invoiceservice.impl;

import at.cicd.cicdproject.impl.model.Invoice;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Service
public interface InvoiceService
{
    @GetMapping("/get-invoice")
    Invoice getInvoice(@RequestParam final String invoiceId);
}
