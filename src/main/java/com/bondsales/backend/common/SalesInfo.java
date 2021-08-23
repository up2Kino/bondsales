package com.bondsales.backend.common;

import lombok.Data;

import java.util.Date;

@Data
public class SalesInfo {
    private Long sellid;

    private Long userid;

    private Long bondid;

    private Long price;

    private Date date;

    private Date startDate;

    private Date endDate;

    private Long bondidUpper = Long.MAX_VALUE;
    private Long useridUpper = Long.MAX_VALUE;
}
