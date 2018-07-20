/**
 * <p>Project: payBays </p>
 * <p>Package Name: com.webtual.payBays.processor </p>
 * <p>File Name: PhraseProcessor.java</p>
 * <p>Create Date: Nov 21, 2017 </p>
 * <p>Create Time: 11:50:14 PM </p>
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
public class PhraseProcessor {
	
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
