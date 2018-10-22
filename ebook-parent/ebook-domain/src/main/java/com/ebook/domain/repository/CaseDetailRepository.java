package com.ebook.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebook.domain.entity.CaseDetail;

public interface CaseDetailRepository extends AbstractRepository<CaseDetail, Long> {

	@Query("FROM CaseDetail cd where cd.company.id = :companyId")
    List<CaseDetail> findAllByCompanyId(@Param("companyId") Long companyId);

}
