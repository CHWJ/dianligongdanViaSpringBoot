package com.hdtech.dianligongdan.domain.entity;

import java.time.LocalDateTime;

public class WorkorderDto extends Workorder {
    private String expectArrivaltime;

    public WorkorderDto() {
        super();
    }

    public WorkorderDto(Workorder wo) {
        super(wo);
    }

    public String getExpectArrivaltime() {
        LocalDateTime finishTime = super.getFinishTime();
        LocalDateTime sendTime = super.getSendTime();

        if(sendTime==null || finishTime==null){
            return "";
        }

        return "3天";
    }
}
