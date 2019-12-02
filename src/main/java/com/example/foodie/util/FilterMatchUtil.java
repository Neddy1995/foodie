/**  
 * Project Name:YDGA  
 * File Name:FilterMatchUtil.java  
 * Package Name:com.ai.scp.utils  
 * Date:2017年7月27日上午9:36:35  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.example.foodie.util;

import java.util.List;


public class FilterMatchUtil
{
    /** 
     * @Title isEndWithListStr
     * @Description 检测字符串是否以结尾字符串列表中的某个字符串结尾 
     * @param beMatchedStr 待匹配的字符串
     * @param endList 结尾字符串列表
     * @return 
     */
    public static boolean isEndWithListStr(String beMatchedStr, List<String> endList)
    {
        for (String endStr : endList)
        {
            if(beMatchedStr.endsWith(endStr))
            {
                return true;
            }
        }
        return false;
    }
}
  
