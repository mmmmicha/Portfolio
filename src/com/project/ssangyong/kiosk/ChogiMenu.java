package com.project.ssangyong.kiosk;
// 기본 식당을 세팅하는 class

import java.util.Scanner;

public class ChogiMenu extends Main
{
	public void kor()   //ghan = new TreeMap<String, GagaeVO>();  -->한식 기초설정가게(자료구조에 담기)
   {
      ghan.put("밥맛스러운광현",new GagaeVO(1,"정광현","01090170749"));    

      menu.put(num++,new MenusVO("제육볶음","밥맛스러운광현",6000,15));
      menu.put(num++,new MenusVO("오므라이스","밥맛스러운광현",4500,15));
      menu.put(num++,new MenusVO("뚝배기불고기","밥맛스러운광현",6000,10));
      menu.put(num++,new MenusVO("김치찌개","밥맛스러운광현",7000,15));
      menu.put(num++,new MenusVO("순두부찌개","밥맛스러운광현",7000,15));

      ghan.put("민하의쌈싸라",new GagaeVO(1,"정민하","01030602307"));

      menu.put(num++,new MenusVO("삼겹살쌈밥","민하의쌈싸라",7000,20));
      menu.put(num++,new MenusVO("불고기쌈밥","민하의쌈싸라",7000,15));
      menu.put(num++,new MenusVO("소불고기쌈밥","민하의쌈싸라",8000,15));
      menu.put(num++,new MenusVO("제육볶음","민하의쌈싸라",6500,15));
      menu.put(num++,new MenusVO("오징어볶음쌈밥","민하의쌈싸라",7000,20));   
   }

   public void jap()  //gjap = new TreeMap<String, GagaeVO>();	 -->일식 기초설정가게(자료구조에 담기)
   {
      gjap.put("스시를소원합니다",new GagaeVO(3,"김소원","01084406061"));
      
      menu.put(num++,new MenusVO("모둠스시","스시를소원합니다",13000,15));
      menu.put(num++,new MenusVO("활어스시","스시를소원합니다",15000,15));
      menu.put(num++,new MenusVO("알탕","스시를소원합니다",7000,10));
      menu.put(num++,new MenusVO("연어스시","스시를소원합니다",10000,10));
      menu.put(num++,new MenusVO("광어스시","스시를소원합니다",12000,15));

      gjap.put("스시를범하다",new GagaeVO(3,"김종범","01053341073"));
      
      menu.put(num++,new MenusVO("모둠스시","스시를범하다",13500,15));
      menu.put(num++,new MenusVO("활어스시","스시를범하다",14000,25));
      menu.put(num++,new MenusVO("알탕","스시를범하다",6000,15));
      menu.put(num++,new MenusVO("우동","스시를범하다",5500,10));
      menu.put(num++,new MenusVO("모둠회","스시를범하다",38000,20));
   }

	public void chi() //gchi = new TreeMap<String, GagaeVO>();	-->중식 기초설정가게(자료구조에 담기)
	{
		gchi.put("광현수타면",new GagaeVO(2,"정광현","0236920369"));
		
		menu.put(num++,new MenusVO("짜장면","광현수타면",3500,10));
		menu.put(num++,new MenusVO("짬뽕","광현수타면",4000,10));
		menu.put(num++,new MenusVO("우동","광현수타면",6000,10));
		menu.put(num++,new MenusVO("볶음밥","광현수타면",4000,10));
		menu.put(num++,new MenusVO("짬짜면","광현수타면",5000,15));
		menu.put(num++,new MenusVO("탕수육","광현수타면",12000,20));
		menu.put(num++,new MenusVO("깐쇼새우","광현수타면",15000,25));
		
		gchi.put("중국집의정석",new GagaeVO(2,"이정석","0238729677"));

		menu.put(num++,new MenusVO("짜장면","중국집의정석",5000,5));
		menu.put(num++,new MenusVO("간짜장","중국집의정석",5500,7));
		menu.put(num++,new MenusVO("짬뽕","중국집의정석",5500,5));
		menu.put(num++,new MenusVO("중국냉면","중국집의정석",7000,10));
		menu.put(num++,new MenusVO("탕수육","중국집의정석",15000,15));
		menu.put(num++,new MenusVO("볶음밥","중국집의정석",6000,10));
		menu.put(num++,new MenusVO("양장피","중국집의정석",25000,20));
	}

	public void bun() //gbun = new TreeMap<String, GagaeVO>();	-->분식 기초설정가게(자료구조에 담기)
	{
		gbun.put("은채의인생떡볶이",new GagaeVO(4,"이은채","0283512866"));

		menu.put(num++,new MenusVO("떡볶이","은채의인생떡볶이",3500,3));
		menu.put(num++,new MenusVO("튀김","은채의인생떡볶이",3500,3));
		menu.put(num++,new MenusVO("순대","은채의인생떡볶이",3000,5));
		menu.put(num++,new MenusVO("오뎅","은채의인생떡볶이",700,3));
		menu.put(num++,new MenusVO("쫄면","은채의인생떡볶이",5000,10));
		menu.put(num++,new MenusVO("라면","은채의인생떡볶이",4000,10));
		menu.put(num++,new MenusVO("김밥","은채의인생떡볶이",2500,5));
		
		gbun.put("민하의욜로분식",new GagaeVO(4,"정민하","0245723212"));

		menu.put(num++,new MenusVO("떡볶이","민하의욜로분식",2500,3));
		menu.put(num++,new MenusVO("치즈떡볶이","민하의욜로분식",3000,5));
		menu.put(num++,new MenusVO("순대","민하의욜로분식",3000,3));
		menu.put(num++,new MenusVO("우동","민하의욜로분식",4000,10));
		menu.put(num++,new MenusVO("컵밥","민하의욜로분식",3000,10));
		menu.put(num++,new MenusVO("튀김","민하의욜로분식",2500,5));
		menu.put(num++,new MenusVO("잔치국수","민하의욜로분식",4000,10));
	}

	public void key()   //기초설정한 가게 마스터키 고정값 부여
	{
		mas.put("mas11111111", "김소원");
		mas.put("mas22222222", "이은채");
		mas.put("mas33333333", "정광현");
		mas.put("mas55555555", "김종범");
		mas.put("mas77777777", "정민하");
		mas.put("mas88888888", "이정석");


	}
}