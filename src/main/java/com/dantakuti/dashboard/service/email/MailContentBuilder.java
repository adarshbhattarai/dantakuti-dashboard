package com.dantakuti.dashboard.service.email;

import com.dantakuti.dashboard.document.BookingDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author adarshbhattarai on 2019-09-17
 * @project dashboard
 */
@Service
public class MailContentBuilder {

    @Autowired
    private TemplateEngine templateEngine;

    public String build(BookingDetail bookingDetail, String template){
        Context context = new Context();
        context.setVariable("bookingDetail", bookingDetail);
        return templateEngine.process(template, context);
    }
}
