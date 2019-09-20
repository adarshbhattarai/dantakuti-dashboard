package com.dantakuti.dashboard.repository;

import com.dantakuti.dashboard.document.ApptBookedDateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

/**
 * @author adarshbhattarai on 2019-09-18
 * @project dashboard
 */
public interface ApptBookedDateTimeRepository extends MongoRepository<ApptBookedDateTime, Integer> {

    ApptBookedDateTime findByDate(Date date);

}
