package com.dantakuti.dashboard.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @author adarshbhattarai on 2019-09-18
 * @project dashboard
 */
@Document
public class ApptBookedDateTime {

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    public Date date;
    public List<String> times;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }
}
