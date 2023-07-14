package exercises.src.codesquad.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 2023.7.14(금) 21h5 일정 등록 기능 refectoring 관련 생성
public class PlanItem {
    private Date planDate;
    private String detail;
    private String people = ""; // 초기화 시에는 비어있는 문자열 값으로..

    // Calendar 클래스에서 PlanItem 객체 생성 없이 이 기능/메서드 활용/재사용하기 위해 static으로 선언
    public static Date getDateFromString(String strDate) {
        Date date = null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        } catch (ParseException e) { // 날짜가 제대로 세팅 안 된/안 들어간 경우 -> null이 리턴됨 = 예외 처리
            throw new RuntimeException(e);
        }

        return date;
    }

    public PlanItem(String date, String detail) {
        this.planDate = getDateFromString(date);
        this.detail = detail;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public String getDetail() {
        return detail;
    }

    // todo 추가 학습 = 일정에 참석자 추가하는 기능 구현해보기
    public void addPeople(String name) {
        people += name + ",";
    }
}
