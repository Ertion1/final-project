package com.sda.restaurant_management_system.dto.filterDTO;

import lombok.Data;

import java.util.List;
@Data
public class Filters {
    private List <FilterDTO> filters;
    private FilterLogicalConnection logical;

}
