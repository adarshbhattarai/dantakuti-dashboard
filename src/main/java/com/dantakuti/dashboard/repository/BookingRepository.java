package com.dantakuti.dashboard.repository;

import com.dantakuti.dashboard.document.BookingDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author adarshbhattarai on 2019-09-09
 * @project dashboard
 */
public interface BookingRepository extends MongoRepository<BookingDetail, Integer> {
}
