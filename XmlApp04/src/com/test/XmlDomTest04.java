/*==============================================
 	XMLDomTest04.java
 	- 콘솔 기반 자바 프로그램
 	- XML DOM 활용 → 로컬(local) XML 읽어내기
 	  (VEHICLES.xml)
===============================================*/

package com.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDomTest04
{
	public static void main(String[] args)
	{
		/*
		-------------------------------------------------------------
		NO		MAKE	MODEL		YEAR	STYLE			PRICE
		-------------------------------------------------------------
		1		Dodge	Durango		1998	Sport Utility	18000
		Options -----------------------------------------------------
			Power_Locks : Yes
			Power_Window : Yes
			Stereo : Radio/Cassette/CD
			Air_Conditioning : Yes
			Automatic : Yes
			Four_Wheel_Drive : Full/Partial
			Note : Very clean
		-------------------------------------------------------------
		2		Honda	Civic		1997	Sedan			8000
		Options -----------------------------------------------------
			Power_Locks: Yes
			Power_Window : Yes
			Stereo : Radio/Cassette
			Automatic : Yes
			Note : Like New
		-------------------------------------------------------------
								:
		*/
		try
		{
			// XML DOM 형성을 위해 필요한 리소스 구성/준비
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xmlObj = null;
			
			// XML 파일을 메모르에 로드 → XML DOM 형성
			String url = "VEHICLES.xml";
			xmlObj = builder.parse(url);
			
			// 루트 엘리먼트 접근
			Element root = xmlObj.getDocumentElement();
			
			// 테스트
			//System.out.println(root.getNodeName());
			//--==>> VEHICLES
			
			// 얻어낸 루트 엘리먼트를 활용하여 특정 하위 엘리먼트에 접근
			NodeList vehiclesNodeList = root.getElementsByTagName("VEHICLE");
			
			// 테스트
			// System.out.println(vehiclesNodeList.getLength());
			//--==>> 10
			
			System.out.println("---------------------------------------------------------------");
			System.out.println("NO	MAKE	MODEL	   YEAR		STYLE		PRICE");
			System.out.println("---------------------------------------------------------------");

			for (int i = 0; i < vehiclesNodeList.getLength(); i++)
			{
				Node vehiclesNode = vehiclesNodeList.item(i);
				//  캐스팅
				Element vehiclesElement = (Element)vehiclesNode;
				
				System.out.printf("%2s    %7s %8s  %7s    %13s    %9s%n"
								 ,vehiclesElement.getElementsByTagName("INVENTORY_NUMBER").item(0).getTextContent()
								 ,vehiclesElement.getElementsByTagName("MAKE").item(0).getTextContent()
								 ,vehiclesElement.getElementsByTagName("MODEL").item(0).getTextContent()
								 ,vehiclesElement.getElementsByTagName("YEAR").item(0).getTextContent()
								 ,vehiclesElement.getElementsByTagName("STYLE").item(0).getTextContent()
								 ,vehiclesElement.getElementsByTagName("PRICE").item(0).getTextContent());

				// Option 추가
				System.out.println("Options -------------------------------------------------------");
				
				NodeList options = vehiclesElement.getElementsByTagName("OPTIONS");
				Node option = options.item(0);
				Element optionElement = (Element)option;
				
				NodeList childNodes = optionElement.getChildNodes();
				for (int k=0; k<childNodes.getLength(); k++)
				{
					Node childNode = childNodes.item(k);
					if(childNode.getNodeType() ==  1)
					{
						System.out.printf("		%s : %s%n"
									, childNode.getNodeName()
									, childNode.getTextContent());
					}
				}
				
				System.out.println("---------------------------------------------------------------");
			}
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
}
