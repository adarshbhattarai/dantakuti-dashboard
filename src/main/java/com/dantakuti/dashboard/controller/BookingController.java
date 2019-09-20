package com.dantakuti.dashboard.controller;

import com.dantakuti.dashboard.document.BookingDetail;
import com.dantakuti.dashboard.entity.ApiResponse;
import com.dantakuti.dashboard.entity.ResponseMessage;
import com.dantakuti.dashboard.service.BookingService;
import com.dantakuti.dashboard.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adarshbhattarai on 2019-09-09
 * @project dashboard
 */
@RestController
@RequestMapping("/public")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    NotificationService notificationService;

    @PostMapping(value = "/appointment/booking", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> bookUserAppointment(@RequestBody BookingDetail bookingDetail) throws Exception {

        ResponseMessage message = bookingService.validateBookingDetail(bookingDetail);
        if(message.hasError){
            return new ResponseEntity<ApiResponse>(message.errors, HttpStatus.BAD_REQUEST);
        }
        try{
        bookingService.book(bookingDetail);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<ApiResponse>(message.response, HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<ApiResponse>(message.response, HttpStatus.OK);
    }
}
