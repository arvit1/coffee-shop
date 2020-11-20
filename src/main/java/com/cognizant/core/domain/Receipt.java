package com.cognizant.core.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Receipt {
    private static final String CTE_CURRENCY = "CHF";
    String id;
    Date date = new Date();
    List<Item> items = new ArrayList<Item>();
    Double total;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id Receipt: ").append(id).append("\n");
        sb.append("Date      : ").append(date).append("\n");
        for (Item i : items) {
            sb.append(i.toString());
        }
        sb.append("Total     : ").append(String.format("%.2f", total)).append(" ").append(CTE_CURRENCY).append("\n");
        return sb.toString();
    }
}
