/**
 * <p>Project: payBays </p>
 * <p>Package Name: com.webtual.payBays.processor </p>
 * <p>File Name: Processor.java</p>
 * <p>Create Date: Nov 21, 2017 </p>
 * <p>Create Time: 12:50:14 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package com.webtual.payBays.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shantanu Sikdar
 *
 */
public class OneWordProcessor {

	private Map<String, List<Integer>> keyIndexMap(String completeStr){
		Map<String, List<Integer>> goodsMap = new HashMap<>();
		String[] strArr = completeStr.split(" "); 
		for (int i = 0; i < strArr.length; i++) {
			List<Integer> goods;
			if(goodsMap.containsKey(strArr[i])){
				goods = goodsMap.get(strArr[i]);
			}else{
				goods = new ArrayList<>();
			}
			goods.add(i);
			goodsMap.put(strArr[i], goods);
		}
		return goodsMap;
	}
	
	private Map<String, List<Integer>> commonKeyMap(Map<String, List<Integer>> fbMap,Map<String, List<Integer>> liMap){
		Map<String, List<Integer>> commonMap = new HashMap<>(fbMap);
		commonMap.keySet().retainAll(liMap.keySet());
		return commonMap;
	}
	
	private Map<String, List<Integer>> uncommonKeyMap(Map<String, List<Integer>> fbMap,Map<String, List<Integer>> liMap){
		Map<String, List<Integer>> commonMap = new HashMap<>(fbMap);;
		commonMap.keySet().removeAll(liMap.keySet());
		return commonMap;
	}
	
	public static void main(String[] args) {
		OneWordProcessor p= new OneWordProcessor();
		/*String str = "that which is morally right; righteousness. a mysterious balance of good and evil synonyms:	virtue, righteousness, virtuousness, goodness, morality, ethicalness, uprightness, upstandingness, integrity, principle, dignity, rectitude, rightness; More antonyms:	wickedness benefit or advantage to someone or something."+
					"he convinces his father to use his genius for the good of mankind synonyms:	benefit, advantage, profit, gain, interest, welfare, well-being, enjoyment, satisfaction, comfort, ease, convenience; More antonyms:	disadvantage merchandise or possessions. imports of luxury goods synonyms:	merchandise, wares, stock, commodities, line, lot, produce, products, articles, solutions; More BRITISH things to be transported, as distinct from passengers. a means of transporting passengers as well as goods synonyms:	freight, cargo; More informal the genuine article. plural noun: the goods";
*/		
		String strFB = "My name is shantanu";
		String strLN = "My surname is sikdar";
		Map<String, List<Integer>> fbMap=p.keyIndexMap(strFB);
		Map<String, List<Integer>> liMap=p.keyIndexMap(strLN);
		Map<String, List<Integer>> commonMap =p.commonKeyMap(fbMap, liMap);
		System.out.println("commonMap = "+commonMap);
		Map<String, List<Integer>> uncommonMap =p.uncommonKeyMap(fbMap, liMap);
		System.out.println("uncommonMap = "+uncommonMap);
	}
	
	

}
