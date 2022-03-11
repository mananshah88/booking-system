package com.mybooking.demo.dto.upload;

import java.util.List;

public class UploadRequestDTO {

	private Long theaterId;
	private List<ScreenDto> screens;

	public Long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}

	public List<ScreenDto> getScreens() {
		return screens;
	}

	public void setScreens(List<ScreenDto> screens) {
		this.screens = screens;
	}

	@Override
	public String toString() {
		return "UploadRequestDTO [theaterId=" + theaterId + ", screens=" + screens + "]";
	}

	public UploadRequestDTO(Long theaterId, List<ScreenDto> screens) {
		super();
		this.theaterId = theaterId;
		this.screens = screens;
	}

	public UploadRequestDTO() {
		super();
	}

}

//[
// {
//     "theaterId": 10, /* PVR Cinema Id */
//     "screens": [
//         {
//             "screenId": 21, /* screen:1 */
//             "schedule": [
//                 {
//                     "startime": "2022-10-12 10:00:00",
//                     "movieId": "123",
//                     "priceQunatityDetail": [
//                         {
//                             "bookingTypeId": 1,
//                             "price": 100.0,
//                             "seats": 50
//                         },
//                         {
//                             "bookingTypeId": 2,
//                             "price": 80.0,
//                             "seats": 50
//                         }
//                     ]
//                 }
//             ]
//         }
//     ]
// }
//]
