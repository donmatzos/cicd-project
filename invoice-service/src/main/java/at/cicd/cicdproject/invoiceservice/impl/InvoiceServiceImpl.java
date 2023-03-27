package at.cicd.cicdproject.invoiceservice.impl;

import at.cicd.api.Invoice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("invoiceService")
@RequestMapping("/invoice")
public class InvoiceServiceImpl implements InvoiceService
{
    @Override
    public Invoice getInvoice(@RequestParam final String invoiceId)
    {
        return null;
    }
}
