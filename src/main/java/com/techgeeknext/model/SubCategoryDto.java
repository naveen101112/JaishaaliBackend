package com.techgeeknext.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCategoryDto extends RequestDto {
    private long id;
    private int categoryId;
    private String name;
    private String price;
}
