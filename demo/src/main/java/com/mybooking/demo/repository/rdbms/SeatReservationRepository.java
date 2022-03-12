package com.mybooking.demo.repository.rdbms;

import java.util.Set;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.mybooking.demo.model.rdbms.SeatReservation;

@Repository
public interface SeatReservationRepository extends JpaRepository<SeatReservation, Integer> {

	/* As per documents, it works with Oracle and other dbs
	 * Ref: https://blog.mimacom.com/testing-pessimistic-locking-handling-spring-boot-jpa/
	 * https://stackoverflow.com/questions/66438900/jpa-pessimistic-read-does-not-time-out-in-the-specified-period
	 * https://stackoverflow.com/questions/29765934/how-to-specify-lock-timeout-in-spring-data-jpa-query
	 * 
	 * */ 
//	@Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
//	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
//	public SeatReservation findBySeatIdAndBookingStatus(Integer seatId, String bookingStatus);
	
	/* For MariaDB with Native Query: https://mariadb.com/kb/en/wait-and-nowait/ */
//	@Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
//	@Query(value = "SELECT * FROM seat_reservation WHERE seatId=? and bookingStatus = ? FOR UPDATE NOWAIT", nativeQuery = true)
//	@Query(value = "SELECT * FROM seat_reservation WHERE seatId=? and bookingStatus = ? FOR UPDATE WAIT 0", nativeQuery = true)
//	@Query(value = "SELECT * FROM seat_reservation WHERE seatId=? and bookingStatus = ? FOR UPDATE SKIP LOCKED", nativeQuery = true)
//	public SeatReservation findBySeatIdAndBookingStatus(Integer seatId, String bookingStatus);
		
	// For MariaDB without native query
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({ @QueryHint(name = "javax.persistence.lock.timeout", value = "0") })
	public Set<SeatReservation> findBySeatIdInAndBookingStatus(Set<Long> seatIds, Integer bookingStatus);
}
