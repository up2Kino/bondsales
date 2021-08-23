package com.bondsales.backend.common;

import lombok.Data;

import java.util.Date;

@Data
public class SalesInfo {
    private Long sellid;

    private Long userid;

    private String username;

    private Long bondid;

    private String bondname;

    private Long price;

    private Date date;

    private Date startDate;

    private Date endDate;
}
