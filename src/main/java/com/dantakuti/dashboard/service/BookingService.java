package com.dantakuti.dashboard.service;

import com.dantakuti.dashboard.document.BookingDetail;
import com.dantakuti.dashboard.entity.ResponseMessage;

/**
 * @author adarshbhattarai on 2019-09-09
 * @project dashboard
 */
public interface BookingService {

    public ResponseMessage book(BookingDetail bookingDetail) throws Exception;

    ResponseMessage validateBookingDetail(BookingDetail bookingDetail) throws Exception;
}
