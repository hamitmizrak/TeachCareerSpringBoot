package com.hamitmizrak.mvc.pagingandsorting;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPagingSorting extends PagingAndSortingRepository<PagingSortingEntity,Long> {
}
