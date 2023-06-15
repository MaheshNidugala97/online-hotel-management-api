package com.sdp.hms.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdp.hms.dao.BookingRepository;
import com.sdp.hms.dao.RoomRepository;
import com.sdp.hms.dao.TransactionRepository;
import com.sdp.hms.dto.CheckoutDto;
import com.sdp.hms.entity.Transaction;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	RoomRepository roomRepository;

	private final String checkInTime = "12:00:00";
	private final String checkOutTime = "12:00:00";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public void checkout(String roomNumbers, CheckoutDto checkoutDto) {
		List<Integer> listRoomNumbers = new ArrayList<>();
		String[] arrayRoomNumbers = roomNumbers.split(",");
		for (String roomNumber : arrayRoomNumbers) {
			Integer roomNo = Integer.parseInt(roomNumber);
			listRoomNumbers.add(roomNo);
		}
		Transaction transaction = new Transaction();
		transaction.setUsername(checkoutDto.getUsername());
		transaction.setBookingId(checkoutDto.getBookingId());
		transaction.setArrivalDate(LocalDateTime.parse(checkoutDto.getArrivalDate() + " " + checkInTime, formatter));
		transaction.setDeptDate(LocalDateTime.parse(checkoutDto.getDeptDate() + " " + checkOutTime, formatter));
		transaction.setFinalCost(checkoutDto.getFinalCost());
		transactionRepository.save(transaction);
		bookingRepository.deleteById(checkoutDto.getBookingId());
		roomRepository.updateRoomDates(null, null, listRoomNumbers);

	}

}
