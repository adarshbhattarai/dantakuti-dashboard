package com.dantakuti.dashboard.service.impl;

import com.amazonaws.util.StringUtils;
import com.dantakuti.dashboard.document.BookingDetail;
import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.entity.ApiResponse;
import com.dantakuti.dashboard.entity.ResponseMessage;
import com.dantakuti.dashboard.helper.DantakutiHelper;
import com.dantakuti.dashboard.repository.BookingRepository;
import com.dantakuti.dashboard.service.ApptBookedDateTimeService;
import com.dantakuti.dashboard.service.BookingService;
import com.dantakuti.dashboard.service.NotificationService;
import com.dantakuti.dashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author adarshbhattarai on 2019-09-09
 * @project dashboard
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserService userService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    ApptBookedDateTimeService apptBookedDateTimeService;

    @Override
    public ResponseMessage book(BookingDetail bookingDetail) throws Exception{

        ResponseMessage responseMessage= new ResponseMessage();
        DantaUser user = userService.findByEmail(bookingDetail.getEmail());

        if(user==null){
            user = new DantaUser();
            user.setEmail(bookingDetail.getEmail());
            user.setName(bookingDetail.getFirstName()+" "+bookingDetail.getLastName());
            user.setPassword(null);
        }
        List<BookingDetail> bookings = user.getBookingDetails();
        if(null == bookings || bookings.isEmpty()){
            bookings = new ArrayList<>();
            user.setBookingDetails(bookings);
        }
        bookings.add(bookingDetail);

        if(bookingDetail.isEmailSubscription()){
            notificationService.notifyUserByEmail(user);
        }
        notificationService.notifyAdmin(bookingDetail);
        apptBookedDateTimeService.register(bookingDetail.getAppointment().getAppointmentDate(),
                bookingDetail.getAppointment().getAppointmentTime());
        userService.save(user);
        responseMessage.hasError=false;
        responseMessage.response = new ApiResponse();
        responseMessage.response.setMessages(Arrays.asList("Booking Successful"));
        return  responseMessage;
    }

    @Override
    public ResponseMessage validateBookingDetail(BookingDetail bookingDetail) throws Exception {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.hasError = false;

        if(bookingDetail.isEmailSubscription() && StringUtils.isNullOrEmpty(bookingDetail.getEmail())){
            responseMessage.hasError = true;
            responseMessage.response = new ApiResponse();
            responseMessage.response.getMessages().add("Email is not provided.");
        }

        if(bookingDetail.getAppointment() == null || bookingDetail.getAppointment().getAppointmentTime() == null){
            responseMessage.hasError = true;
            responseMessage.response = new ApiResponse();
            responseMessage.response.getMessages().add("Invalid Parameters passed");
            return responseMessage;
        }
        //Convert the generic 24 hour time to 12 hour time and save in DB.
        String bookingTime = DantakutiHelper.formatAMPMTime(bookingDetail);
        bookingDetail.getAppointment().setAppointmentTime(bookingTime);

        List<String> availableTime = apptBookedDateTimeService.getAvailableTime(bookingDetail.getAppointment().getAppointmentDate());

        if(!availableTime.contains(bookingDetail.getAppointment().getAppointmentTime())){
            responseMessage.hasError = true;
            if(responseMessage.response == null) responseMessage.response = new ApiResponse();
            responseMessage.response.getMessages().add("Selected Date is already booked.");
        }
        return responseMessage;
    }
}
