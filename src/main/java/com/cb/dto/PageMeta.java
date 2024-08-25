package com.cb.dto;

import java.util.List;


public record PageMeta<T>(List<T> records,
                          Integer totalRecords,
                          Integer recordsPerPage,
                          Integer totalPages) {

}
