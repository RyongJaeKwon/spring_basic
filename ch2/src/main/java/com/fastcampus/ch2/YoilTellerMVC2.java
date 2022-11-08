package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// ������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC2 { // http://localhost/ch2/getYoilMVC2?year=2021&month=10&day=1

// ��Ʈ�ѷ� �޼����� ��ȯŸ�� - ���ε� url�� ���ܾ �� �̸����� ��ȯ (���⼱ getYoilMVC2�� �� �̸����� ��ȯ)
	@RequestMapping("/getYoilMVC2")
	public void main(int year, int month, int day, Model model) throws IOException {

		// 1. ��ȿ�� �˻�
//		if (!isValid(year, month, day)) {
//			return "yoilError";
//		}

		// 2. ���� ���
		char yoil = getYoil(year, month, day);
		
		// 3. ����� ����� model�� ����
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);

//		return "yoil"; // /WEB-INF/views/yoil.jsp

	}

	private boolean isValid(int year, int month, int day) {

		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}

}