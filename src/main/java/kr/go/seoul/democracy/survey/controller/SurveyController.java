package kr.go.seoul.democracy.survey.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.democracy.survey.model.service.SurveyService;
import kr.go.seoul.democracy.survey.model.vo.Survey;
import kr.go.seoul.democracy.survey.model.vo.SurveyQ;

@Controller
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@RequestMapping(value="/survey/adminWriteForm.do", method = RequestMethod.GET)
	public String adminWriteForm() {
		return "survey/adminWriteForm";
	}
	
	@RequestMapping(value="/survey/adminWrite.do", method = RequestMethod.POST)
	public void adminWrite(//HttpServletRequest request,
							//HttpServletResponse response,
							//@RequestParam int proposalNo,
							@RequestParam String title, //설문지 제목
							@RequestParam String qNo, //몇번까지 작성했는지
							@RequestParam String[] contentQValue, // 질문
							@RequestParam String[] questionInputType, // 타입
							@RequestParam String[] questionContent) throws IOException { // 번호/문항/문항/문항
		
		int proposalNo=46;
		int question=Integer.parseInt(qNo);
		//새 설문 생성
		Survey survey=new Survey(proposalNo,title);
		int resultSurvey=surveyService.addSurvey(survey);
		
		//새 설문 내용
		for(int i=0;i<contentQValue.length;i++) {
			String[] contentQArray=contentQValue[i].split("/");
			System.out.println(contentQArray);
		}
		
		/*String[] contentQArray=contentQValue.split(",");
		System.out.println("5 "+contentQArray);
		String[] inputTypeArray=questionInputType.split(",");
		String[] contentArray=null;*/
		
		/*String qInputType[]=questionInputType.split(",");
		for(int i=0;i<qInputType.length;i++) {
			String qinputType[]=qInputType[i].split("/");
			inputTypeArray[i]=qinputType[1];
		}*/
		/*String[] contentQ1=questionContent.split(",");
		System.out.println("4 "+contentQ1);
		for(int i=0;i<contentQ1.length;i++) {
			String[] contentQ2=contentQ1[i].split("/");
			System.out.println("1 "+contentQ2);
			
			String content=contentQ2[1];
			System.out.println("2 "+content);
			if(contentQ2.length>1) {
				for(int j=2;j<contentQ2.length;j++) {
					content += "/"+contentQ2[j];
				}
			}
			contentArray[i]=content;
		}
		
		System.out.println("5 "+contentArray);
		ArrayList<SurveyQ> list=new ArrayList<SurveyQ>();
		
		for(int i=0;i<question;i++) {
			char inputType=inputTypeArray[i].charAt(0);
			String content=contentArray[i];
			String contentQ=contentQArray[i];
			
			System.out.println(inputType);
			System.out.println(content);
			System.out.println(contentQ);
			
			SurveyQ surveyQ=new SurveyQ(survey.getSurveyNo(),i+1,inputType,content,contentQ);
			list.add(surveyQ);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int resultSurveyQ=surveyService.addQuestion(list);
		if(resultSurveyQ>0) response.getWriter().println("<script>alert('설문폼 작성 완료');location.replace('/proposal/allList.do');</script>");
		else response.sendRedirect("survey/error");*/
	}
}
