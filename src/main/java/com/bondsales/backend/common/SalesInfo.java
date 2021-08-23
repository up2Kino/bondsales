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

    private String username;
    private String bondname;
}
