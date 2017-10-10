package travel.domain;

import org.springframework.data.annotation.Id;

import javax.validation.Valid;

/**
 * Created by Chenjie Xu on 2017/5/15.
 */
public class Information2 {
    @Valid
    @Id
    private String tripId;

    public Information2(){
        //Default Constructor
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }
}
