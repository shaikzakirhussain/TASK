package com.place.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.place.entity.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {

	public List<Location> findByplaceName(String placeName);
	public List<Location> findByplaceDesc(String placeDesc);
}
