package org.zerock.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;



// servlet-context.xml에 component-scan으로 설정된 패키지 아래의클래스만 찾아서 생성해준다.


@Controller
//sample이라고앞에 경로 명시해준경우에만 들어온다.
@RequestMapping("/sample")
@Log4j  //pom.xml에서 log4j   scope runtime 지워야 에러안뜸 
public class SampleController {
	
	//url 맵핑이랑 연결될 수 있는 기능을 가진 것이 @Controller
	//log info 가 콘솔에 뜰때  Mapped를 보면 맵핑이 되었따는 로그가 보인다 
	
	
	//RequestMapping 에 ""만 치면  위에 적은(포함하는 클래스에서 적은)  /sample 을 치면 들어오는 메소드로 명시가능 
	//sample만 치면  basic()메소드가 실행
	@RequestMapping("")
	public void basic() {
		log.info("basic....");
	}
	
	
	//RequestMapping을 쓸때 get 방식으로 받으려면 value를 써야한다. RequestMapping의 파라미터이름이 value라고 생각하면 된다.
	//그리고 method설정 필요
	//RequestMapping에 아무런 조건을 안주면(위처럼) , 모든 방식을 허용한다는 이야기 
	
	
	//@RequestMapping(value = "basicOnlyGet" , method=RequestMethod.GET)
	//RequestMapping을 쓰면 너무 길어지니까 GetMapping으로 간단하게도 명시가능하다 . 
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basicOnlyGet.....");
		
	}
	
	
	//Controller 메서드가 사용할 수 있는 리턴 타입은 이 다양하게 존재
	
	//String 은 jsp를 이용하는경우  ,  jsp파일의 경로와 파일이름을 나타내기 위해서 사용한다.
	//void 는 호출하는 URL과 동일한 이름의 jsp를 의미한다. (url.jsp)   void 인경우는폴더경로 잘 볼것 , 호출url을 그대로 쓰니 
	// VO, DTD 타입  : 주로 JSON 타입의 데이터를 만들어 반환할 떄씀
	//ResponseEntity 타입 :  주로 response 할 떄 http 헤더 정보와 내용을 가공하는 용도
	//Model , ModelAndView  : Model로 데이터를 반환하거나 화면까지 같이 지정하는 경우에 사용
	//HttpHeaders :  응답에 내용 없이 Http 헤더 메시지만 전달하는 용도로 사용한다
	
	
	
	//다른 jsp를 선언해서 사용할떄 리턴타입을 String으로 하는경우
	
	@GetMapping("/stringGet")
	public String stringGet() {
		
		//sample 로 들어온 상태에서 뒤에  /stringGet이 들어오면 return을 통해 test/string.jsp로 이동 
		
		
		log.info("String Get ...");
		//찾는 위치가 WEB-INF/view/ + string + .jsp
		return "test/string";
	}
	
	@GetMapping("/modelAndView")
	public ModelAndView modelAndView() {

		ModelAndView mav = new ModelAndView();
		
		//찾아야할 jsp의 정보를 세팅  /WEB-INF/views/modelAndView.jsp 로 찾아간다는 의미  
		mav.setViewName("modelAndView");
		//jsp에서 사용할 데이터 세팅  ->  request에 담긴다. 
		mav.addObject("name","김경민");
		
		return mav;
		
	}
	
	
	///------------넘어오는 파라미터 데이터수집하기 
	
	@GetMapping("/name")
	public void getName(String name) {
		log.info(name);
		//데이터가 정해진 형식으로 넘어오지않더라도 문제가 생기지 않는다는 특징이 있다 (void, String)  , 근데 int인경우에는
		//값을  못 받은 경우 오류 발생을 시킴 , 그래서 페이지 번호라던가 그런거 받아올 때는 좋을듯 
		//jsp 에서는 param 으로 받아와야한다.  그냥 get방식으로 name에 해당되는 값을 넘기더라도 , ${name}을써도 값을 못받는다
		
	}
	
	//int는 값이 넘어오지않으면 오류를 발생시키니 , 값이 넘어오지  않으면 1로 세팅
	//아래의 defaultValue 기능으로 1 설정가능 , 1에는 쌍따옴표해야함 , getParameter 들은 모두 문자열이니까
	@GetMapping("/list")
	public void getList(@RequestParam(defaultValue = "10", name="p") int page) {
		
		//name 은 p 라고 하면 인자값을 p 라고 받겠다.  즉 list?page=20 이렇게 써도 p가 아니라 page로 받았기 때문에
		//값을 못 받아서 ,기본값인 10으로 세팅하여 준다
		
		//list?p=20  라고하면 20으로 받는다
		//넘어오는 값과 변수 이름이 다르면 사용해야만 한다 , 변수 이름이 너무 긴경우 
		
		log.info(page);
		
	}
	
	
	//똑같은 파라메터로 여러개의 데이터받기
	@GetMapping("/nos")
	public void getNos(int nos[]) {
		log.info(Arrays.toString(nos));
		//  /nos?nos=1&nos=10  이런식으로 넘긴경우 
		//만약 배열로 선언 안하면 맨앞에 한 개만 받고 끝 
		//어레이 리스트로 응용가능  
		
	}
	
	
	//형식이 다른 여러개의 데이터 들은 클래스를 만든다 
	//data?name=kim&age=15 이런식으로 사
	@GetMapping("/data")
	public void getDate(DataVO vo) {
		log.info(vo);
	}
	
	
	
	//순수 데이터( 객체라던가 값들 ) 를 넘기고싶을떄 , jsp로 넘어가지 않고  ,, 그럴떄는 @ResponseBody를 사용한다 
	
	@GetMapping("/getObject")
	public @ResponseBody DataVO getObject() {

		DataVO vo = new DataVO();
		vo.setName("kim");
		vo.setAge(50);
		
		log.info(vo);
		
		return vo;
		
		//결과는  JSON형식으로  {"name":"kim","age":50} 이렇게 보여준다 
		
	}
	
	//************파일 업로드 처리 메서드 ****************
	//파일을 올릴 수 있는 입력 창으로 이동하는 메서드 
	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}
	
	//전송 되는 파일을 처리하는 메서드 - 파일 여러개를 첨부 할 수 있는 메소드  반드시 postMapping 
	@PostMapping("/upload")
	public String upload(ArrayList<MultipartFile> files,Model model) {
		
		//람다식 ,  files를 받아서 하나하나를 file이라는 변수로 둔다 .  매개인자 자료형 생략 가능 
		// 람다식의 기본구조는  (타입 매개변수 ...) - > {실행문} 
		
		ArrayList<FileInfo> list = new ArrayList<FileInfo>();
		
		
		//저장 하기위해서 처리가 또 추가적으로 필요함
		
		//저장위
		String path = "/Users/kyungminkim/Desktop/mylocal/study/upload/";
		//중복을 피하기 위한 숫자 -> 파일명 앞에 붙이는 것으로 함 (여기서는 ㅇㅇ) 
		int cnt= 0 ;
		
		
		files.forEach(file->{
			log.info("---------------------------------------------------------");
			String fileName = file.getOriginalFilename(); // 서버로 들어오기전에 원래 파일 네임   //서버에서는 중복방지를위해 이름을 바꿔서 등록 할 거니까 
			long size = file.getSize();
			
			FileInfo fi = new FileInfo();
			fi.setFileName(fileName);
			fi.setSize(size);
			list.add(fi);
			
			log.info("원래 파일 명 : " + fileName +" // 파일 사이즈 : "+size);
			
			
			//파일 저장하는 처리  file객체를 transferTo 메소드를 통해 사용  , (++cnt)는 이름앞에 붙이는숫자 
			try {
				cnt++;
				file.transferTo(new File(path,cnt+fileName));
				
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//첨부된 파일의 정보를 jsp로 보내기위해 Model로 담는다.
			
			model.addAttribute("list",list);
			
		});
		
		return "upload";
		
	}
	
	

}
